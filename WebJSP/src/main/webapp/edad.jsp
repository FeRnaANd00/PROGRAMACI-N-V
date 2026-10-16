<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplos 2</title>
    </head>
    <body>
        <form action="edad.jsp" method="post">
            Digite su Edad: <input type="number" name="edad"/>
            <input type="submit" value="Enviar" name="btn"/>
        </form>
        
        <%
            if(request.getParameter("btn") !=null){
                String categoria ="";
            int edad = Integer.parseInt(request.getParameter("edad"));
            if(edad >= 18)
                categoria = "Mayor de edad";
            else
                categoria = "Menor de edad";
            
            out.println("Usted es: " + categoria);
            }
        %>
    </body>
</html>
