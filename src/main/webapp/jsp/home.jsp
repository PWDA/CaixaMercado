<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>WDA - MARKET</title>
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    
    <link href="https://fonts.googleapis.com/css?family=Niramit:300,400,700" rel="stylesheet">


</head>
<body>
   <div class="aside-info">
      <div class="aside nome-aside">
         operador
          <p>Alison Henrique</p>
      </div><!--status-->
      <div class="aside status">
          status do caixa
          <p class="status-caixa"><i class="fas fa-circle"></i></p>
      </div><!--status-->
       
   </div><!--asido-info-->     
    <div class="logo-system">
        <img class="logo" src="../img/pwda-logo.png" alt="" width="400px">
        <img class="logo" src="./img/pwda-logo.png" alt="" width="400px">
    </div><!--logo-system-->
    <div class="icons-func">
       <div style="display: flex; justify-content: center" class="container-icon">
            <a class="link-icon" href="venda.html">
            <div class="icons">
                <i class="fas fa-desktop"></i>
                <p>CAIXA</p>
            </div><!--icons-->
            </a>
            
             <a class="link-icon"  href="#">
            <div class="icons">
                <i class="fas fa-file-alt"></i>
                <p>RELATÓRIO</p>
            </div><!--icons-->
            </a>
            
             <a class="link-icon"  href="">
            <div class="icons">
                <i class="fas fa-id-badge"></i>
                <p>CADASTRO LOGIN</p>
            </div><!--icons-->
            </a>
            
             <a class="link-icon"  href="">
            <div class="icons">
                <i class="fas fa-sign-out-alt"></i>
                <p><a href="${pageContext.request.contextPath}/logout">SAIR</a></p>
            </div><!--icons-->
            </a>

       </div><!--container-icon-->
       
    </div><!--icons-func-->
    <script src="js/icons-home.js"></script>  
</body>
</html>