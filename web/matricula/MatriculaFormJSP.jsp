<%-- 
    Document   : CursoFormJSP
    Created on : 09/02/2020, 14:23:54
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
        <h1>Matricula Form</h1>
        <form method="post" action="CursoController">
            <label> digite o id da turma: </label>
            <input type="number" name="nome">
            <label> digite a data da matricula: </label>
            <input type="date" name="requisito">
            <label> digite a ementa: </label>
            <input type="textarea" name="ementa">
            <label> digite a carga horaria: </label>
            <input type="number" name="carga_horaria">
            <label> digite o preco: </label>
            <input type="text" name="preco">
            <input type="submit" value="Enviar!">
            
        </form>
    </body>
</html>
