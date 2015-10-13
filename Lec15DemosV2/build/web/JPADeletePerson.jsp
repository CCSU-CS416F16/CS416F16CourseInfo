<%-- 
    Document   : DeletePerson
    Created on : Nov 7, 2011, 11:51:29 AM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Person</title>
    </head>
    <body>
        <h1>Enter first name of person(s) to delete</h1>
        <form action="JPADeletePerson" method="POST">
            last name: <input type="text" name="lastName" value="" /><br/>
            <input type="submit" value="Submit" />
        </form>
        <h2>If records are deleted the remaining records will be displayed.  
            Otherwise a page will be displayed that indicates no records were deleted
        </h2>
        <a href="Index.jsp">Index</a>
    </body>
</html>
