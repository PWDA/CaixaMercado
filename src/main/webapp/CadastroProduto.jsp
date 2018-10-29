<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produto</title>
    </head>
    <body>
        <h1>Cadastro de produto!</h1>
        <form action="CadastroProduto" method="post">

            <input type="number" name="id" placeholder="Digite o id do produto"><br>
            <input type="text" name="nome-produto" placeholder="Digite o nome do produto"><br>
            <input type="text" name="preco-produto" placeholder="Digite o preço do produto"><br>
            <input type="text" name="quantidade-produto" placeholder="Digite a quantidade do produto"><br>
            <input type="submit" name="btn-submit" value="Cadastrar">


        </form>
    </body>
</html>
