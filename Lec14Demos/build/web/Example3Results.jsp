<%-- 
    Document   : Example3ResultsSoln
    Created on : Oct 26, 2011, 5:12:45 PM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tokens</h1>
        <c:forTokens delims="," items="${param.longString}" var="token">
            Token: <c:out value="${token}"/><br/>
        </c:forTokens>
        <h1>Options</h1>
        <!-- See servlet for populating request -->
        <c:forEach var="item" items="${optionsList}">
            Option: <c:out value="${item}"/><br/>
        </c:forEach>
            <h1>DIRECT</h1>
        <c:forEach var="item" items="${paramValues.options}">
            Option: <c:out value="${item}"/><br/>
        </c:forEach>      

    </body>
</html>
