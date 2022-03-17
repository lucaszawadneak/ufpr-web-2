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
    </head>
    <body>
        <% if(session != null){ %>
            <jsp:useBean class="classes.LoginBean" id="login"/>  
            <jsp:setProperty name="login" property="*" />
        <%} else { %>
            <jsp:forward page="erro.jsp">
                <jsp:param name="msg" value="Usuário não logado"/>
            </jsp:forward>
        <%}%>
        <h1><jsp:getProperty name="login" property="name"/></h1>
        <a href="/inserir.jsp">Inserir</a>
        <a href="LogoutServlet">Sair</a>
        <footer>
            <p>Em caso de problemas contactar o adminstrador: <%
               out.print(((ConfigBean) application.getAttribute("configuracao")).getAdminEmail());
            %>
            </p>
        </footer>
    </body>
</html>
