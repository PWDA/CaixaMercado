package br.com.senac.poo.validador;

import br.com.senac.poo.model.Venda;

public class ValidadorVenda {
    
    public static String validar(Venda venda) throws Exception{
        String resposta = null;
        
        if (venda.getItens() == null){
           return resposta = ("Não há produto selecionado para a venda!!!");
        }

        return null;
    }
    
    
}
