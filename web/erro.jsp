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
    </head>
    <body>
        <h1><%=request.getParameter("msg")%></h1>
        <a href=<%=request.getParameter("page")%>>Sair</a>
        <footer>
            <p>Em caso de problemas contactar o adminstrador: <%
               out.print(((ConfigBean) application.getAttribute("configuracao")).getAdminEmail());
            %>
            </p>
        </footer>
    </body>
</html>
