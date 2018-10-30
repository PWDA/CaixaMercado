<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produto cadastrado</title>
    </head>
    <body>
        
        <h1>Produto Cadastrado</h1>
        <p>${id} produto cadastrado: ${produto} data: <fmt:formatDate value="${data}"/></p>
    </body>
</html>
