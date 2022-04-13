<%-- 
    Document   : listarClientes.jsp
    Created on : Mar 24, 2022, 6:27:22 PM
    Author     : lucas
--%>

<%@page import="classes.ConfigBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver cliente</title>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    </head>
    <body class="container">
        <c:if test="${empty sessionScope.logado}">
            <jsp:forward page="index.jsp">
                <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema"/>
            </jsp:forward>
        </c:if>
        <table class="table">
            <tr>
                <th>Nome</th>
                <th>CPF</th>
                <th>Email</th>
                <th>Data</th>
                <th>Rua</th>
                <th>Número</th>
                <th>Cidade</th>
                <th>UF</th>
            </tr>
             <tr>
                <td><c:out value="${cliente.nome}" /></td>
                <td><c:out value="${cliente.cpf}"/></td>
                <td><c:out value="${cliente.email}"/></td>
                <td><c:out value="${cliente.data}" /></td>
                <td><c:out value="${cliente.rua}"/></td>
                <td><c:out value="${cliente.nr}"/></td>
                <td><c:out value="${cliente.cidade}" /></td>
                <td><c:out value="${cliente.uf}"/></td>
            </tr>
        </table>
        <a class="btn btn-primary" href="/WEB1/ClientesServlet">Voltar</a>
        <footer class="text-center text-lg-start position-fixed bottom-0 w-full">
            <p>Em caso de problemas contactar o adminstrador: ${applicationScope.configuracao.getAdminEmail()}
            </p>
        </footer>
    </body>
</html>
