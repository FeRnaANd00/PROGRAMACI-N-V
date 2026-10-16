<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="operaciones" method="post">
            <table>
                <tr>
                    <td><label for="num1">Primer número:</label></td>
                    <td><input type="numer" step="any" name="num1" id="num1"/></td>
                </tr>
                <tr>
                    <td><label for="num2">Segundo número:</label></td>
                    <td><input type="numer" step="any" name="num2" id="num2"/></td> 
                </tr>
                <tr>
                    <td><label>operaciones</label></td>
                    <td>
                        <input type="radio" name="op" value="S"/>Suma<br/>
                        <input type="radio" name="op" value="R"/>Resta<br/>
                        <input type="radio" name="op" value="M"/>Multipicación<br/>
                        <input type="radio" name="op" value="D"/>División
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
