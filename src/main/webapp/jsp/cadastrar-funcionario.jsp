<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>WDA - Funcionários</title>
        <link rel="stylesheet" href="./css/cadastrar-funcionario.css">
        <link rel="stylesheet" href="../css/cadastrar-funcionario.css">
        <!--google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Niramit:300,400,700" rel="stylesheet">

        <!--fontawesome-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    </head>
    <body>
        <c:if test="${usuario.getId() == null}">
            <c:redirect url="http://localhost:8080/CaixaMercado/Login?code=00" />            
        </c:if>

        <header>
            <div class="container">
                <span>CADASTRO</span>
            </div><!--container-->
        </header>
        <div class="icon-exit">
            <a href="${pageContext.request.contextPath}/FuncConsultar"><img src="./img/icon-exit.png" alt="" width="50px"></a>
            <a href="${pageContext.request.contextPath}/FuncConsultar"><img src="../img/icon-exit.png" alt="" width="50px"></a>
        </div><!--icon-exit-->
        <section class="cadastro">
            <div class="container">
                <div class="cadastro">
                    <c:if test="${funcionario.getId() > 0}">
                        <h2 class="titulo-cad-func">Alterar Funcionário</h2>
                    </c:if>
                    <c:if test="${funcionario.getId() == 0}">
                        <h2 class="titulo-cad-func">Cadastro de Funcionário</h2>
                    </c:if> 
                    <c:if test="${funcionario.getId() == null}">
                        <h2 class="titulo-cad-func">Cadastro de Funcionário</h2>
                    </c:if> 
                    <form action="${pageContext.request.contextPath}/FuncCadastrar" method="post">  

                        <div class="labels-dados">
                            <label for="nome">Nome</label>
                            <label for="documento">Documento</label>
                            <label for="data-nascimento">Nascimento</label>
                            <label for="sexo">Sexo</label>
                        </div><!--labels-->

                        <div class="inputs-dados">
                            <input type="hidden" name="id" value="${funcionario.getId()}" required>  
                            <input type="name" name="nome" id="nome" placeholder="Digite o nome"  maxlength="100"  value="${funcionario.getNome()}" required><br>
                            <input type="text" name="documento" id = "documento" placeholder="Digite o documento" maxlength="30" value="${funcionario.getDocumento()}" required><br>    
                            <input type="date" name="data-nascimento" id="data-nascimento" value="${funcionario.getDataNascimento()}" required><br>       
                            <select name="sexo" id="sexo">
                                <c:if test="${funcionario.getSexo() == 'Masculino'}" >
                                    <option value="Masculino">Masculino</option>
                                    <option value="Feminino">Feminino</option>
                                </c:if>
                                <c:if test="${funcionario.getSexo() == 'Feminino'}" >
                                    <option value="Feminino">Feminino</option>
                                    <option value="Masculino">Masculino</option>                                    
                                </c:if>
                                <c:if test="${funcionario.getSexo() == null}" >
                                    <option value="Masculino">Masculino</option>
                                    <option value="Feminino">Feminino</option>
                                </c:if>
                            </select><br>        
                        </div><!--inputs-->

                        <div class="labels-endereco">
                            <label for="endereco">Endereço</label>
                            <label for="bairro">Bairro</label>
                            <label for="cidade">Cidade</label>
                            <label for="cep">CEP</label>
                        </div><!--labels-->

                        <div class="inputs-endereco">
                            <input type="text" name="endereco" id="endereco" placeholder="Digite o endereço" maxlength="120" value="${funcionario.getEndereco()}" required><br>
                            <input type="text" name="bairro" id="bairro" placeholder="Digite o bairro" maxlength="60" value="${funcionario.getBairro()}" required><br>
                            <input type="text" name="cidade" id="cidade" placeholder="Digite a cidade" maxlength="80" value="${funcionario.getCidade()}" required><br>
                            <input type="text" name="cep" id="cep" placeholder="Digite o CEP" maxlength="9" value="${funcionario.getCep()}" required>

                        </div><!--inputs-->

                        <div class="labels-contato">           
                            <label for="email">E-mail</label>
                            <label for="telefone">Telefone</label>
                            <label for="cargo">Cargo</label>
                        </div><!--labels-->

                        <div class="inputs-contato">
                            <input type="email" name="email" id="email" placeholder="Digite o e-mail" value="${funcionario.getEmail()}" required><br>
                            <input type="tel" name="telefone" id="telefone" placeholder="Digite o telefone" value="${funcionario.getTelefone()}" required><br>
                            <input type="text" name="cargo" id="cargo" placeholder="Digite o cargo" value="${funcionario.getCargo()}" required><br><br><br>
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
