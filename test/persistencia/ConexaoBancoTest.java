package persistencia;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class ConexaoBancoTest {

    private ConexaoBanco conexaoBanco;

    @Before
    public void setUp() {
        conexaoBanco = new ConexaoBanco();
    }

    @Test
    public void getConexao() throws SQLException  {
        Connection con = conexaoBanco.getConexao();
        assertNotNull(con);
        assertFalse(con.isClosed());
    }
}