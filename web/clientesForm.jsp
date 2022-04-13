<%-- 
    Document   : cliente
    Created on : Mar 24, 2022, 7:48:50 PM
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    </head>
    <body class="container">
        <c:if test="${empty sessionScope.logado}">
            <jsp:forward page="index.jsp">
                <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema"/>
            </jsp:forward>
        </c:if>
        <c:if test="${empty currentCliente}">
            
            <form action="ClientesServlet?action=store" method="post" class="d-flex align-items-center p-3 w-full justify-content-center">
        </c:if>
        <c:if test="${not empty currentCliente}">                    
            <form action="ClientesServlet?action=update" method="post" class="d-flex align-items-center p-3 w-full justify-content-center">
        </c:if>
            
                <div class="card card-body box-shadow p-2 ">
                    <h1>
                        <c:if test="${not empty currentCliente.nome}">Editar cliente - ${currentCliente.nome}</c:if>
                        <c:if test="${empty currentCliente.nome}">Cadastrar cliente</c:if>
                    </h1>
                    <input type="text" name="nome" placeholder="Nome"  class="form-control mb-2" value="${currentCliente.nome}" />
                    <input type="text" name="email" placeholder="Email" class="form-control mb-2" value="${currentCliente.email}" />
                    <input type="text" name="cpf" placeholder="cpf" maxlength="11" class="form-control mb-2" value="${currentCliente.cpf}"/> 
                    <input type="date" name="date" placeholder="Data"  class="form-control mb-2" value="${currentCliente.data}"/>
                    <input type="text" name="rua" placeholder="Rua" class="form-control mb-2" value="${currentCliente.rua}"/>
                    <input type="text" name="nr" placeholder="Número" class="form-control mb-2" value="${currentCliente.nr}" />
                    <input type="text" name="cep" placeholder="CEP" class="form-control mb-2" value="${currentCliente.cep}"/>
                    <input type="text" name="uf" placeholder="UF" class="form-control mb-2" value="${currentCliente.uf}" />
                    <input type="text" name="cidade" placeholder="Cidade"  class="form-control mb-2" value="${currentCliente.cidade}"/>
                    <div>
                        <button type="submit" class="mt-2 btn btn-primary">
                            <c:if test="${not empty currentCliente.nome}">Alterar</c:if>
                            <c:if test="${empty currentCliente.nome}">Salvar</c:if>
                        </button>
                        <a href="ClientesServlet" class="mt-2 btn btn-secondary">Cancelar</a>                     
                    </div>
                </div>
        </form> 
        
    </body>
</html>
