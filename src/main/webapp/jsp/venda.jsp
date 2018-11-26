<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>WDA - MARKET</title>
    <link rel="stylesheet" href="./css/venda.css">
    <link rel="stylesheet" href="../css/venda.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    
    <link href="https://fonts.googleapis.com/css?family=Archivo:400,500,700" rel="stylesheet">


</head>
<body>
  <header>
     <div class="container">
          <span>PAGAMENTO</span>
     </div><!--container-->
  </header>
    
   <section class="forma-pagamento">
      <div class="container">
        <form action="#">
          <label for="codigo-produto">Cod Produto</label>
          <input style="width: 150px" type="text" name="codigo-produto">
          <input type="submit" name="btnCarregar" value="Carregar">
          <input type="submit" name="btnInserir" value="Inserir"><br>
          <input style="width: 320px; font-size: 20px; text-align: center;" type="text" name="nomeProduto" placeholder="Produto...">
          <input style="width: 200px; height: 200px; position: absolute; top: 30px; right: 15%; background: rgba(0,0,0,.1);" type="image" id="image-produto" alt="Imagem do produto"
          src="img/beer.png">
          <label for="valor-unitário">Valor unitário</label>
          <input style="width: 100px" type="text" name="valor-unitario">
        </form>
        <div class="icon-exit">
            <a href="./jsp/home.jsp"><img src="./img/icon-exit.png" alt="" width="50px"></a>
            <a href="../jsp/home.jsp"><img src="../img/icon-exit.png" alt="" width="50px"></a>
          </div><!--icon-exit-->
      </div>
     
   </section><!--forma-pagamento-->
   <section class="lista-compra">
     <div class="container">
      <div class="table-product">
      <table cellpadding = "0" cellspacing = "0" border="0">
           <tr>
               <th>Produto</th>
               <th>Valor unitário</th>
               <th>Quantidade</th>
               <th>Valor calculado</th>
           </tr>
           <tr>
               <td>Cervejinha</td>
               <td>70,00</td>
               <td>2</td>
               <td>140,00</td>
               
           </tr>
            <tr>
               <td>Cervejinha</td>
               <td>70,00</td>
               <td>2</td>
               <td>140,00</td>
               
           </tr>
            <tr>
               <td>Cervejinha</td>
               <td>70,00</td>
               <td>2</td>
               <td>140,00</td>
               
           </tr>
            <tr>
               <td>Cervejinha</td>
               <td>70,00</td>
               <td>2</td>
               <td>140,00</td>
               
           </tr>
            <tr>
               <td>Cervejinha</td>
               <td>70,00</td>
               <td>2</td>
               <td>140,00</td>
               
           </tr>
            <tr>
               <td>Cervejinha</td>
               <td>70,00</td>
               <td>2</td>
               <td>140,00</td>
               
           </tr>
            <tr>
               <td>Cervejinha</td>
               <td>70,00</td>
               <td>2</td>
               <td>140,00</td>
               
           </tr>
            <tr>
               <td>Cervejinha</td>
               <td>70,00</td>
               <td>2</td>
               <td>140,00</td>
               
           </tr>
            <tr>
               <td>Cervejinha</td>
               <td>70,00</td>
               <td>2</td>
               <td>140,00</td>
               
           </tr>
           <tr>
               <td>Cervejinha</td>
               <td>70,00</td>
               <td>2</td>
               <td>140,00</td>
               
           </tr>
       </table>
 
      </div><!--table-product-->
    
     
      <div class="formulario-input">  
       <form action="">
            <label for="sub-total">Sub total</label><br>
            <input type="text" name="sub-total" id="sub-total"><br>
            <label for="desconto">Desconto</label><br>
            <input type="text" name="desconto" id="desconto"><br>
            <label for="total">Total</label><br>
            <input type="text" name="total" id="total"><br>
            <label for="valor-recebido">Valor recebido</label><br>
            <input type="text" name="valor-recebido" id="valor-recebido"><br>
            <label for="total-pagar">Total a pagar</label><br>
            <input type="text" name="total-pagar" id="total-pagar"><br>
            <label for="forma-pagamento">Forma de pagamento</label>
            <select name="forma-pagamento" id="forma-pagamento">
               <option value="dinheiro">Dinheiro</option>
               <option value="cartao-debito">Cartão de débito</option>
               <option value="cartao-credito">Cartão de crédito</option>
           </select>
               <input type="submit" name="btnFecharCompra" value="Fechar compra">
               <a class="voltar" href="index.html">voltar</a>
       </form>
      </div><!--formulario-input-->
    </div><!--container-->
   </section><!--lista-compra-->
   
   
    <script src="./js/icons-home.js"></script>  
    <script src="../js/icons-home.js"></script>  
</body>
</html>