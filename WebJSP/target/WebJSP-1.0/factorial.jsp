<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="factorial" method="post">
            Númmero: <input type="number" name="num"/>
            <button type="submit" name="btn">Calcular </button>
        </form>
        <br/>
        <%
            if(request.getAttribute("f") != null){
                out.println("<b> Factorial: </b>" + request.getAttribute("f"));
            }
        %>
    </body>
</html>
