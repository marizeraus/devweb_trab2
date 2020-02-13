
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Instrutor Form</h1>
        <form method="post" action="InstrutorController">
            <label> digite o nome: </label>
            <input type="text" name="nome">
            <label> digite o email: </label>
            <input type="text" name="email">
            <label> digite o valor_hora: </label>
            <input type="text" name="valor_hora">
            <label>digite a experiencia: </label>
            <input type="textarea" name="experiencia">
            <label> digite o login: </label>
            <input type="text" name="login">
            <label> digite a senha: </label>
            <input type="password" name="senha">
            <input type="submit" value="Enviar!">
            
        </form>
    </body>
</html>
