<%-- 
    Document   : ejemplo
    Created on : 17 sept 2026, 7:18:49 p. m.
    Author     : CC4-PC01
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo JSP</title>
        
        <%--Usando Scriptlet--%>
        <%
        int n1, n2, suma;
        String nombre = "Fernando Barrientos";
        String mensaje = "Bienvenido a JSP";
        %>
    </head>
    <body>
        <%
        out.println("Hola " + nombre);
        %>
        <p><%=mensaje%></p>
        
        <%
            n1 = 10;
            n2 = 5;
            suma = n1 + n2;
        %>
        
        <p><%=suma%></p>
        
        <%
        for(int i = 1; i <= 10; i++){
            out.print(i);
        }
        %>
        
        <%for(int j = 1; j <= 10; j++){%>
                <%=j%>
        <%}%>
    </body>
</html>
