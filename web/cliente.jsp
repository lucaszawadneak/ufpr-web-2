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
    </head>
    <body class="container">
        <form action="ClientesServlet?action=store" method="post" class="d-flex align-items-center p-3 w-full justify-content-center">
            
                <div class="card card-body box-shadow p-2 ">
                    
                    <h1>Cadastrar cliente</h1>
                    <input type="text" name="nome" placeholder="Nome"  class="form-control mb-2" />
                    <input type="text" name="email" placeholder="Email" class="form-control mb-2" />
                    <input type="text" name="cpf" placeholder="cpf" maxlength="11" class="form-control mb-2" /> 
                    <input type="date" name="date" placeholder="Data"  class="form-control mb-2"/>
                    <input type="text" name="rua" placeholder="Rua" class="form-control mb-2" />
                    <input type="text" name="nr" placeholder="Número" class="form-control mb-2" />
                    <input type="text" name="cep" placeholder="CEP" class="form-control mb-2" />
                    <input type="text" name="cidade" placeholder="Cidade"  class="form-control mb-2"/>
                    <input type="text" name="uf" placeholder="UF" class="form-control mb-2" />
                    <div>
                        <button type="submit" class="mt-2 btn btn-primary">Salvar usuários</button>
                        <a href="ClientesServlet" class="mt-2 btn btn-secondary">Cancelar</a>                     
                    </div>
                </div>
        </form> 
        
    </body>
</html>
