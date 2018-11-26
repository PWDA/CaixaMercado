<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>WDA - Relatório diário</title>
        <link rel="stylesheet" href="./css/relatorio.css">
        <link rel="stylesheet" href="../css/relatorio.css">
        <!--google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Niramit:300,400,700" rel="stylesheet">

        <!--fontawesome-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">


    </head>
    <body>
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
                    Data inicial<input type="date" name="dt_inicial" id="dt_inicial"><br>
                    Data final<input type="date" name="dt_final" id="dt_final"><br>
                    Caixa <input type="text" name="caixa" id="caixa" placeholder="Buscar por Caixa" value="${buscar}">
                    <a href="${pageContext.request.contextPath}/Relatorio"><input type="submit" name="btnGerar" value="Consultar"></a>
                </div><!--form-relatorio-regional-->
            </div><!--container-->
        </section>
        <section class="section-consultar">
            <div class="container">     
                <div class="tabela-consultar">
                    <table class="table-consultar" cellpadding = 0 cellspacing = 0>
                        <tr>
                            <th>Código</th>
                            <th>Caixa</th>
                            <th>Produto</th>
                            <th>Qtd. Comprada</th>
                            <th>Valor unitário</th>
                            <th>Valor total</th>
                            <th>Data compra</th>
                        </tr>
                        <c:forEach items="${relatorio}" var="rel" varStatus="stat">
                            <tr>
                                <td> <c:out value="${rel.getCodigo()}"/> </td>
                                <td> <c:out value="${rel.getCaixa()}"/> </td>
                                <td> <c:out value="${rel.getProduto()}"/> </td>
                                <td> <c:out value="${rel.getQtdComprado()}"/> </td>
                                <td> <c:out value="${rel.getValorUnitario()}"/> </td>
                                <td> <c:out value="${rel.getValorTotal()}"/> </td>
                                <td> <c:out value="${rel.getDataCompra()}"/> </td>
                            </tr>
                        </c:forEach>        
                    </table> 
                </div><!--tabela-consultar-->
            </div><!--container-->
        </section><!--section-consultar-->
        <section class="faturado">
            <div class="container">
                <form action="">
                    <label for="faturado">Total faturado</label>
                    <c:forEach items="${relatorio}" var="rel" varStatus="stat">
                        <c:if test="${rel.getTotFaturado() != 0}">
                            <input type="text" name="total-faturado" value="${rel.getTotFaturado()}">
                        </c:if>
                    </c:forEach>
                </form>
            </div><!--container-->
        </section><!--faturado-->

    </body>
</html>
