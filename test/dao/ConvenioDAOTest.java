package dao;

import modelo.Convenio;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ConvenioDAOTest {

    private ConvenioDAO convenioDAO;

    @Before
    public void setUp() {
        convenioDAO = new ConvenioDAO();
    }

    @Test
    public void buscarcConvenios() throws SQLException {
        List<Convenio> convenios = convenioDAO.buscarcConvenios();
        assertNotNull(convenios);
        assertFalse(convenios.isEmpty());
    }

    @Test
    public void buscarConvenioFiltro() throws SQLException {
        Convenio convenio = convenioDAO.buscarConvenioFiltro("Unimed");
        assertNotNull(convenio);
        assertEquals("Unimed", convenio.getNomeConvenio());
    }
}