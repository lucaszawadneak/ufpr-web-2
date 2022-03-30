<%-- 
    Document   : erro
    Created on : Mar 17, 2022, 6:02:07 PM
    Author     : lucas
--%>

<%@page import="classes.ConfigBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro</title>
        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    </head>
    <body>
        <h1>${pageContext.exception.message}</h1>
        <p>${pageContext.out.flush()}</p>
        <p>${pageContext.exception.printStackTrace(pageContext.response.writer)}
        <a href="/WEB1/${page}">Sair</a>
        <footer>
            <p>Em caso de problemas contactar o adminstrador: <%
               out.print(((ConfigBean) application.getAttribute("configuracao")).getAdminEmail());
            %>
            </p>
        </footer>
    </body>
</html>
