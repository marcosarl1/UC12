package servicos;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class PacienteServicosTest {

    private PacienteServicos pacienteServicos;

    @Before
    public void setUp() {
        pacienteServicos = new PacienteServicos();
    }

    @Test
    public void validarCpf() {
        assertTrue(pacienteServicos.validarCpf("123.456.789-00"));
        assertFalse(pacienteServicos.validarCpf("12345678900"));
        assertFalse(pacienteServicos.validarCpf("123.456.789-0A"));
    }

    @Test
    public void validarTelefone() {
        assertTrue(pacienteServicos.validarTelefone("(12) 3456-7890"));
        assertTrue(pacienteServicos.validarTelefone("(12) 34567-8901"));
        assertFalse(pacienteServicos.validarTelefone("1234567890"));
        assertFalse(pacienteServicos.validarTelefone("(12) 3456-789A"));
    }

    @Test
    public void validarEmail() {
        assertTrue(pacienteServicos.validarEmail("teste@exemplo.com"));
        assertFalse(pacienteServicos.validarEmail("teste@.com"));
        assertFalse(pacienteServicos.validarEmail("teste@com"));
        assertFalse(pacienteServicos.validarEmail("teste.com"));
    }
}