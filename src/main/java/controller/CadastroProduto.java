package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

@WebServlet(name = "CadastroProduto", urlPatterns = {"/CadastroProduto"})
public class CadastroProduto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            System.out.println("Preparando");
            int id = Integer.parseInt(request.getParameter("id"));
            String quantidadeProduto = request.getParameter("quantidade-produto");
            String nomeProduto = request.getParameter("nome-produto");
            String precoProduto = request.getParameter("preco-produto");

            Produto produto = new Produto(id, nomeProduto, precoProduto, quantidadeProduto);

            produto.setId(id);
            produto.setNomeProduto(nomeProduto);
            produto.setPrecoProduto(precoProduto);
            produto.setQuantidadeProduto(quantidadeProduto);
            

            RequestDispatcher rd = request.getRequestDispatcher("/ProdutoCadastrado.jsp");
            request.setAttribute("data", produto.getData());
            request.setAttribute("produto", produto.getNomeProduto());
            request.setAttribute("id", produto.getId());
            rd.forward(request, response);
          
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
