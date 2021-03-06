package br.com.senac.poo.servico;

import br.com.senac.poo.dao.DaoFuncionario;
import br.com.senac.poo.model.Funcionario;
import br.com.senac.poo.validador.ValidarFuncionario;
import java.util.List;

public class ServicoFuncionario {

    public static boolean insertFunc(Funcionario func) throws Exception {
        try {
           boolean resposta = ValidarFuncionario.validarFunc(func);
           
           if (resposta == true){
               DaoFuncionario.setRegistro(func);
           }
           
        } catch (Exception ex) {
            throw new Exception("Erro na fonte de dados. \n\n" + ex.getMessage());
        }

        return true;
    }

    public static List<Funcionario> getList(String condicao, String situacao) throws Exception {

        List<Funcionario> listFunc;

        try {
            listFunc = DaoFuncionario.selectAll(condicao, situacao);
        } catch (Exception ex) {
            throw new Exception("Falha para consultar registros. \n\n" + ex.getMessage());
        }

        return listFunc;
    }

    public static Funcionario getById(int id) throws Exception {

        Funcionario func;

        try {
            func = DaoFuncionario.getById(id);
        } catch (Exception ex) {
            throw new Exception("Falha para consultar registro. \n\n" + ex.getMessage());
        }

        return func;
    }

    public static boolean inativarRegistro(int id) throws Exception {
        return inativarRegistro(getById(id));
    }

    public static boolean inativarRegistro(Funcionario func) throws Exception {
        if (func.getId() == 0) {
            throw new Exception("Nenhum registro selecionado para a iantivação/ativação.");
        }

        try {
            DaoFuncionario.inativar(func);
        } catch (Exception ex) {
            throw new Exception("Falha para deletar registro. \n\n O mesmo contém outros registros vinculados ou a conexão com o servidor foi perdida. \n\n " + ex.getMessage());
        }

        return true;
    }
}
