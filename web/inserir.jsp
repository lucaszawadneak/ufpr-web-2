<%-- 
    Document   : inserir
    Created on : Mar 17, 2022, 6:34:39 PM
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% if(session == null){ %>
            <jsp:forward page="erro.jsp">
                <jsp:param name="msg" value="Usuário não logado"/>
            </jsp:forward>
        <%}%>
        <form action="CadastrarUsuarioServlet" method="POST">
            <input placeholder="Nome" name="nome"/>
            <input placeholder="Login" name="login"/>
            <input placeholder="Senha" name="senha"/>
            <input type="submit"/>
        </form>
    </body>
</html>
