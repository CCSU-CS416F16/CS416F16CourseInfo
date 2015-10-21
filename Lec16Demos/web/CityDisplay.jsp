<%-- 
    Document   : PersonDisplay
    Created on : Nov 4, 2011, 2:32:56 PM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<table border="1">
    <tr>
        <th>City</th>
        <th>State</th>
        <th>Population</th>
    </tr>
    <c:forEach var="city" items="${cityList}">
        <tr>
            <td><c:out value="${city.name}" /></td>
            <td><c:out value="${city.usState}" /></td>
            <td><c:out value="${city.population}" /></td>
        </tr>
    </c:forEach>
</table>
