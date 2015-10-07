<%-- 
    Document   : Example2Entry
    Created on : Oct 26, 2011, 4:51:41 PM
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
        <h1>Enter data</h1>
        <form action="Example2ResultsSoln.jsp">
            Name: <input type="text" name="firstName" value="" />
            <select name="age">
                <option></option>
                <option value="adult">Adult</option>
                <option value="minor">Minor</option>
            </select>
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
