<%-- 
    Document   : Example3Entry
    Created on : Oct 26, 2011, 5:09:35 PM
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
        <form action="Example3Servlet">
            Enter a comma delimited string:<br/>
            <input type="text" name="longString" value="" /><br/>
            Gift:<input type="checkbox" name="options" value="Gift" /><br/>
            Expedite:<input type="checkbox" name="options" value="Expedite" /><br/>
            <input type="submit" value="Submit" />            
        </form>
    </body>
</html>
