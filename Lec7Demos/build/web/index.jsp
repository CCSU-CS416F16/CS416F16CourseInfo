<%-- 
    Document   : index
    Created on : Sep 23, 2011, 2:12:37 PM
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
        <form name="myForm" action="ResponseForwardingServlet" method="post">
            <fieldset>
                <legend>Calculate Insurance (Response Forwarding)</legend>
                Input name:<input type="textbox" name="name" /><br/>
                <input type="submit" value="Submit"/>
            </fieldset>
        </form>
        <form action="PersistingServlet">
            <fieldset>
                <legend>Persisting Servlet</legend>
                <input type="text" name="name" value="Chad" />
                <input type="submit" value="Submit" />
            </fieldset>
        </form>
    </body>
</html>
