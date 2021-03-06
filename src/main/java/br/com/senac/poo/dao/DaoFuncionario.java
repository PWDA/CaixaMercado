package br.com.senac.poo.dao;

import br.com.senac.poo.db.utils.ConnectionUtils;
import br.com.senac.poo.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DaoFuncionario {

    public static boolean update(Funcionario func)
            throws SQLException, Exception {

        Connection connection = ConnectionUtils.getConnection();

        String sqlComando = "UPDATE TB_FUNCIONARIO SET NOME=?, NRDOC=?, TELEFONE=?,"
                + "DT_NASCIMENTO=?,ENDERECO=?, BAIRRO=?,"
                + "CIDADE=?, CEP=?, EMAIL=?, SEXO=?,"
                + "CARGO=?, DH_ALTERACAO= NOW() WHERE (PK_ID=?)";

        PreparedStatement pst = connection.prepareStatement(sqlComando);

        try {

            pst.setString(1, func.getNome());
            pst.setString(2, func.getDocumento());
            pst.setString(3, func.getTelefone());
            Timestamp t = new Timestamp(func.getDataNascimento().getTime());
            pst.setTimestamp(4, t);
            pst.setString(5, func.getEndereco());
            pst.setString(6, func.getBairro());
            pst.setString(7, func.getCidade());
            pst.setString(8, func.getCep());
            pst.setString(9, func.getEmail());
            pst.setString(10, func.getSexo());
            pst.setString(11, func.getCargo());
            pst.setInt(12, func.getId());

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

    public static boolean insert(Funcionario func)
            throws SQLException, Exception {

        Connection connection = ConnectionUtils.getConnection();

        String sqlComando = "INSERT INTO TB_FUNCIONARIO "
                + "(NOME, NRDOC, TELEFONE, DT_NASCIMENTO, ENDERECO, BAIRRO,"
                + "CIDADE, CEP, EMAIL, SEXO, CARGO, DH_INCLUSAO, TG_INATIVO)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), 0);";

        PreparedStatement pst = connection.prepareStatement(sqlComando);

        try {
            if (connection != null) {

                pst.setString(1, func.getNome());
                pst.setString(2, func.getDocumento());
                pst.setString(3, func.getTelefone());
                Timestamp t = new Timestamp(func.getDataNascimento().getTime());
                pst.setTimestamp(4, t);
                pst.setString(5, func.getEndereco());
                pst.setString(6, func.getBairro());
                pst.setString(7, func.getCidade());
                pst.setString(8, func.getCep());
                pst.setString(9, func.getEmail());
                pst.setString(10, func.getSexo());
                pst.setString(11, func.getCargo());

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

    public static List<Funcionario> selectAll(String condicao, String situacao)
            throws SQLException, ClassNotFoundException {
        String filtro = "";
        String filtro2 = "";

        if (condicao == null) {
            condicao = "";
        } else if (situacao == null) {
            situacao = "";
        }

        List<Funcionario> listarFunc = new ArrayList<Funcionario>();

        Connection connection = ConnectionUtils.getConnection();
        Statement pst = connection.createStatement();

        if (condicao != null || !condicao.trim().isEmpty()) {
            filtro = condicao;
        }
        if (situacao.trim().equals("Ativos")) {
            filtro2 = " AND FUN.TG_INATIVO = 0";
        } else if (situacao.trim().equals("Inativos")) {
            filtro2 = " AND FUN.TG_INATIVO = 1";
        }

        ResultSet resultado = pst.executeQuery(
                "SELECT FUN.PK_ID, FUN.NOME, FUN.TELEFONE, FUN.CARGO, "
                + "FUN.EMAIL, LOG.PK_ID AS LOGIN, FUN.TG_INATIVO FROM TB_FUNCIONARIO AS FUN "
                + "LEFT JOIN TS_LOGIN AS LOG ON LOG.FK_FUNCIONARIO = FUN.PK_ID"
                + " WHERE FUN.NOME LIKE'%" + filtro + "%'" + filtro2 + ";");

        while (resultado.next()) {

            Funcionario func = new Funcionario();
            func.setId(resultado.getInt("PK_ID"));
            func.setNome(resultado.getString("NOME"));
            func.setTelefone(resultado.getString("TELEFONE"));
            func.setCargo(resultado.getString("CARGO"));
            func.setEmail(resultado.getString("EMAIL"));
            func.setIdLogin(resultado.getInt("LOGIN"));
            func.setInativo(resultado.getInt("TG_INATIVO"));

            if (func.getInativo() == 1) {
                func.setSituacao("INATIVO");
            } else if (func.getInativo() == 0) {
                func.setSituacao("ATIVO");
            }

            listarFunc.add(func);
        }
        if (pst != null && !pst.isClosed()) {
            pst.close();
        }
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
        return listarFunc;
    }

    public static boolean inativar(Funcionario func)
            throws SQLException, Exception {
        String sqlComando = "";

        if (func.getInativo() == 0) {
            sqlComando = "UPDATE TB_FUNCIONARIO SET TG_INATIVO = 1, DH_ALTERACAO= NOW() WHERE PK_ID = ?";
        } else {
            sqlComando = "UPDATE TB_FUNCIONARIO SET TG_INATIVO = 0, DH_ALTERACAO= NOW() WHERE PK_ID = ?";
        }

        Connection connection = ConnectionUtils.getConnection();
        PreparedStatement pst = connection.prepareStatement(sqlComando);
        pst.setInt(1, func.getId());

        try {
            pst.execute();
            pst.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean setRegistro(Funcionario func) throws Exception, ClassNotFoundException, SQLException {
        if (func.getId() == 0) {
            return insert(func);
        } else {
            return update(func);
        }
    }

    public static Funcionario getById(int id) throws Exception, ClassNotFoundException, SQLException {
        Funcionario func = new Funcionario();

        Connection connection = ConnectionUtils.getConnection();

        Statement st = connection.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM TB_FUNCIONARIO WHERE PK_ID = " + id);

        while (rs.next()) {
            func.setId(rs.getInt("PK_ID"));
            func.setNome(rs.getString("NOME").trim());
            func.setDocumento(rs.getString("NRDOC").trim());
            func.setTelefone(rs.getString("TELEFONE").trim());
            func.setSexo(rs.getString("SEXO").trim());
            Date dataNascimento = rs.getDate("DT_NASCIMENTO");
            func.setDataNascimento(dataNascimento);
            func.setEndereco(rs.getString("ENDERECO"));
            func.setBairro(rs.getString("BAIRRO").trim());
            func.setCidade(rs.getString("CIDADE").trim());
            func.setCep(rs.getString("CEP").trim());
            func.setEmail(rs.getString("EMAIL").trim());
            func.setCargo(rs.getString("CARGO"));
            func.setInativo(rs.getInt("TG_INATIVO"));

        }

        return func;
    }

}
