<%-- 
    Document   : search
    Created on : Mar 11, 2016, 8:13:01 PM
    Author     : DEFCON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if ((session.getAttribute("username") == null) || (session.getAttribute("username") == "")) {
        %>
        You are not logged in<br/>
        <a href="index.jsp">Please Login</a>
        <%} else {
        %>
        Welcome <%=session.getAttribute("username")%>
        <h1>Search Product</h1>
        <form action="search" method="post">
            Product Name: <input type="text" name="product_name" value="" /><br />
            <input type="submit" value="Submit" />
        </form>
        <%
            }
        %>
        
    </body>
</html>
