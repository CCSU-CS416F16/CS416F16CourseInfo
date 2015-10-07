<%-- 
    Document   : result
    Created on : Oct 12, 2011, 2:08:58 PM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="item" scope="request" class="edu.ccsu.solns.Item" />
<jsp:setProperty name="item" property="*"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <th>Item name</th>
                <td><jsp:getProperty name="item" property="itemName" /></td>
            </tr>
            <tr>
                <th>Item cost</th>
                <td><%=item.getItemCost() %></td> 
                <% /* <td><jsp:getProperty name="item" property="itemCost" /></td> */ %>
            </tr>
        </table>
        <%
            Double totalCost = (Double) session.getAttribute("totalCost");
            if (totalCost == null) {
                totalCost = 0.0;
            }
            totalCost += item.getItemCost();
            session.setAttribute("totalCost", totalCost);
        %>
        Total cost: <%=session.getAttribute("totalCost")%> 
    </body>
</html>
    