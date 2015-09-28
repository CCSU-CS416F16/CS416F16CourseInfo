<%-- 
    Document   : pageWithError
    Created on : Oct 7, 2011, 2:07:40 PM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        This page has an error and throws an Exception
        <% 
            Object o = null;
            o.toString();
        %>
    </body>
</html>
