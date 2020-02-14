<%-- 
    Document   : AdminList
    Created on : 13/02/2020, 22:54:45
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
        <table border="1" cellpadding="5">
            <caption><h2>Lista de admins</h2></caption>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Login</th>
                <th>Senha</th>
            </tr>
            <c:forEach var="admin" items="${listAdmin}">
                <tr>
                    <td><c:out value="${admin.id}" /></td>
                    <td><c:out value="${admin.nome}" /></td>
                    <td><c:out value="${admin.login}" /></td>
                    <td><c:out value="${admin.senha}" /></td>
                    <td>
                        <a href="/EditAdminServlet?id=<c:out value='${admin.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/DeleteAdminServlet?id=<c:out value='${admin.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
