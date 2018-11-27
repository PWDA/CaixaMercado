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
        <c:if test="${usuario.getId() == null}">
            <c:redirect url="http://localhost:8080/CaixaMercado/Login?code=00" />            
        </c:if>
        <header>
            <div class="container">
                <span>PAGAMENTO</span>
            </div><!--container-->
        </header>

        <section class="forma-pagamento">
            <div class="container">
                <form method="post">
                    <input type="hidden" name="id" value="${produto.getCod()}">
                    <label for="codigo-produto">Cod Produto</label>
                    <input style="width: 150px" type="text" name="codigo-produto" value="${buscar}">
                    <input type="submit" name="btnCarregar" value="Carregar" formaction="CarregarProd">
                    <input type="submit" name="btnInserir" value="Inserir" formaction="IncluirProd"><br>
                    <input style="width: 320px; font-size: 20px; text-align: center;" type="text" name="nomeProduto" placeholder="Produto..." value="${produto.getNomeProduto()}">
                    <input style="width: 200px; height: 200px; position: absolute; top: 30px; right: 15%; background: rgba(0,0,0,.1);" type="image" id="image-produto" alt="Imagem do produto"
                           src="img/beer.png">
                    <label for="valor-unitário">Valor unitário</label>
                    <input style="width: 100px" type="text" name="valor-unitario" value="${produto.getValorUnitario()}" >
                    <label for="quantidade" >Quantidade</label>
                    <input style="width: 100px" type="text" name="quantidade">
                </form>
                <div class="icon-exit">
                    <a href="./jsp/home.jsp"> <img src="./img/icon-exit.png" alt="" width="50px"> </a>
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

                        <c:forEach items="${listaProduto}" var="prod" varStatus="stat">
                            <tr>                  
                                <td> <c:out value="${prod.getCod()}"/> </td>
                                <td> <c:out value="${prod.getNomeProduto()}"/> </td>
                                <td> <c:out value="${prod.getValorUnitario()}"/> </td>
                                <td> <c:out value="${prod.getQuantidadeProduto()}"/> </td>                                                                                                                            
                                <td> <c:out value="${prod.getValorTotal()}"/> </td>                            

                                <td>
                                    <a href="DeleteVenda?id=<c:out value='${prod.getCod()}'/>" 
                                       class="btn-delete"> <i class="fas fa-times"> </i> </a>
                                </td>

                            </tr>
                        </c:forEach>

                    </table>

                </div><!--table-product-->


                <div class="formulario-input">  
                    <form action="${pageContext.request.contextPath}/RealizarVenda" method="post">
                        <label for="sub-total">Sub total</label><br>
                        <input type="text" name="sub-total" id="sub-total" value="${subtotal}"><br>

                        <label for="valor-recebido">Valor recebido</label><br>
                        <input type="text" name="valor-recebido" id="valor-recebido"><br>

                        <label for="forma-pagamento">Forma de pagamento</label>
                        <select name="formaPagamento" id="forma-pagamento">
                            <option value="dinheiro">Dinheiro</option>
                            <option value="cartao-debito">Cartão de débito</option>
                            <option value="cartao-credito">Cartão de crédito</option>
                        </select>  

                        <div id="modal-venda" class="modal-container">
                            <div class="modal">
                                <a class="fechar"> <p class="fechar-in"> x </p> </a>
                                <h3 class="subtitulo">Confirmação de Venda</h3>
                                <form>
                                    <label for="troco">Troco</label> <br>
                                    <input type="text" class="troco" name="troco" id="troco"><br>                
                                    <c:if test="${formaPagamento == 'Dinheiro'}">

                                    </c:if>
                                    <input type="submit" class="confirmarVenda" value="Confirmar Venda">
                                </form>
                            </div>
                        </div>

                        <input onclick="troco();" type="button" id="bttCompra" class="btnFecharCompra" name="btnFecharCompra" value="Finalizar compra" >
                        <a class="voltar" href="./jsp/home.jsp">voltar</a>
                    </form>                        


                </div><!--formulario-input-->
            </div><!--container-->
        </section><!--lista-compra-->

        <script src="./js/icons-home.js"></script>  

        <style>
            .modal-container{
                width: 100vw;
                height: 100vh;
                background: rgba(0,0,0,.5);
                position: fixed;
                top: 0px;
                left: 0px;
                z-index: 2000;
                display: none;
                justify-content: center;
                align-items: center;
            }        

            .modal-container.mostrar{
                display: flex;

            }

            .modal{
                background: white;
                width: 50%;
                min-width: 300px;
                padding: 80px;
                border: 10px solid #42f4a1;
                box-shadow: 0 0 0 10px white;
                position: relative;

            }

            @keyframes modalAnime{
                from{
                    opacity: 0;
                    transform: translate3d(0, -80px , 0);
                }
                to{
                    opacity: 1;
                    transform: translate3d(0, 0 , 0);
                }
            }

            .mostrar .modal{
                animation: modalAnime .3s;
            }
            
            .fechar p{
                        top: 50%;
                        left: 50%;
                        transform: translate(-30%, -55%);
                        position: relative;
                        font-size: 50px;
                        color: white;
                        font-weight: bold;
            }
            
            .fechar{
               position: absolute;
                top: -30px;
                right: -30px;
                width: 50px;
                height: 50px;
                border-radius: 50%;
                border: 4px solid white;
                background: #42f4a1;
                color: white;
                font-size: 40px;
                font-family: "PT Mono", monospace;
                cursor: pointer;
                box-shadow: 0 4px 0 rgba(0, 0, 0, .3);
            }

            .confirmarVenda{
                margin: 5vh 2vw 2vh 0;
                width: 150px!important;
                background: #42b3f4;
                cursor: pointer;
                color: white;
            }

        </style>

        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

        <script>
                            function iniciaModal(modalID) {
                                const modal = document.getElementById(modalID);
                                if (modal) {
                                    modal.classList.add('mostrar');
                                    modal.addEventListener('click', (e) => {
                                        if (e.target.className == 'fechar-in') {
                                            modal.classList.remove('mostrar');
                                        }
                                    });
                                }
                            }

                            const venda = document.querySelector('.btnFecharCompra');
                            venda.addEventListener('click', () => iniciaModal('modal-venda'));

        </script>

        <script type="text/javascript">
            function calTroco() {
                $.ajax({
                    type: "POST",
                    url: 'Pagar',
                    success: function (response) {
                        document.querySelector('.Troco').value = response;
                    }
                });
            }

            function troco() {
                var total = document.getElementById('sub-total').value;
                var recebido = document.getElementById('valor-recebido').value;
                var resultado = parseFloat(recebido) - parseFloat(total);
                document.querySelector('.troco').value = 'R$' + resultado;
            }
        </script>



    </body>
</html>