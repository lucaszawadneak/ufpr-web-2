<%-- 
    Document   : index
    Created on : Mar 24, 2022, 6:05:33 PM
    Author     : lucas
--%>

<%@page import="classes.ConfigBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atividade WEB1</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    </head>
    <body class="container">
         <form action="LoginServlet" method="post" class="d-flex align-items-center p-3 w-full justify-content-center">
                <div class="card box-shadow p-2">
                    <label for="user">Usuário:</label>
                    <input type="text" name="user"/>
                    <label for="password">Senha:</label>
                    <input type="password" name="password"/>
                    <button type="submit" class="mt-2 btn btn-lg btn-primary">Logar</button>
                </div>
        </form> 
        <strong class="text-center mt-2 text-danger">${msg}</strong>
        <footer class="text-center text-lg-start position-fixed bottom-0 w-full">
            <p>Em caso de problemas contactar o adminstrador: <%
               out.print(((ConfigBean) application.getAttribute("configuracao")).getAdminEmail());
            %>
            </p>
        </footer>
    </body>
</html>
