<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>WDA - Relatório Mensal</title>
        <link rel="stylesheet" href="./css/relatorio.css">
        <link rel="stylesheet" href="../css/relatorio.css">
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
                <span>RELATÓRIO</span>
            </div><!--container-->
        </header>
        <div class="icon-exit">
            <a href="./jsp/home.jsp"><img src="./img/icon-exit.png" alt="" width="50px"></a>
            <a href="../jsp/home.jsp"><img src="../img/icon-exit.png" alt="" width="50px"></a>            
        </div><!--icon-exit-->
        <section>
            <div class="container">
                <div class="form-relatorio-regional">
                    <h1>Relatório diário</h1>


                </div><!--form-relatorio-regional-->
            </div><!--container-->
        </section>
        <section class="section-consultar">
            <div class="container">
                <div class="tabela-consultar">
                    <table class="table-consultar" cellpadding = 0 cellspacing = 0>
                        <tr>
                            <th>Caixa</th>
                            <th>Código</th>
                            <th>Produto</th>
                            <th>Qtd. Comprada</th>
                            <th>Valor unitário</th>
                            <th>Valor total</th>
                            <th>Data compra</th>
                        </tr>

                        <tr>
                            <td>4324</td>
                            <td>Sopinha</td>
                            <td>50</td>
                            <td>3,00</td>
                            <td>150,00</td>
                            <td>23/01/1993</td>
                        </tr>

                        <tr>
                            <td>4324</td>
                            <td>Sopinha</td>
                            <td>50</td>
                            <td>3,00</td>
                            <td>150,00</td>
                            <td>23/01/1993</td>
                        </tr>

                        <tr>
                            <td>4324</td>
                            <td>Sopinha</td>
                            <td>50</td>
                            <td>3,00</td>
                            <td>150,00</td>
                            <td>23/01/1993</td>
                        </tr>

                        <tr>
                            <td>4324</td>
                            <td>Sopinha</td>
                            <td>50</td>
                            <td>3,00</td>
                            <td>150,00</td>
                            <td>23/01/1993</td>
                        </tr>
                        <tr>
                            <td>4324</td>
                            <td>Sopinha</td>
                            <td>50</td>
                            <td>3,00</td>
                            <td>150,00</td>
                            <td>23/01/1993</td>
                        </tr>     
                        <tr>
                            <td>4324</td>
                            <td>Sopinha</td>
                            <td>50</td>
                            <td>3,00</td>
                            <td>150,00</td>
                            <td>23/01/1993</td>
                        </tr>     

                    </table> 
                </div><!--tabela-consultar-->
            </div><!--container-->
        </section><!--section-consultar-->
        <section class="faturado">
            <div class="container">
                <form action="">
                    <label for="faturado">Total faturado</label>
                    <input type="text" name="total-faturado">                       
                </form>
            </div><!--container-->
        </section><!--faturado-->

    </body>
</html>
