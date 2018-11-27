package br.com.senac.poo.controller;

import br.com.senac.poo.model.Funcionario;
import br.com.senac.poo.model.Login;
import br.com.senac.poo.servico.ServicoFuncionario;
import br.com.senac.poo.servico.ServicoLogin;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/FuncConsultar", "/FuncCadastrar",
    "/FuncInativar", "/LoginCadastrar", "/LoginBuscar"})
public class FuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String pagina = request.getRequestURI();

        try {
            if (pagina.endsWith("FuncConsultar")) {
                funcionarioConsultar(request, response);
            } else if (pagina.endsWith("FuncCadastrar")) {
                funcionarioDigitar(request, response);
            } else if (pagina.endsWith("FuncInativar")) {
                funcionarioInativar(request, response);
            } else if (pagina.endsWith("LoginCadastrar")) {
                loginBuscar(request, response);
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
            if (pagina.endsWith("FuncConsultar")) {
                funcionarioConsultar(request, response);
            } else if (pagina.endsWith("FuncCadastrar")) {
                funcionarioSalvar(request, response);
            } else if (pagina.endsWith("LoginCadastrar")) {
                loginSalvar(request, response);
            } else if (pagina.endsWith("LoginBuscar")) {
                loginBuscar(request, response);
            }
        } catch (Exception ex) {
            throw new ServletException(ex.getMessage());
        }
    }

    protected void funcionarioSalvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        Funcionario funcionario = new Funcionario();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        // id = 0 CASO FOR TENTADO CADASTRAR MAIS DE 1 VEZ NA MESMA PAGINA
        if (request.getParameter("id").equalsIgnoreCase("") || request.getParameter("id") == null) {
            funcionario.setId(0);
        } else {
            funcionario.setId(Integer.valueOf(request.getParameter("id")));
        }

        funcionario.setNome(request.getParameter("nome"));
        funcionario.setDocumento(request.getParameter("documento"));
        funcionario.setTelefone(request.getParameter("telefone"));
        funcionario.setEmail(request.getParameter("email"));
        String dataNascimento = request.getParameter("data-nascimento");
        Date dtNasc = format.parse(dataNascimento);
        funcionario.setDataNascimento(dtNasc);
        funcionario.setSexo(request.getParameter("sexo"));
        funcionario.setCargo(request.getParameter("cargo"));
        funcionario.setEndereco(request.getParameter("endereco"));
        funcionario.setBairro(request.getParameter("bairro"));
        funcionario.setCep(request.getParameter("cep"));
        funcionario.setCidade(request.getParameter("cidade"));

        try {

            boolean resposta = ServicoFuncionario.insertFunc(funcionario);

            if (resposta == true) {
                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("FuncConsultar");
                dispatcher.forward(request, response);
            }

        } catch (Exception ex) {
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/cadastrar-funcionario.jsp");

            request.setAttribute("funcionario", funcionario);
            request.setAttribute("erro", ex.getMessage());

            rd.forward(request, response);
        }
    }

    protected void funcionarioConsultar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        String busca = request.getParameter("buscar");
        String situacao = request.getParameter("situacao");

        if (busca == null && situacao == null) {
            busca = "";
            situacao = "Ativos";
        }
        List<Funcionario> func = ServicoFuncionario.getList(busca, situacao);

        RequestDispatcher rd = request.getRequestDispatcher("/jsp/consulta-funcionario.jsp");
        request.setAttribute("buscar", busca);
        request.setAttribute("funcionario", func);
        rd.forward(request, response);
    }

    protected void funcionarioDigitar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        String req = request.getParameter("id");
        int id;

        if (req == null) {
            id = 0;
        } else {
            id = Integer.parseInt(req);
        }

        Funcionario funcionario = ServicoFuncionario.getById(id);

        RequestDispatcher rd = request.getRequestDispatcher("/jsp/cadastrar-funcionario.jsp");
        request.setAttribute("funcionario", funcionario);
        rd.forward(request, response);

    }

    protected void funcionarioInativar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        int id = Integer.parseInt(request.getParameter("id"));

        try {

            boolean resposta = ServicoFuncionario.inativarRegistro(id);

            if (resposta == true) {
                RequestDispatcher rd
                        = request.getRequestDispatcher("FuncConsultar");
                rd.forward(request, response);
            }

        } catch (Exception ex) {
            request.setAttribute("erro", ex.getMessage());
            funcionarioConsultar(request, response);
        }
    }

    protected void loginSalvar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        Login login = new Login();
        int idFunc = Integer.parseInt(request.getParameter("idFunc"));

        login.setFunc(idFunc);
        login.setId(Integer.parseInt(request.getParameter("id")));
        login.setLogin(request.getParameter("usuario"));
        login.setSenha(request.getParameter("senha"));
        login.setPermissao(request.getParameter("permissao"));

        try {

            boolean resposta = ServicoLogin.insertLogin(login);

            if (resposta == true) {
                RequestDispatcher dispatcher
                        = request.getRequestDispatcher("FuncConsultar");
                dispatcher.forward(request, response);
            }
        } catch (Exception ex) {
            RequestDispatcher rd = request.getRequestDispatcher("./jsp/cadastrar-login.jsp");

            request.setAttribute("login", login);
            request.setAttribute("erro", ex.getMessage());

            rd.forward(request, response);
        }
    }

    protected void loginBuscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        String req = request.getParameter("id");
        int id;

        if (req == null) {
            id = 0;
        } else {
            id = Integer.parseInt(req);
        }

        Login login = ServicoLogin.getById(id);

        RequestDispatcher rd = request.getRequestDispatcher("jsp/cadastrar-login.jsp");
        request.setAttribute("login", login);
        rd.forward(request, response);
    }
}
