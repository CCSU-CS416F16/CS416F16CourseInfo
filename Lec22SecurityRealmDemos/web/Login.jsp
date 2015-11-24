<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <a href="/Lec22SecurityRealmDemos/index.html">Back to index</a><br/><br/>
        <h2>Login</h2>
        <form action="j_security_check" method="POST">
            Username<input type="text" name="j_username"/><br/>
            Password<input type="password" name="j_password"/><br/>
            <input type="submit" value="Login"/>
        </form>
        <form action="LogoutServlet" method="GET">
            <input type="submit" value="Logout"/>
        </form>
    </body>
</html>
