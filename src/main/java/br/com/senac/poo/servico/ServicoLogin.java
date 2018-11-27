package br.com.senac.poo.servico;

import br.com.senac.poo.dao.DaoLogin;
import br.com.senac.poo.model.Login;

public class ServicoLogin {

    public static boolean insertLogin(Login login) throws Exception {
        try {
            DaoLogin.setRegistro(login);

        } catch (Exception ex) {
            throw new Exception("Erro na fonte de dados. \n\n" + ex.getMessage());
        }

        return true;
    }

    public static Login getById(int id) throws Exception {

        Login login;

        try {
            login = DaoLogin.getById(id);
        } catch (Exception ex) {
            throw new Exception("Falha para consultar registro. \n\n" + ex.getMessage());
        }

        return login;
    }

    public static Login validarLogin(String login, String senha) throws Exception {
        
        Login usuario = DaoLogin.validarLogin(login, senha);

       if (usuario.getId() == 0 || !senha.equals(usuario.getSenha())) {
            throw new Exception("Atenção! Login/Senha incorretos ou usuário inexistente.");
        }

        return usuario;
    }
}
