package br.com.senac.poo.controller;

import br.com.senac.poo.model.Produto;
import br.com.senac.poo.servico.ServicoProduto;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProdutoServlet", urlPatterns = {"/ProdConsultar", "/ProdCadastrar", "/ProdDeletar"})
public class ProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pagina = request.getRequestURI();
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            if (pagina.endsWith("ProdConsultar")) {
                RequestDispatcher rd
                    = request.getRequestDispatcher("/jsp/consultarProd.jsp");
                rd.forward(request, response);
            } else if (pagina.endsWith("ProdCadastrar")) {
                produtoDigitar(request, response);
            } else if (pagina.endsWith("ProdDeletar")) {
                produtoDeletar(request, response);
            }
        } catch (Exception ex) {
            throw new ServletException(ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pagina = request.getRequestURI();
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        try {
            if (pagina.endsWith("ProdConsultar")) {
                produtoConsultar(request, response);
            } else if (pagina.endsWith("ProdCadastrar")) {
                produtoSalvar(request, response);
            }
        } catch (Exception ex) {
            throw new ServletException(ex.getMessage());
        }
    }

    protected void produtoSalvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        Produto produto = new Produto();        
        
        // id = 0 CASO FOR TENTADO CADASTRAR MAIS DE 1 VEZ NA MESMA PAGINA
        if (request.getParameter("id").equalsIgnoreCase("") || request.getParameter("id") == null){
            produto.setCod(0);
        }else{
             produto.setCod(Integer.valueOf(request.getParameter("id")));
        }
               
        produto.setNomeProduto(request.getParameter("nome-produto"));       
        int qtd = Integer.parseInt(request.getParameter("qtd"));
        produto.setQuantidadeProduto(qtd);        
        float valor = Float.parseFloat(request.getParameter("valor-unitario").replace(',', '.'));
        produto.setValorUnitario(valor);        
                
        try {
            
            boolean resposta = ServicoProduto.insertProd(produto);
            if (resposta == true){                
                RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/jsp/cadastrarProd.jsp");
                dispatcher.forward(request, response);
            }
            
            response.sendRedirect("FuncConsultar");
            
        } catch (Exception ex) {
            RequestDispatcher rd = request.getRequestDispatcher("Funcionario/FuncionarioDigitar.jsp");

            request.setAttribute("produto", produto);
            request.setAttribute("erro", ex.getMessage());

            rd.forward(request, response);
        }
    }

    protected void produtoConsultar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        String busca = request.getParameter("buscar");
        String situacao  = request.getParameter("situacao");        

        List<Produto> prod = ServicoProduto.getList(busca,situacao);        
        
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/consultarProd.jsp");
        request.setAttribute("buscar", busca);
        request.setAttribute("produto", prod);       
        rd.forward(request, response);
    }

    protected void produtoDigitar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        String req = request.getParameter("id");
        int id;

        if (req == null) {
            id = 0;
        } else {
            id = Integer.parseInt(req);
        }

        Produto produto = ServicoProduto.getById(id);

        if (produto.getCod()!= id) {
            response.sendRedirect("/jsp/consultarProd.jsp");
        } else {
            
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/cadastrarProd.jsp");
            request.setAttribute("produto", produto);
            rd.forward(request, response);            
        }
    }

    protected void produtoDeletar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        int id = Integer.parseInt(request.getParameter("id"));

        try {

            boolean resposta = ServicoProduto.inativarRegistro(id);
            
            if(resposta == true){
                RequestDispatcher rd
                    = request.getRequestDispatcher("/jsp/consultarProd.jsp");
                rd.forward(request, response);
            }
                        
        } catch (Exception ex) {
            request.setAttribute("erro", ex.getMessage());

            produtoConsultar(request, response);
        }
    }

}
