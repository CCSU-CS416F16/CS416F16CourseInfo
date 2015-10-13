<%-- 
    Document   : PeopleSearch.jsp
    Created on : Nov 5, 2011, 9:26:28 AM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Person lookup</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript">        
            var xmlhttp;
            function LookUp() {
                var name = document.getElementById("name");
                if (window.XMLHttpRequest){
                    // code for IE7+, Firefox, Chrome, Opera, Safari
                    xmlhttp=new XMLHttpRequest();
                }else{
                    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
                }

                var url = "ReviewJDBCGetNamesServlet?lastName=" + encodeURIComponent(lastName.value);
                
                xmlhttp.open("GET", url, true);
                xmlhttp.onreadystatechange = callback;
                xmlhttp.send();
            }
            
            function callback(){
                if (xmlhttp.readyState == 4) {
                    if (xmlhttp.status == 200) {
                        document.getElementById("nameResults").innerHTML=xmlhttp.responseText;
                    }
                }
            }
            
        </script>
    </head>

    <body>
        <h1>Search for person</h1>
        Name:<input type="text" id="lastName" name="lastName" value="" onkeyup="LookUp();"/>
        <hr/>
        <div id="nameResults">
        </div>
        <a href="index.jsp">Back to Index</a><br/>
    </body>
</html>
