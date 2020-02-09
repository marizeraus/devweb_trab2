<%-- 
    Document   : CursoShowJSP
    Created on : 09/02/2020, 14:26:42
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
        <%
            out.println(request.getAttribute("mensagem"));
        %>
        <h1>Hello World!</h1>
    </body>
</html>
