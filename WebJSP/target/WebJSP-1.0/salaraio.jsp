<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <body>
        <form action="salario" method="post">
            <table>
                <tr>
                    <td><label for="sueldo">Sueldo Base:</label></td>
                    <td><input type="number" step="any" name="sueldo" id="sueldo"/></td>
                </tr>
                <tr>
                    <td><label for="contrato">Contrado: </label></td>
                    <td>
                        <select name="contrato" id="contrato">
                        <option value="tcompleto">Tiempo Completo</option>
                        <option value="tparcial">Tiempo Parcial</option>
                        </select>
                    </td> 
                </tr>
                <tr>
                    <td colspan="2"><button type="submit" name="btn">Calcular</button></td>
                </tr>
                </table>
        </form>
        <br/>
        <%
            if(request.getAttribute("resultado") != null){
                double resultado = Double.parseDouble(request.getAttribute("resultado").toString());
                out.println("<p>Resultado: <b>" + String.format("%.3f", resultado) + "</b></p>");
            }
        %>
    </body>
</html>
