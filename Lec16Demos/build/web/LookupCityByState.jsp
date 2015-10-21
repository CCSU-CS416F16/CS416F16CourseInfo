<%-- 
    Document   : CityByState
    Created on : Nov 6, 2012, 2:29:01 PM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">        
            var xmlhttp;
            function LookUp() {
                var state = document.getElementById("state");
                if (window.XMLHttpRequest){
                    // code for IE7+, Firefox, Chrome, Opera, Safari
                    xmlhttp=new XMLHttpRequest();
                }else{
                    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
                }

                xmlhttp.open("POST", "LookupCityByStateServlet", true);
                xmlhttp.onreadystatechange = callback;
                xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
                var parameters = "state=" + encodeURIComponent(state.value);
                xmlhttp.send(parameters);
            }
            
            function callback(){
                if (xmlhttp.readyState == 4) {
                    if (xmlhttp.status == 200) {
                        document.getElementById("results").innerHTML=xmlhttp.responseText;
                    }
                }
            }
            
        </script>
    </head>
    <body>
        <h1>Lookup up cities by state</h1>
        <form method="POST" action="LookupCityByStateServlet">
            State:<input type="text" name="state" id="state" onkeyup="LookUp();"/><br/>
            <div id="results"></div>
        </form>
    </body>
</html>
