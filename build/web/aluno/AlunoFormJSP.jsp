<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Aluno Form</h1>
        
        <form method="post" action="AlunoController">
            <label> digite o nome: </label>
            <input type="text" name="nome">
            <label> digite o cpf: </label>
            <input type="text" name="cpf">
            <label> digite o email: </label>
            <input type="text" name="email">
            <label> digite o celular: </label>
            <input type="text" name="celular">
            <label> digite o login: </label>
            <input type="text" name="login">
            <label> digite o senha: </label>
            <input type="password" name="senha">
            <label> digite o endereco: </label>
            <input type="text" name="endereco">
            <label> digite o cidade: </label>
            <input type="text" name="cidade">
            <label> digite o bairro: </label>
            <input type="text" name="cidade">
            <label> digite o cep: </label>
            <input type="text" name="cep">
            <label> digite o bairro: </label>
            <input type="text" name="bairro">
            <input type="submit" value="Enviar!">
            
        </form>
        
    </body>
</html>
