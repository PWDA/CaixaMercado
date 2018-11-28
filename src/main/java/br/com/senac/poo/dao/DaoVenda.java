package br.com.senac.poo.dao;

import br.com.senac.poo.db.utils.ConnectionUtils;
import br.com.senac.poo.model.ItemVenda;
import br.com.senac.poo.model.Produto;
import br.com.senac.poo.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoVenda {
    
    public static void inserirItemVenda(ItemVenda itemVenda, int idVenda)
            throws SQLException, Exception {
        
         Connection connection = ConnectionUtils.getConnection();
         
        String sql = "INSERT INTO TB_ITEMVENDA (FK_VENDA, FK_PRODUTO, "
                + "DH_INCLUSAO) VALUES (?, ?, NOW())";
        
        PreparedStatement pst = connection.prepareStatement(sql);
        
        try {
            if(connection != null){
                
                for (int i = 0; i < itemVenda.getQtd(); i++) {
                    
                    pst.setInt(1, idVenda);
                    pst.setInt(2, itemVenda.getCodigoProd());                               

                    pst.execute();
                }                                
            }

        } finally {
            if (pst != null && !pst.isClosed()) {
                pst.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
    
    public static void decrementarEstoque(ItemVenda quantidade) throws SQLException,
            Exception {
        
        Connection connection = ConnectionUtils.getConnection();
        
        String sql = "UPDATE TB_PRODUTO SET QUANTIDADE=? WHERE PK_ID=?";
        
        PreparedStatement pst = connection.prepareStatement(sql);
        
        try {
            if(connection != null){                
            
                
                pst.setInt(1, quantidade.getProduto().getQuantidadeProduto()- quantidade.getQtd());
                pst.setInt(2, quantidade.getCodigoProd());

                pst.executeUpdate();
            }

        } finally {
            if (pst != null && !pst.isClosed()) {
                pst.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
    
    public static void inserir(Venda venda) throws SQLException, Exception {
        
        Connection connection = ConnectionUtils.getConnection();
        
        String sql = "INSERT INTO TB_VENDA (FK_CAIXA, FK_TIPOPAGAMENTO, VL_TOTAL, "
                + "QUANTIDADE, TAXAJUROS, NR_PARCELAS, DH_INCLUSAO) VALUES (?, ?, ?, ?, ?, ?, NOW())";
                
         PreparedStatement pst = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        try {
            
            if(connection != null){
                
                pst.setInt(1, 1);
                 
                pst.setDouble(3, venda.getValorTotal());
                pst.setInt(4, venda.getQuantidade());
                
                if(venda.getFormaPagamento().equalsIgnoreCase("cartao-debito")){
                    pst.setInt(2, 3);
                    pst.setDouble(5, 0);
                    pst.setDouble(6, 0);
                }
                if(venda.getFormaPagamento().equalsIgnoreCase("cartao-credito")){
                    pst.setInt(2, 2);
                    pst.setDouble(5, 0);
                    pst.setDouble(6, 0);
                }
                
                if(venda.getFormaPagamento().equalsIgnoreCase("dinheiro")){
                    pst.setInt(2, 1);
                    pst.setDouble(5, 0);
                    pst.setDouble(6, 0);
                }
                                
                pst.execute();
            }


            Integer idVenda = null;
            ResultSet chaveGeradaVenda = pst.getGeneratedKeys();
            if (chaveGeradaVenda.next()) {
                idVenda = chaveGeradaVenda.getInt(1);
            }

            for (ItemVenda item : venda.getItens()) {                
                inserirItemVenda(item, idVenda);
//                decrementarEstoque(item);
            }

        } finally {
            if (pst != null && !pst.isClosed()) {
                pst.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

    }
    
    public static Produto selectProd(String condicao)
        throws SQLException, ClassNotFoundException {
        
        String filtro = "";        
        
         Produto listarProd = new Produto();

        Connection connection = ConnectionUtils.getConnection();
        Statement pst = connection.createStatement();  
        
        if(condicao != null || !condicao.trim().isEmpty()){
            filtro = condicao;
        }             
        
        ResultSet resultado = pst.executeQuery(
            "SELECT PK_ID, PRODUTO, QUANTIDADE, VL_UNITARIO "
                + "FROM TB_PRODUTO WHERE PK_ID = "+filtro+" AND TG_INATIVO = 0;");

        while (resultado.next()) {

            Produto prod = new Produto();
            prod.setCod(resultado.getInt("PK_ID"));
            prod.setNomeProduto(resultado.getString("PRODUTO"));            
            prod.setQuantidadeProduto(resultado.getInt("QUANTIDADE"));            
            prod.setValorUnitario(resultado.getFloat("VL_UNITARIO"));            

            listarProd = prod;
        }
        if (pst != null && !pst.isClosed()) {
            pst.close();
        }
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
        return listarProd;
    }
    
}
