package br.com.senac.poo.controller;

import br.com.senac.poo.model.Login;
import br.com.senac.poo.servico.ServicoLogin;
import br.com.senac.poo.validador.Comuns;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String code = request.getParameter("code");
        if ("99".equals(code)) {
            request.setAttribute("msgErro", "Você saiu do sistema");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("./login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pagina = request.getRequestURI();

        try {
            if (pagina.endsWith("Login")) {
                loginValidar(request, response);
            }

        } catch (Exception ex) {
            throw new ServletException(ex.getMessage());
        }
    }

    protected void loginValidar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        try {
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            Login usuario = ServicoLogin.validarLogin(login, senha);

            if (usuario != null) {
                HttpSession sessao = request.getSession();
                sessao.setAttribute("usuario", usuario.getId());
                Comuns.setUsuarioLogado(usuario);

                RequestDispatcher rd = request.getRequestDispatcher("./jsp/home.jsp");
                request.setAttribute("usuario", usuario);
                rd.forward(request, response);

                response.sendRedirect("./jsp/home.jsp");
            }

        } catch (Exception ex) {
            request.setAttribute("msgErro", ex.getMessage());
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher(
                            "./login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
