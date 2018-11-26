<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>WDA - Sistema - Login</title>
        <link rel="stylesheet" href="../css/cadastrar-login.css">
        <link rel="stylesheet" href="./css/cadastrar-login.css">
        <!--google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Niramit:300,400,700" rel="stylesheet">

        <!--fontawesome-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    </head>
    <body>

        <header>
            <div class="container">
                <span>CADASTRO</span>
            </div><!--container-->
        </header>
        <section class="cadastro">
            <div class="container">
                <div class="cadastro">
                    <c:if test="${login.getId() > 0}">
                        <h2 class="titulo-cad-func">ALTERAR LOGIN</h2>
                    </c:if>
                    <c:if test="${login.getId() == 0}">
                        <h2 class="titulo-cad-func">CADASTRAR NOVO LOGIN</h2>
                    </c:if>
                    <c:if test="${login == null}">
                        <h2 class="titulo-cad-func">CADASTRAR NOVO LOGIN</h2>
                    </c:if>
                    <form action="${pageContext.request.contextPath}/LoginCadastrar" method="post">  
                        <div class="inputs-dados">
                            <div class="block-login">
                                <h2>Login</h2>
                                <input type="hidden" name="id" value="${login.getId()}" required>
                                <input type="hidden" name="idFunc" value="${login.getFunc()}" required>
                                <input type="text" name="usuario" id="usuario" placeholder="Usuário" maxlength="150"  value="${login.getLogin()}" required>
                                <input type="text" name="senha" id="senha" placeholder="Digite a senha" maxlength="150" value="${login.getSenha()}" required>
                                <input type="text" name="permissao" id="permissao" placeholder="Digite a permissão de acesso" maxlength="60" value="${login.getPermissao()}" required>
                            </div><!--block-login-->                        

                            <input type="submit" name="cadastrar" value="Cadastrar"> 
                        </div><!--inputs-->

                    </form>
                </div><!--cadastro-->
            </div><!--container-->
        </section>

        <!--
      <footer>
          <p>Desenvolvido por PWDA - 2018</p>
          <p>Todos os direitos reservados</p>
      </footer>
        -->
    </body>
</html>