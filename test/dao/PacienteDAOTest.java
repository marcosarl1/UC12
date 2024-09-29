package dao;

import modelo.Paciente;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PacienteDAOTest {

    private PacienteDAO pacienteDAO;

    @Before
    public void setUp() {
        pacienteDAO = new PacienteDAO();
    }

    @Test
    public void existePacienteCPF() throws SQLException {
        assertTrue(pacienteDAO.existePacienteCPF("123.456.789-00"));
        assertFalse(pacienteDAO.existePacienteCPF("111.111.111-11"));
    }

    @Test(expected = SQLException.class)
    public void cadastrarPaciente() throws SQLException {
        pacienteDAO = mock(PacienteDAO.class);

        Paciente paciente1 = new Paciente();
        paciente1.setNome("Marcos");
        paciente1.setCpf("999.999.999-99");
        paciente1.setEndereco("Rua das ruas");
        paciente1.setTelefone("(99) 99999-9999");
        paciente1.setDataNascimento(Date.valueOf("2000-01-01"));
        paciente1.setConvenio(2);

        when(pacienteDAO.existePacienteCPF(paciente1.getCpf())).thenReturn(false);

        pacienteDAO.cadastrarPaciente(paciente1);

        Paciente pacienteCpfDuplicado = new Paciente();
        pacienteCpfDuplicado.setNome("Outro Marcos");
        pacienteCpfDuplicado.setCpf("999.999.999-99"); // Mesmo CPF
        pacienteCpfDuplicado.setEndereco("Outra Rua");
        pacienteCpfDuplicado.setTelefone("(99) 99999-8888");
        pacienteCpfDuplicado.setDataNascimento(Date.valueOf("1995-05-05"));
        pacienteCpfDuplicado.setConvenio(3);

        when(pacienteDAO.existePacienteCPF(pacienteCpfDuplicado.getCpf())).thenReturn(true);

        doThrow(new SQLException("CPF duplicado")).when(pacienteDAO).cadastrarPaciente(pacienteCpfDuplicado);

        pacienteDAO.cadastrarPaciente(pacienteCpfDuplicado);
    }


    @Test
    public void buscarPacienteId() throws SQLException {
        List<Paciente> pacientesIdValido = pacienteDAO.buscarPacienteId("1");
        assertNotNull(pacientesIdValido);

        List<Paciente> pacientesIdInvalido = pacienteDAO.buscarPacienteId("999");
        assertTrue(pacientesIdInvalido.isEmpty());
    }

    @Test
    public void buscarPacienteNome() throws SQLException {
        List<Paciente> pacientesNomeValido = pacienteDAO.buscarPacienteNome("Maria");
        assertNotNull(pacientesNomeValido);

        List<Paciente> pacientesNomeInvalido = pacienteDAO.buscarPacienteNome("Nãoexisto");
        assertTrue(pacientesNomeInvalido.isEmpty());
    }

    @Test
    public void buscarPacienteCpf() throws SQLException {
        List<Paciente> pacientesCpfValido = pacienteDAO.buscarPacienteCpf("123.456.789-00");
        assertNotNull(pacientesCpfValido);

        List<Paciente> pacientesCpfInvalido = pacienteDAO.buscarPacienteCpf("000.000.000-00");
        assertTrue(pacientesCpfInvalido.isEmpty());

    }

    @Test
    public void buscarPaciente() throws SQLException {
        List<Paciente> pacientes = pacienteDAO.buscarPaciente();
        assertNotNull(pacientes);
    }
}