package br.com.senac.poo.controller;

import br.com.senac.poo.dao.DaoVenda;
import br.com.senac.poo.model.Dinheiro;
import br.com.senac.poo.model.ItemVenda;
import br.com.senac.poo.model.Produto;
import br.com.senac.poo.model.Venda;
import br.com.senac.poo.servico.ServicoVenda;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VendaServlet", urlPatterns = {"/Caixa", "/CarregarProd", "/IncluirProd", "/DeleteVenda", "/RealizarVenda", "/Pagar"})
public class VendaServlet extends HttpServlet {
    
    private List<Produto> listaProd = new ArrayList<Produto>(); 
    Venda venda = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String pagina = request.getRequestURI();  
        
        try {
            if (pagina.endsWith("DeleteVenda")) {            
                deleteProdCarrinho(request, response);
            }
            
            if (pagina.endsWith("Pagar")) {            
                formaPagamento(request, response);
            }
            
        } catch (Exception ex) {
                throw new ServletException(ex.getMessage());
            }       

            
        RequestDispatcher rd
            = request.getRequestDispatcher("/jsp/venda.jsp");
        rd.forward(request, response);        
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String pagina = request.getRequestURI();        
        
        try {
            if (pagina.endsWith("CarregarProd")) {
                produtoCarregar(request, response);
            }
            if (pagina.endsWith("IncluirProd")) {
                produtoCarrinho(request, response);
            }
            if (pagina.endsWith("Pagar")) {            
                formaPagamento(request, response);
            }
            if (pagina.endsWith("RealizarVenda")) {            
                finalizarVenda(request, response);
            }

        } catch (Exception ex) {
            throw new ServletException(ex.getMessage());
        }
        }
    
    protected void produtoCarregar(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, Exception {
        
        String busca = request.getParameter("codigo-produto");        

        Produto prod = DaoVenda.selectProd(busca);       
        
        //faz calculo do subtotal
        float subtotal = 0;
        for (int i = 0; i < listaProd.size(); i++) {
            
            subtotal += listaProd.get(i).getValorTotal();
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/venda.jsp"); 
        request.setAttribute("subtotal", subtotal); 
        request.setAttribute("listaProduto", listaProd);        
        request.setAttribute("produto", prod);       
        rd.forward(request, response);
    }
    
    protected void produtoCarrinho(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, Exception {
        
        Produto produto = new Produto();                 
            
        produto.setCod(Integer.valueOf(request.getParameter("id")));                
        produto.setNomeProduto(request.getParameter("nomeProduto"));        
        int qtd = Integer.parseInt(request.getParameter("quantidade"));
        produto.setQuantidadeProduto(qtd);                          
        float valorUnitario = Float.parseFloat(request.getParameter("valor-unitario").replace(',', '.'));
        produto.setValorUnitario(valorUnitario);                
        produto.setValorTotal(valorUnitario * qtd); 
                        
        listaProd.add(produto);
        
        //faz calculo do subtotal
        float subtotal = 0;
        for (int i = 0; i < listaProd.size(); i++) {
            
            subtotal += listaProd.get(i).getValorTotal();
        }
                                                                       
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/venda.jsp");
        request.setAttribute("subtotal", subtotal); 
        request.setAttribute("listaProduto", listaProd);       
        rd.forward(request, response);            
    }
    
    protected void deleteProdCarrinho(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, Exception {
                               
        int id = Integer.parseInt(request.getParameter("id"));
                
        for(int i = 0; i < listaProd.size(); i++) {            

            if(listaProd.get(i).getCod() == id)
            {                
                // Remove.
                listaProd.remove(i);

                // Sai do loop.
                break;
            }
        }   
        
        //faz calculo do subtotal
        float subtotal = 0;
        for (int i = 0; i < listaProd.size(); i++) {
            
            subtotal += listaProd.get(i).getValorTotal();
        }

        RequestDispatcher rd = request.getRequestDispatcher("/jsp/venda.jsp");  
        request.setAttribute("subtotal", subtotal); 
        request.setAttribute("listaProduto", listaProd);       
        rd.forward(request, response);            
    }
    
    protected void formaPagamento(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        
        String formaPagamento = request.getParameter("formaPagamento");
                        
//        if(formaPagamento.equalsIgnoreCase("dinheiro")){
            double valorTotal = Double.parseDouble(request.getParameter("sub-total"));
            double valorRecebido = Double.parseDouble(request.getParameter("valor-recebido"));
            Dinheiro calcTroco = new Dinheiro(valorTotal, valorRecebido);
            double troco = calcTroco.carcularTroco(valorRecebido, valorTotal);
            
            PrintWriter out = response.getWriter();
            out.println("<input type='text' class='troco' name='troco' id='troco' value='"+troco+"'>"
            
            );
            
            //RequestDispatcher rd = request.getRequestDispatcher("/jsp/venda.jsp");            
            //request.setAttribute("troco", troco);
            
//            request.setAttribute("formaPagamento", formaPagamento);
        //}
           
    }
    
    
    
    protected void finalizarVenda(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException, Exception {
            
            String formaPagamento = request.getParameter("formaPagamento");                       
                                
            venda = new Venda();
            String retorno = null;                
            //ItemVenda itemVenda = new ItemVenda();
            double valorTotal = Double.parseDouble(request.getParameter("sub-total"));
            List<ItemVenda> listaItemVenda = new ArrayList<ItemVenda>();
            for (int i = 0; i < listaProd.size(); i++) {
                ItemVenda itemVenda = new ItemVenda();
                itemVenda.setCodigoProd(listaProd.get(i).getCod());
                itemVenda.setQtd(listaProd.get(i).getQuantidadeProduto());

                venda.setQuantidade(listaProd.get(i).getQuantidadeProduto());                                            
                listaItemVenda.add(itemVenda);               
            } 
            venda.setItens(listaItemVenda);
            //venda.setIdCaixa();
            venda.setFormaPagamento(formaPagamento);                
            venda.setValorTotal(valorTotal);


            //adicionar funcionario que fez venda
            //venda.setCliente(clienteEntidade);


            retorno = ServicoVenda.cadastrarVenda(venda);

            if (retorno == null) {
                RequestDispatcher rd
                            = request.getRequestDispatcher("./jsp/home.jsp");
                rd.forward(request, response);
                listaProd = null;
            } else {


            }                                  
    }

}
