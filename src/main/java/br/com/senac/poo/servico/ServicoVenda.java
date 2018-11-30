package br.com.senac.poo.servico;

import br.com.senac.poo.dao.DaoVenda;
import br.com.senac.poo.model.Produto;
import br.com.senac.poo.model.Venda;
import br.com.senac.poo.validador.ValidadorVenda;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicoVenda {
    
    public static String cadastrarVenda(Venda venda) throws Exception {
        String resposta = null;
       
        resposta = ValidadorVenda.validar(venda);
        if (resposta == null) {
            try {
              DaoVenda.inserir(venda);

            } catch (Exception e) {                
                resposta = "Erro na fonte de dados";
            }

        }
        return resposta;
    }
    
    public static Produto selectProd(String busca) throws SQLException {
        Produto retornoProd = null;
        
        try {
            retornoProd = DaoVenda.selectProd(busca);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServicoVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retornoProd;       
    }
    
}
