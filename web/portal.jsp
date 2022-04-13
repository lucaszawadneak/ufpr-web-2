<%-- 
    Document   : portaljsp
    Created on : Mar 17, 2022, 6:14:55 PM
    Author     : lucas
--%>

<%@page import="classes.ConfigBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    </head>
    <body class="container">
        <c:if test="${empty sessionScope.logado}">
            <jsp:forward page="index.jsp">
                <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema"/>
            </jsp:forward>
        </c:if>
        <h1>${sessionScope.logado.name}</h1>
        <menu class="card card-body">
            <a class="card-title" href="/WEB1/ClientesServlet">Cadastro de clientes</a>
            <a class="card-title" href="LogoutServlet">Sair</a>
        </menu>
        <footer class="text-center text-lg-start position-fixed bottom-0 w-full">
            <p>Em caso de problemas contactar o adminstrador: ${applicationScope.configuracao.getAdminEmail()}
            </p>
        </footer>
    </body>
</html>
