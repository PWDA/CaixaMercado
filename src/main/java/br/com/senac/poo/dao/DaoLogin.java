package br.com.senac.poo.dao;

import br.com.senac.poo.db.utils.ConnectionUtils;
import br.com.senac.poo.model.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoLogin {
    
    public static boolean update(Login login)
            throws SQLException, Exception {
        
        Connection connection = ConnectionUtils.getConnection();
        
        String sqlComando = "UPDATE TS_LOGIN SET LOGIN=?, SENHA=?, FK_FUNCIONARIO=?, PERMISSAO=?,"
                + "DH_ALTERACAO= NOW() WHERE (PK_ID=?)";
        
        PreparedStatement pst = connection.prepareStatement(sqlComando);
        
        try {
            
            pst.setString(1, login.getLogin());
            pst.setString(2, login.getSenha());
            pst.setInt(3, login.getFunc());
            pst.setString(4, login.getPermissao());
            pst.setInt(5, login.getId());
            
            pst.execute();
        } finally {
            if (pst != null && !pst.isClosed()) {
                pst.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        
        return true;
    }
    
    public static boolean insert(Login login)
            throws SQLException, Exception {
        
        Connection connection = ConnectionUtils.getConnection();
        
        String sqlComando = "INSERT INTO TS_LOGIN"
                + "(LOGIN, SENHA, PERMISSAO, FK_FUNCIONARIO, DH_INCLUSAO,"
                + "TG_INATIVO) VALUES (?, ?, ?, ?, NOW(), 0);";
        
        PreparedStatement pst = connection.prepareStatement(sqlComando);
        
        try {
            if (connection != null) {
                pst.setString(1, login.getLogin());
                pst.setString(2, login.getSenha());
                pst.setString(3, login.getPermissao());
                pst.setInt(4, login.getFunc());
                
                pst.execute();
            }
        } finally {
            if (pst != null && !pst.isClosed()) {
                pst.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        
        return true;
    }
    
    public static boolean setRegistro(Login login) throws Exception, ClassNotFoundException, SQLException {
        if (login.getId() == 0) {
            return insert(login);
        } else {
            return update(login);
        }
    }
    
    public static Login validarLogin(String login, String senha) throws Exception, ClassNotFoundException, SQLException {
        Login validar = new Login();
        
        if (login == null || login.trim().isEmpty()) {
            return validar;
        } else if (senha == null || senha.trim().isEmpty()) {
            return validar;
        }
        
        Connection connection = ConnectionUtils.getConnection();
        
        Statement st = connection.createStatement();
        
        ResultSet rs = st.executeQuery("SELECT * FROM TS_LOGIN WHERE LOGIN ='"
                + login.trim() + "' AND SENHA ='" + senha.trim() + "'");
                                 
        
        while (rs.next()) {
            
            validar.setId(rs.getInt("PK_ID"));
            validar.setLogin(rs.getString("LOGIN"));
            validar.setSenha(rs.getString("SENHA"));
            validar.setPermissao(rs.getString("PERMISSAO"));
            validar.setFunc(rs.getInt("FK_FUNCIONARIO"));
            
            if (validar.getPermissao().equalsIgnoreCase("Gerente")) {
                validar.setAutorizar(2); // Permissão para acesar tudo no sistema
            }else if (validar.getPermissao().equalsIgnoreCase("Caixa")){
                validar.setAutorizar(1); 
            }else if (validar.getPermissao().equalsIgnoreCase("Supervisor")){
                validar.setAutorizar(2); // Permissão para acesar tudo no sistema
            }            
        }
        
        return validar;
    }
    
    public static Login getById(int id) throws Exception, ClassNotFoundException, SQLException {
        Login login = new Login();
        login.setFunc(id);
        Connection connection = ConnectionUtils.getConnection();
        
        Statement st = connection.createStatement();
        
        ResultSet rs = st.executeQuery("SELECT * FROM TS_LOGIN WHERE FK_FUNCIONARIO= " + id);
        
        while (rs.next()) {
            
            login.setId(rs.getInt("PK_ID"));
            login.setLogin(rs.getString("LOGIN"));
            login.setSenha(rs.getString("SENHA"));
            login.setPermissao(rs.getString("PERMISSAO"));            
        }
        
        return login;
    }
    
}