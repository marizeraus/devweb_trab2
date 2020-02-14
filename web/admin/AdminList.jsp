<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lero lero</title>
</head>
<body>
    <center>
        <h1>Lista de Administradores</h1>
        <h2>
            <a href="/new">Adicionar Admin</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">Listar Admins</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de adms</h2></caption>
            <tr>
                <th>ID</th>
                <th>nome</th>
                <th>login</th>
                <th>senha</th>
            </tr>
            <c:forEach var="admin" items="${listAdmin}">
                <tr>
                    <td><c:out value="${admin.id}" /></td>
                    <td><c:out value="${admin.nome}" /></td>
                    <td><c:out value="${admin.login}" /></td>
                    <td><c:out value="${admin.senha}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${admin.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${admin.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>