<%-- 
    Document   : AddPhone
    Created on : Nov 12, 2012, 12:15:03 PM
    Author     : cwilliam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add phone</h1>
        <form action="AddPhoneServlet" method="POST">
            Login ID: <input type="text" name="login" value="" /><br/>
            phone number: <input type="text" name="pNumber" value="" /><br/>
            <select name="type">
                <option value=""></option>
                <option value="home">Home</option>
                <option value="work">Work</option>
                <option value="cell">Cell</option>
            </select>
            <input type="submit" value="Add Phone" />
        </form>
    </body>
</html>
