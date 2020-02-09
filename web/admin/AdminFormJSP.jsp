<%-- 
    Document   : AdminFormJSP
    Created on : 08/02/2020, 22:09:03
    Author     : marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Admin Form</h1>
        <form method="post" action="AdministradorController">
            <label> digite o nome: </label>
            <input type="text" name="nome">
            <label> digite o login: </label>
            <input type="text" name="login">
            <label> digite a senha: </label>
            <input type="password" name="senha">
            <input type="submit" value="Enviar!">
            
        </form>
        
    </body>
</html>
