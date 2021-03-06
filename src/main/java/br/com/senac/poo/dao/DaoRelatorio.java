package br.com.senac.poo.dao;

import br.com.senac.poo.db.utils.ConnectionUtils;
import br.com.senac.poo.model.Relatorio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DaoRelatorio {
    
    public static List<Relatorio> relatorio(String inicio, String fim, String caixa)
            throws SQLException, ClassNotFoundException {
        String condicao = "";

        float totVendido = 0;

        if (inicio == null) {
            inicio = "";
        }
        if (fim == null) {
            fim = "";
        }
        if (caixa == null) {
            caixa = "";
        }

        List<Relatorio> listVenda = new ArrayList<Relatorio>();

        Connection connection = ConnectionUtils.getConnection();
        Statement pst = connection.createStatement();

        if (inicio != null || !inicio.trim().isEmpty()) {
            condicao = condicao + " AND VEN.DH_INCLUSAO >= CONVERT('" + inicio + " 00:00:00'" + ", DATETIME)";
        }
        if (fim != null || !fim.trim().isEmpty()) {
            condicao = condicao + " AND VEN.DH_INCLUSAO <= CONVERT('" + fim + " 23:59:59'" + ", DATETIME)";
        }
        if (!caixa.equalsIgnoreCase("") || !caixa.trim().isEmpty()) {
            condicao = condicao + " AND LOG.LOGIN LIKE '%" + caixa + "%'";
        }

        condicao = condicao.substring(5);

        ResultSet resultado = pst.executeQuery(
                "SELECT\n"
                + "MAX(LOG.LOGIN) AS CAIXA, \n"
                + "VEN.PK_ID AS COD_VENDA,\n"
                + "PROD.PRODUTO AS PRODUTO,\n"
                + "COUNT(ITE.PK_ID) AS QUANTIDADE,\n"
                + "MAX(PROD.VL_UNITARIO) AS VL_UNITARIO,\n"
                + "COUNT(ITE.PK_ID)*PROD.VL_UNITARIO AS VL_TOTAL,\n"
                + "MAX(VEN.DH_INCLUSAO) AS DT_COMPRA\n"
                + "FROM TB_ITEMVENDA AS ITE\n"
                + "LEFT JOIN TB_VENDA AS VEN ON VEN.PK_ID 	= ITE.FK_VENDA\n"
                + "LEFT JOIN TB_PRODUTO AS PROD ON PROD.PK_ID 	= ITE.FK_PRODUTO\n"
                + "LEFT JOIN TS_LOGIN AS LOG ON LOG.PK_ID 	= VEN.FK_CAIXA\n"
                + "WHERE  " + condicao
                + "GROUP BY VEN.PK_ID,PROD.PRODUTO\n"
                + "ORDER BY VEN.PK_ID;");

        while (resultado.next()) {

            Relatorio rel = new Relatorio();

            rel.setCodigo(resultado.getInt("COD_VENDA"));
            rel.setCaixa(resultado.getString("CAIXA"));
            rel.setProduto(resultado.getString("PRODUTO"));
            rel.setQtdComprado(resultado.getInt("QUANTIDADE"));
            rel.setValorUnitario(resultado.getFloat("VL_UNITARIO"));
            rel.setValorTotal(resultado.getFloat("VL_TOTAL"));
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            rel.setDataCompra(formatter.format(resultado.getDate("DT_COMPRA")));
            totVendido = totVendido + rel.getValorTotal();

            if (resultado.isLast()) {
                rel.setTotFaturado(totVendido);
            }

            listVenda.add(rel);
        }

        if (pst != null && !pst.isClosed()) {
            pst.close();
        }
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
        return listVenda;
    }

}
