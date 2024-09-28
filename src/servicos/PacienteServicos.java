/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import dao.DAOFactory;
import dao.PacienteDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Paciente;

/**
 *
 * @author senacead
 */
/*
A classe PacienteServicos representa a camada de serviços da aplicação, ela utiliza a classe PacienteDAO para realizar
operações de leitura e escrita no banco de dados.
 */
public class PacienteServicos {

    // Método para cadastrar um paciente
    public void cadastrarPaciente(Paciente pac) throws SQLException {

        // Busca da Fábrica um obj. PacienteDAO
        PacienteDAO pacDAO = DAOFactory.getPacienteDAO();

        // Verificar se já existe um paciente com mesmo CPF
        if (pacDAO.existePacienteCPF(pac.getCpf())) {
            throw new SQLException("Já existe um paciente cadastrado com esse CPF");
        }

        // Chamando método cadastrarPaciente para enviar o obj. pac
        pacDAO.cadastrarPaciente(pac);
    }

    // Método para buscar um paciente por ID
    public ArrayList<Paciente> buscarPacienteId(String query) throws SQLException {

        // Busca da Fábrica um obj. PacienteDAO
        PacienteDAO pacDAO = DAOFactory.getPacienteDAO();

        // Chamando método buscarPaciente para buscar o paciente pelo ID
        return pacDAO.buscarPacienteId(query);
    }

    // Método para buscar um paciente por Nome
    public ArrayList<Paciente> buscarPacienteNome(String query) throws SQLException {

        // Busca da Fábrica um obj. PacienteDAO
        PacienteDAO pacDAO = DAOFactory.getPacienteDAO();

        // Chamando método buscarPaciente para buscar o paciente pelo ID
        return pacDAO.buscarPacienteNome(query);
    }

    // Método para buscar um paciente por CPF
    public ArrayList<Paciente> buscarPacienteCpf(String query) throws SQLException {

        // Busca da Fábrica um obj. PacienteDAO
        PacienteDAO pacDAO = DAOFactory.getPacienteDAO();

        // Chamando método buscarPaciente para buscar o paciente pelo ID
        return pacDAO.buscarPacienteCpf(query);
    }

    // Método para buscar todos os pacientes
    public ArrayList<Paciente> buscarPaciente() throws SQLException {

        // Busca da Fábrica um obj. PacienteDAO
        PacienteDAO pacDAO = DAOFactory.getPacienteDAO();

        // Chamando método buscarPaciente para buscar todos os pacientes
        return pacDAO.buscarPaciente();
    }

    // Método para validar CPF
    public boolean validarCpf(String cpf) {
        // Regex para validar o formato do CPF (xxx.xxx.xxx-xx
        String cpfFormato = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";
        if (!cpf.matches(cpfFormato)) {
            return false;
        }
        return true;
    }

    // Método para validar telefone
    public boolean validarTelefone(String telefone) {
        // Regex para validar o formato de telefone (xx) xxxx-xxxx ou (xx) xxxxx-xxxx
        String telefoneFormato = "\\(\\d{2}\\) \\d{4,5}-\\d{4}";
        if (!telefone.matches(telefoneFormato)) {
            return false;
        }
        return true;
    }

    // Método para validar e-mail
    public boolean validarEmail(String email) {
        // Regex para validar o formato de email
        String emailFormato = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        if (!email.matches(emailFormato)) {
            return false;
        }
        return true;
    }

}
