<%-- 
    Document   : login
    Created on : 5 nov 2026, 7:31:42 p. m.
    Author     : CC4-PC01
--%>

<%@page import="jakarta.servlet.http.HttpSession" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="resources/fontawesome/css/all.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesion</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
          <div class="container-fluid">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="index.html">Inicio</a>
                </li>
            </ul>
          </div>
        </nav>
        <div class="container mt-3">
            <div class="card" style="max-width: 30%; margin: 5em auto 2em auto">
                <div class="card-header text-center">
                    <h3>Iniciar Sesión</h3>
                </div>
                <div class="card-body">
                    <form action="usuario" method="post">
                        <div class="mb-3">
                            <label for="correo">Correo electrónico:</label>
                            <div class="input-group">
                                <span class="input-group-text"><i class="fa-solid fa-user"></i></span>
                                <input type="text" class="form-control" name="correo"/>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="clave">Contraseña:</label>
                            <div class="input-group">
                                <span class="input-group-text"><i class="fa-solid fa-user"></i></span>
                                <input type="password" class="form-control" name="clave"/>
                            </div>
                        </div>
                        <div class="d-grid">
                            <input type="submit" value="Aceptar" name="btn"
                                   class="btn btn-primary btn-block"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%
            HttpSession sesion = request.getSession();
            if(request.getAttribute("resultado") != null){
                if(request.getAttribute("resultado").equals("l")){
                    response.sendRedirect("bienvenido.jsp");
                } else {
                    out.println("<h4 class='text-center' style='color:red'>Credenciales incorrectas</h4>");
                }
            }
        %>
        <script src="resources/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
