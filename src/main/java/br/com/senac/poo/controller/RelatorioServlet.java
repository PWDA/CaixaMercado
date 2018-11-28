package br.com.senac.poo.controller;

import br.com.senac.poo.dao.DaoRelatorio;
import br.com.senac.poo.model.Relatorio;
import com.sun.javafx.binding.StringFormatter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RelatorioServlet", urlPatterns = {"/Relatorio", "/Relatorio-Mes"})
public class RelatorioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String pagina = request.getRequestURI();

        try {
            if (pagina.endsWith("Relatorio")) {
                relatorioDia(request, response);
            }
        } catch (Exception ex) {
            throw new ServletException(ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String pagina = request.getRequestURI();

        try {
            if (pagina.endsWith("Relatorio")) {
                relatorioDia(request, response);
            }
        } catch (Exception ex) {
            throw new ServletException(ex.getMessage());
        }
    }

    protected void relatorioDia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        DateFormat nova = new SimpleDateFormat("yyyy-MM-dd");
        String inicio   = request.getParameter("dt_inicial");
        String fim      = request.getParameter("dt_final");
        String busca    = request.getParameter("buscar");
        Date date = new Date();

        if (inicio == null) {
            inicio = nova.format(date);
        }

        if (fim == null) {
            fim = nova.format(date);
        }

        if (busca == null) {
            busca = "";
        }
        List<Relatorio> rel = DaoRelatorio.relatorio(inicio, fim, busca);

        RequestDispatcher rd = request.getRequestDispatcher("/jsp/relatorio-diario.jsp");
        request.setAttribute("buscar", busca);
        request.setAttribute("relatorio", rel);
        rd.forward(request, response);
    }
}
