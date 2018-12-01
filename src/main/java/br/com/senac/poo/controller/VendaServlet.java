package br.com.senac.poo.controller;

import br.com.senac.poo.model.ItemVenda;
import br.com.senac.poo.model.Login;
import br.com.senac.poo.model.Produto;
import br.com.senac.poo.model.Venda;
import br.com.senac.poo.servico.ServicoVenda;
import br.com.senac.poo.validador.Comuns;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
            
//            if (pagina.endsWith("Pagar")) {            
//                formaPagamento(request, response);
//            }
            
            if (pagina.endsWith("Caixa")) { 
                if(!listaProd.isEmpty()){
                    listaProd.clear();
                }    
                
                RequestDispatcher rd                        
                    = request.getRequestDispatcher("/jsp/venda.jsp");
                rd.forward(request, response);                 
            }
            
        } catch (Exception ex) {
                throw new ServletException(ex.getMessage());
            }       
                           
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
//            if (pagina.endsWith("Pagar")) {            
//                formaPagamento(request, response);
//            }
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

        try {
            
            Produto prod = ServicoVenda.selectProd(busca);
            //faz calculo1 do subtotal
            float subtotal = 0;
            if(!listaProd.isEmpty()){

                for (int i = 0; i < listaProd.size(); i++) {

                    subtotal += listaProd.get(i).getValorTotal();
                }
            }

            Login usuario = Comuns.getUsuarioLogado();
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", usuario.getId());
            sessao.setAttribute("usuario", usuario);

            RequestDispatcher rd = request.getRequestDispatcher("/jsp/venda.jsp"); 
            request.setAttribute("subtotal", subtotal); 
            if(!listaProd.isEmpty()){
                request.setAttribute("listaProduto", listaProd);      
            }          
            request.setAttribute("produto", prod);       
            rd.forward(request, response);
            
        } catch (Exception ex) {
            
            //faz calculo1 do subtotal
            float subtotal = 0;
            if(!listaProd.isEmpty()){

                for (int i = 0; i < listaProd.size(); i++) {

                    subtotal += listaProd.get(i).getValorTotal();
                }
            }

            Login usuario = Comuns.getUsuarioLogado();
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", usuario.getId());
            sessao.setAttribute("usuario", usuario);
            
            request.setAttribute("msgErro", "Informar o Código do Produto");
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/venda.jsp");
            request.setAttribute("subtotal", subtotal);
            if(!listaProd.isEmpty()){
                request.setAttribute("listaProduto", listaProd);      
            }                      
            rd.forward(request, response);
            
        }                       
    }
    
    protected void produtoCarrinho(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, Exception {
        
        try {
            Produto produto = new Produto();                 
            
            produto.setCod(Integer.valueOf(request.getParameter("id")));                
            produto.setNomeProduto(request.getParameter("nomeProduto"));        
            int qtd = Integer.parseInt(request.getParameter("quantidade"));
            produto.setQuantidadeProduto(qtd);                          
            double valorUnitario = Double.parseDouble(request.getParameter("valor-unitario").replace(',', '.'));
            produto.setValorUnitario(valorUnitario);                
            produto.setValorTotal(valorUnitario * qtd); 

            listaProd.add(produto);

            //faz calculo do subtotal
            float subtotal = 0;
            if(!listaProd.isEmpty()){

                for (int i = 0; i < listaProd.size(); i++) {

                    subtotal += listaProd.get(i).getValorTotal();
                }
            }

            Login usuario = Comuns.getUsuarioLogado();
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", usuario.getId());
            sessao.setAttribute("usuario", usuario);

            RequestDispatcher rd = request.getRequestDispatcher("/jsp/venda.jsp");
            request.setAttribute("subtotal", subtotal); 
            if(!listaProd.isEmpty()){
                request.setAttribute("listaProduto", listaProd);      
            }     
            rd.forward(request, response);           
            
        } catch (Exception ex) {
            
            //faz calculo1 do subtotal
            float subtotal = 0;
            if(!listaProd.isEmpty()){

                for (int i = 0; i < listaProd.size(); i++) {

                    subtotal += listaProd.get(i).getValorTotal();
                }
            }

            Login usuario = Comuns.getUsuarioLogado();
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", usuario.getId());
            sessao.setAttribute("usuario", usuario);
            
            if(request.getParameter("quantidade") == null || request.getParameter("quantidade") == ""){
                request.setAttribute("msgErro", "Informar a quantidade");
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/venda.jsp");
            request.setAttribute("subtotal", subtotal);
            if(!listaProd.isEmpty()){
                request.setAttribute("listaProduto", listaProd);      
            }                      
            rd.forward(request, response);
            
        }
         
    }
    
    protected void deleteProdCarrinho(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, Exception {
                               
        int id = Integer.parseInt(request.getParameter("id"));
                
        for(int i = 0; i < listaProd.size(); i++) {            

            if(listaProd.get(i).getCod() == id)
            {                                
                listaProd.remove(i);                
                break;
            }
        }   
        
        //faz calculo do subtotal
        float subtotal = 0;      
        if(!listaProd.isEmpty()){
            
            for (int i = 0; i < listaProd.size(); i++) {

                subtotal += listaProd.get(i).getValorTotal();
            }
        }
        
        Login usuario = Comuns.getUsuarioLogado();
        HttpSession sessao = request.getSession();
        sessao.setAttribute("usuario", usuario.getId());
        sessao.setAttribute("usuario", usuario);
        
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/venda.jsp");  
        request.setAttribute("subtotal", subtotal); 
        if(!listaProd.isEmpty()){
            request.setAttribute("listaProduto", listaProd);      
        } 
        rd.forward(request, response);            
    }
    
//    protected void formaPagamento(HttpServletRequest request, HttpServletResponse response) 
//            throws ServletException, IOException, Exception {
//        response.setContentType("text/html;charset=UTF-8");
//        
//        String formaPagamento = request.getParameter("formaPagamento");
//                        
////        if(formaPagamento.equalsIgnoreCase("dinheiro")){
//            double valorTotal = Double.parseDouble(request.getParameter("sub-total"));
//            double valorRecebido = Double.parseDouble(request.getParameter("valor-recebido"));
//            Dinheiro calcTroco = new Dinheiro(valorTotal, valorRecebido);
//            double troco = calcTroco.carcularTroco(valorRecebido, valorTotal);
//            
//            PrintWriter out = response.getWriter();
//            out.println("<input type='text' class='troco' name='troco' id='troco' value='"+troco+"'>"
//            
//            );
//            
//            //RequestDispatcher rd = request.getRequestDispatcher("/jsp/venda.jsp");            
//            //request.setAttribute("troco", troco);
//            
////            request.setAttribute("formaPagamento", formaPagamento);
//        //}
//           
//    }
            
    protected void finalizarVenda(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException, Exception {
        
        try {
            
            String formaPagamento = request.getParameter("formaPagamento");
            int idCaixa = Integer.parseInt(request.getParameter("idCaixa"));            

            venda = new Venda();
            String retorno = null;                

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
            venda.setFormaPagamento(formaPagamento);
            venda.setIdCaixa(idCaixa);
            venda.setValorTotal(valorTotal);           

            retorno = ServicoVenda.cadastrarVenda(venda);

            if (retorno == null) { 
                listaProd.clear();
                RequestDispatcher rd
                            = request.getRequestDispatcher("./jsp/home.jsp");
                response.sendRedirect("./jsp/home.jsp"); 
            } else{
                request.setAttribute("msgErro", retorno);
            RequestDispatcher rd
                = request.getRequestDispatcher("/jsp/venda.jsp");
            rd.forward(request, response);
            }
            
        } catch (Exception e) {
            request.setAttribute("msgErro", "Não há produto selecionado para a venda");
            RequestDispatcher rd
                = request.getRequestDispatcher("/jsp/venda.jsp");
            rd.forward(request, response);
        }            
                                         
    }

}
