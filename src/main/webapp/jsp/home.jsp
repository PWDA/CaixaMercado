<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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

        <script>
            function dataHora(){
                var data = new Date();                
                var horas = data.getHours();
                var minutos = data.getMinutes();
                var segundos = data.getSeconds();
                
                var modificacao = new Date(document.lastModified);
                var dia = modificacao.getDate();
                var mes = modificacao.getMonth()+1;
                var ano = modificacao.getFullYear();                
                
                    str_segundo = new String (segundos);
                    if(str_segundo.length == 1){
                        segundos = "0" + segundos;
                    }

                    str_minuto = new String(minutos);
                    if(str_minuto.length == 1){
                        minutos = "0" + minutos;
                    }

                    str_hora = new String(horas);
                    if(str_hora.length == 1){
                        horas = "0" + horas;
                    }
                    
                    str_dia = new String(dia);
                    if(str_dia.length == 1){
                        dia = "0" + dia;
                    }
                    
                    str_mes = new String(mes);
                    if(str_mes.length == 1){
                        mes = "0" + mes;
                    }
                    
                var date = dia + "/" + mes + "/" + ano;
                var exibe = document.querySelector('.data-caixa');                
                exibe.innerHTML = date + "<br>Hora: " + horas + ":" + minutos + ":" + segundos;
            }
            setInterval(dataHora, 1000);            
        </script>
        
        
        
    </head>
    <body>        
        <div class="aside-info">
            <div class="aside nome-aside">
                operador
                <p><c:out value="${usuario.getLogin()}"/></p>
            </div><!--status-->
            <div class="aside status">
                status do caixa
                <p class="status-caixa"><i class="fas fa-circle"></i>Aberto</p>
            </div><!--status-->
            <div class="aside date">
                Data
                <p class="data-caixa" > 
                   
                </p>
            </div><!--date-->

        </div><!--asido-info--> 
        <c:if test="${usuario.getId() == null}">
            <c:redirect url="http://localhost:8080/CaixaMercado/Login?code=00" />            
        </c:if>
        
        <div class="logo-system">
            <img class="logo" src="./img/pwda-logo./png" alt="" width="400px">
            <img class="logo" src="../img/pwda-logo.png" alt="" width="400px">
        </div><!--logo-system-->
        <div class="icons-func">
            <div style="display: flex; justify-content: center" class="container-icon">
                <a class="link-icon" href="${pageContext.request.contextPath}/Caixa"><!--ATENÇÃO-->
                    <div class="icons">
                        <i class="fas fa-desktop"></i>
                        <p>CAIXA</p>
                    </div><!--icons-->
                </a>
                <c:if test="${usuario.getAutorizar() == 2}">
                    <a class="link-icon"  href="${pageContext.request.contextPath}/Relatorio">
                        <div class="icons">
                            <i class="fas fa-file-alt"></i>
                            <p>RELATÓRIO</p>
                        </div><!--icons-->
                    </a>

                    <a class="link-icon"  href="${pageContext.request.contextPath}/FuncConsultar">
                        <div class="icons">
                            <i class="fas fa-id-badge"></i>
                            <p>FUNCIONÁRIO</p>
                        </div><!--icons-->
                    </a>
                </c:if>
                <a class="link-icon"  href="${pageContext.request.contextPath}/logout">
                    <div class="icons">
                        <i class="fas fa-sign-out-alt"></i>
                        <p>FECHAR CAIXA</p>
                    </div><!--icons-->
                </a>

            </div><!--container-icon-->

        </div><!--icons-func-->
        <script src="./js/icons-home.js"></script>
        <script src="../js/icons-home.js"></script>
    </body>
</html>
