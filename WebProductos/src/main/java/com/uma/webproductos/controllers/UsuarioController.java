/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uma.webproductos.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import com.uma.webproductos.models.*;
import javax.servlet.http.HttpSession;

/**
 * Controlador encargado de la gestión de usuarios, 
 * incluyendo el proceso de Login y Logout (Cerrar sesión).
 * 
 * @author CC4-PC01
 */
public class UsuarioController extends HttpServlet {

    /**
     * Procesa las solicitudes tanto GET como POST.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher req;
            Usuario usuario;
            UsuarioDAO dao = new UsuarioDAO();
            HttpSession sesion = request.getSession();

            // BLOQUE CORREGIDO: Lógica de Validación de Login.
            // Verifica si se ha presionado el botón de ingreso ('btn').
            if(request.getParameter("btn") != null){
                String correo = request.getParameter("correo");
                String clave = request.getParameter("clave");
                
                // Se valida el usuario mediante el DAO
                usuario = dao.ValidarUsuario(correo, clave);
                
                if(usuario != null){
                    // LOGIN EXITOSO
                    request.setAttribute("resultado", "l");
                    // IMPORTANTE: Guardamos el nombre en la SESIÓN para que persista en todas las páginas
                    sesion.setAttribute("sesion", usuario.getNombre());
                } else {
                    // LOGIN FALLIDO
                    request.setAttribute("resultado", "0");
                }
            }
            
            // BLOQUE CORREGIDO: Lógica para Cerrar Sesión.
            // Si se recibe el parámetro 'cerrar', se destruye la sesión actual.
            if(request.getParameter("cerrar") != null){
                sesion.removeAttribute("sesion");
                sesion.invalidate(); // Destruye la sesión completa del servidor
            }
            
            // Redirección final a la página de login para mostrar el resultado o solicitar datos.
            req = request.getRequestDispatcher("login.jsp");
            req.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Maneja el método HTTP GET.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Maneja el método HTTP POST.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Retorna una descripción corta del servlet.
     */
    @Override
    public String getServletInfo() {
        return "Usuario Controller";
    }
}
