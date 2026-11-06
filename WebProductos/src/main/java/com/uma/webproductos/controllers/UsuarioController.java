/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.uma.webproductos.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import com.uma.webproductos.models.*;
import jakarta.servlet.http.HttpSession;

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
            if(request.getParameter("btn") != null){
                String correo = request.getParameter("correo");
                String clave = request.getParameter("clave");
                
                usuario = dao.ValidarUsuario(correo, clave);
                
                if(usuario != null){
                    request.setAttribute("resultado", "l");
                    sesion.setAttribute("sesion", usuario.getNombre());
                } else {
                    request.setAttribute("resultado", "0");
                }
            }
            
            // BLOQUE CORREGIDO: Lógica para Cerrar Sesión.
            if(request.getParameter("cerrar") != null){
                sesion.removeAttribute("sesion");
                sesion.invalidate(); 
            }
            
            req = request.getRequestDispatcher("login.jsp");
            req.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Usuario Controller";
    }
}
