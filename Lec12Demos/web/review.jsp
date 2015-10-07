<%-- 
    Document   : review
    Created on : Oct 12, 2011, 2:03:32 PM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Enter item</h1>
        <form action="result.jsp">
            Item name:<input type="text" name="itemName" value="" /><br/>
            Item cost:<input type="text" name="itemCost" value="" /><br/>
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
