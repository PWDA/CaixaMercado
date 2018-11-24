package br.com.senac.poo.servico;

import br.com.senac.poo.dao.DaoProduto;
import br.com.senac.poo.model.Produto;
import java.util.List;

public class ServicoProduto {

    public static boolean insertProd(Produto prod) throws Exception {
        try {

            DaoProduto.setRegistro(prod);

        } catch (Exception ex) {
            throw new Exception("Erro na fonte de dados. \n\n" + ex.getMessage());
        }

        return true;
    }

    public static List<Produto> getList(String condicao, String situacao) throws Exception {

        List<Produto> listProd;

        try {
            listProd = DaoProduto.selectAll(condicao, situacao);
        } catch (Exception ex) {
            throw new Exception("Falha para consultar registros. \n\n" + ex.getMessage());
        }

        return listProd;
    }

    public static Produto getById(int id) throws Exception {

        Produto prod;

        try {
            prod = DaoProduto.getById(id);
        } catch (Exception ex) {
            throw new Exception("Falha para consultar registro. \n\n" + ex.getMessage());
        }

        return prod;
    }

    public static boolean inativarRegistro(int id) throws Exception {
        return inativarRegistro(getById(id));
    }

    public static boolean inativarRegistro(Produto prod) throws Exception {
        if (prod.getCod()== 0) {
            throw new Exception("Nenhum registro selecionado para a exclusão.");
        }

        try {
            DaoProduto.inativar(prod);
        } catch (Exception ex) {
            throw new Exception("Falha para iantivar registro. \n\n O mesmo contém outros registros vinculados ou a conexão com o servidor foi perdida. \n\n " + ex.getMessage());
        }

        return true;
    }

}
