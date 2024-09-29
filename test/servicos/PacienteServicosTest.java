package servicos;

import dao.DAOFactory;
import dao.PacienteDAO;
import modelo.Paciente;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PacienteServicosTest {

    private PacienteServicos pacienteServicos;
    private PacienteDAO pacienteDAO;

    @Before
    public void setUp() {
        pacienteDAO = mock(PacienteDAO.class);
    }

    @Test
    public void cadastrarPaciente() throws SQLException {
        Paciente paciente = new Paciente();
        paciente.setCpf("123.456.789-00");

        when(pacienteDAO.existePacienteCPF(paciente.getCpf())).thenReturn(false);

        pacienteServicos.cadastrarPaciente(paciente);

        verify(pacienteDAO, times(1)).cadastrarPaciente(paciente);
    }

    @Test
    public void buscarPacienteId() {
    }

    @Test
    public void buscarPacienteNome() {
    }

    @Test
    public void buscarPacienteCpf() {
    }

    @Test
    public void buscarPaciente() {
    }

    @Test
    public void validarCpf() {
    }

    @Test
    public void validarTelefone() {
    }

    @Test
    public void validarEmail() {
    }
}