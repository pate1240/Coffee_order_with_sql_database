<%-- 
    Document   : input
    Created on : Sep 28, 2019, 5:40:39 PM
    Author     : Mohit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Receipt</title>
        <link rel="stylesheet" type="text/css" href="Stylesheet.css">
        
    </head>
    <body background="coffee.gif">
        
        
        
        <h1><center>We're preparing your order!</center></h1>
        
        <div id="container">
            <center>
                
                <%
                    String name = (String)request.getAttribute("cf");
                    String size = (String) request.getAttribute("si");
                   String sizePrice = (String) request.getAttribute("priceSize");
                   String cream = (String) request.getAttribute("cr");
                   String sugar = (String) request.getAttribute("su");
                    
                    %>
                <h2><u>Order Summary</u></h2>
                
                <br>
                <h1>
                <%
                    out.print("Number Of Coffee: " + name );
                    %>
                    <br>
                    <%
                    out.print("<h1>Your Coffee Size: " + size);
                    %>
                    <br>
                    <%
                   out.print("<h1>Price of  your coffee size: " + "$ " + sizePrice);
                   %>
                   <br>
                   <%
                    out.print("<h1>Amount of cream: " + cream);
                    %>
                    <br>
                    <%
                    out.print("<h1>Amount of Sugar: " + sugar);
                    %>
                </h1>
                
            <br>
            </center>
        </div>
    </body>
</html>