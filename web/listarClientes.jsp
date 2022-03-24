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
        <title>Clientes</title>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    </head>
    <body class="container">
        <% if(session != null){ %>
            <jsp:useBean class="classes.LoginBean" id="login"/>  
            <jsp:setProperty name="login" property="*" />
        <%} else { %>
            <jsp:forward page="index.jsp">
                <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema"/>
            </jsp:forward>
        <%}%>
        <h1><jsp:getProperty name="login" property="name"/></h1>
        <a href="/ClienteServlet?action=store" class="btn btn-primary">Novo cliente</a>
        <table class="table">
            <tr>
                <th>Nome</th>
                <th>CPF</th>
                <th>Email</th>
                <th>Ver</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>
            <c:forEach var="cliente" items="${clientes}">
              <tr>
                <td><c:out value="${cliente.nome}" /></td>
                <td><c:out value="${cliente.cpf}"/></td>
                <td><c:out value="${cliente.email}"/></td>
                <td><a href="ClienteServlet?action=index&id=${cliente.id}"  >A</a></td>
                <td><a href="ClienteServlet?action=update&id=${cliente.id}" >A</a></td>
                <td><a href="ClienteServlet?action=delete&id=${cliente.id}" >A</a></td>
            </tr>
            </c:forEach> 
        </table>
        <footer class="text-center text-lg-start position-fixed bottom-0 w-full">
            <p>Em caso de problemas contactar o adminstrador: <%
               out.print(((ConfigBean) application.getAttribute("configuracao")).getAdminEmail());
            %>
            </p>
        </footer>
    </body>
</html>
