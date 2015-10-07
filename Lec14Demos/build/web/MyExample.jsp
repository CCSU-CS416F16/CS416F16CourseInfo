<%-- 
    Document   : MyExample
    Created on : Oct 26, 2011, 6:33:32 PM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>You selected <c:out value="${param.itemType}"/> </h1>
        <h2>Enter additional details</h2>
        <c:if test="${!(empty param.itemType)}">
            An item was chosen<br/><br/>
        </c:if>
        <c:choose>
            <c:when test="${param.itemType == 'Purse'}">
                Color:<input type="text" name="color" value="" /><br/>
                Brand:<input type="text" name="brand" value="" /><br/>
            </c:when>
            <c:when test="${param.itemType == 'Shirt'}">
                Size:<input type="text" name="size" value="" /><br/>
                Style:<input type="text" name="style" value="" /><br/>
            </c:when>
            <c:otherwise>
                <c:redirect url="EnterData.jsp"/>    
            </c:otherwise>
        </c:choose>
    </body>
</html>
