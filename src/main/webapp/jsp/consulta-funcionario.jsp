<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>WDA - Funcionários</title>
        <link rel="stylesheet" href="./css/consultar-funcionario.css">
        <link rel="stylesheet" href="../css/consultar-funcionario.css">
        <!--google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Niramit:300,400,700" rel="stylesheet">

        <!--fontawesome-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    </head>
    <body>
        <c:if test="${usuario.getId() == null}">
            <c:redirect url="http://localhost:8080/CaixaMercado/Login?code=00" />            
        </c:if>
        <c:if test="${usuario.getAutorizar() != 2}">
            <c:redirect url="http://localhost:8080/CaixaMercado/jsp/home.jsp" />            
        </c:if>
        <header>
            <div class="container">
                <span>CONSULTAR</span>
            </div><!--container-->
            <div class="icon-exit">
                <a href="../jsp/home.jsp"><img src="../img/icon-exit.png" alt="" width="50px"></a>
                <a href="./jsp/home.jsp"><img src="./img/icon-exit.png" alt="" width="50px"></a>
            </div><!--icon-exit-->
        </header>
        <div class="wrap">
            <div class="container">

                <form action="${pageContext.request.contextPath}/FuncConsultar" method="post">
                    <h1>Consultar funcionários</h1>
                    <lable style = "margin-left: 10px; color: #333;" for="buscar">Nome</lable>
                    <input type="text" name="buscar" placeholder="Digite para buscar...">
                    <label style = "margin-left: 10px; color: #333;" for="situacao">Situação</label>
                    <select style="width: 100px; height: 25px; border: 0;  text-align: center; margin: 0 10px " name="situacao" id="situacao">
                        <option value="Ativos">Ativos</option>
                        <option value="Inativos">Inativos</option>
                        <option value="Todos">Todos</option>
                    </select>
                    <input type="submit" name="btn-buscar" value="Buscar">


                    <div class="box-consultar-funcionario">
                        <table>
                            <tr>
                                <th>ID</th>
                                <th>Nome</th>
                                <th>E-mail</th>
                                <th>Telefone</th>
                                <th>Cargo</th>
                                <th>Situação</th>
                                <th>Alterar</th>
                                <th>Inativar/Ativar</th>
                                <th>Login</th>

                            </tr>
                            <c:forEach items="${funcionario}" var="func" varStatus="stat">
                                <tr>
                                    <td> <c:out value="${func.getId()}"/> </td>
                                    <td> <c:out value="${func.getNome()}"/> </td>
                                    <td> <c:out value="${func.getEmail()}"/> </td>
                                    <td> <c:out value="${func.getTelefone()}"/> </td>
                                    <td> <c:out value="${func.getCargo()}"/> </td>
                                    <td> <c:out value="${func.getSituacao()}"/> </td>
                                    <td> 
                                        <a href="FuncCadastrar?id=<c:out value='${func.getId()}'/>" 
                                           class="btn-alterar"><i class="fas fa-pencil-alt"></i> </a>
                                    </td>

                                    <td>
                                        <a href="FuncInativar?id=<c:out value='${func.getId()}'/>" 
                                           class="btn-delete"><i class="fas fa-times"></i> </a>
                                    </td>
                                    <td>
                                        <a href="LoginCadastrar?id=<c:out value='${func.getId()}'/>" 
                                           class="btn-criarLogin"><i class="fas fa-user-plus"></i> </a>
                                    </td>
                                </tr>
                            </c:forEach>                        
                        </table>
                    </div><!--box-consultar-funcionario-->
                </form>
                <a class="btn-novoCadastro" style="text-decoration: none; color: #333;" href="FuncCadastrar?action=doGet"><p class="btn-novoCadastro">Novo cadastro</p></a>
            </div>
        </div>
    </body>
</html>
