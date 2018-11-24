package br.com.senac.poo.dao;

import br.com.senac.poo.db.utils.ConnectionUtils;
import br.com.senac.poo.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoProduto {

    public static boolean update(Produto prod)
            throws SQLException, Exception {

        Connection connection = ConnectionUtils.getConnection();

        String sqlComando = "UPDATE TB_PRODUTO SET PRODUTO=?, QUANTIDADE=?,"
                + "VL_UNITARIO=?, DH_ALTERACAO= NOW() WHERE (PK_ID=?)";

        PreparedStatement pst = connection.prepareStatement(sqlComando);

        try {

            pst.setString(1, prod.getNomeProduto());
            pst.setInt(2, prod.getQuantidadeProduto());
            pst.setDouble(3, prod.getValorUnitario());           
            pst.setInt(4, prod.getCod());

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

    public static boolean insert(Produto prod)
            throws SQLException, Exception {

        Connection connection = ConnectionUtils.getConnection();

        String sqlComando = "INSERT INTO TB_PRODUTO"
                + "(PRODUTO, QUANTIDADE, VL_UNITARIO, DH_INCLUSAO,"
                + "TG_INATIVO) VALUES (?, ?, ?, NOW(), 0);";

        PreparedStatement pst = connection.prepareStatement(sqlComando);

        try {
            if (connection != null) {

                pst.setString(1, prod.getNomeProduto());
                pst.setInt(2, prod.getQuantidadeProduto());
                pst.setDouble(3, prod.getValorUnitario());              

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

    public static List<Produto> selectAll(String condicao, String situacao)
            throws SQLException, ClassNotFoundException {
        String filtro = "";
        String filtro2 = "";

        if (condicao == null) {
            condicao = "";
        } else if (situacao == null) {
            situacao = "";
        }

        List<Produto> listarProd = new ArrayList<Produto>();

        Connection connection = ConnectionUtils.getConnection();
        Statement pst = connection.createStatement();

        if (condicao != null || !condicao.trim().isEmpty()) {
            filtro = condicao;
        }

        if (situacao.trim().equals("Ativos")) {
            filtro2 = " AND TG_INATIVO = 0";
        } else if (situacao.trim().equals("Inativos")) {
            filtro2 = " AND TG_INATIVO = 1";
        }

        ResultSet resultado = pst.executeQuery(
                "SELECT PK_ID, PRODUTO, QUANTIDADE, "
                + "VL_UNITARIO FROM TB_PRODUTO WHERE PRODUTO LIKE'%" + filtro + "%'" + filtro2 + ";");

        while (resultado.next()) {

            Produto prod = new Produto();
            prod.setCod(resultado.getInt("PK_ID"));
            prod.setNomeProduto(resultado.getString("PRODUTO"));
            prod.setQuantidadeProduto(resultado.getInt("QUANTIDADE"));
            prod.setValorUnitario(resultado.getFloat("VL_UNITARIO"));

            listarProd.add(prod);
        }
        if (pst != null && !pst.isClosed()) {
            pst.close();
        }
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
        return listarProd;
    }

    public static boolean inativar(Produto prod)
            throws SQLException, Exception {

        String sqlComando = "UPDATE TB_PRODUTO SET TG_INATIVO = 1 WHERE PK_ID = ?";

        Connection connection = ConnectionUtils.getConnection();
        PreparedStatement pst = connection.prepareStatement(sqlComando);
        pst.setInt(1, prod.getCod());

        try {
            pst.execute();
            pst.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean setRegistro(Produto prod) throws Exception, ClassNotFoundException, SQLException {
        if (prod.getCod()== 0) {
            return insert(prod);
        } else {
            return update(prod);
        }
    }

    public static Produto getById(int id) throws Exception, ClassNotFoundException, SQLException {
        Produto prod = new Produto();

        Connection connection = ConnectionUtils.getConnection();

        Statement st = connection.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM TB_PRODUTO WHERE PK_ID = " + id);

        while (rs.next()) {

            prod.setCod(rs.getInt("PK_ID"));
            prod.setNomeProduto(rs.getString("PRODUTO"));
            prod.setQuantidadeProduto(rs.getInt("QUANTIDADE"));
            prod.setValorUnitario(rs.getFloat("VL_UNITARIO"));

        }

        return prod;
    }

}
