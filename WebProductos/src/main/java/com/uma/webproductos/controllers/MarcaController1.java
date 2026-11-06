package com.uma.webproductos.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import com.uma.webproductos.models.*;

public class MarcaController1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Marca marca;
            MarcaDAO marcaDAO = new MarcaDAO();
            RequestDispatcher req;

            if(request.getParameter("mostrar") != null){
                request.setAttribute("DatosMarca", marcaDAO.MostrarMarcas());
            }
            
            if(request.getParameter("guardar") != null){
                marca = new Marca(0, request.getParameter("nombre"));
                marcaDAO.InsertarMarca(marca);
            }
                
            if(request.getParameter("eliminar") != null){
                marca = new Marca(Integer.parseInt(request.getParameter("id")),"");
                marcaDAO.EliminarMarca (marca);
            }
            
            if(request.getParameter("modificar") != null){
                marca = new Marca(Integer.parseInt(request.getParameter("id")),
                        request.getParameter("nombre"));
                marcaDAO.ModificarMarca(marca);
            }
            
            req = request.getRequestDispatcher("VistaMarca.jsp");
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
        return "Marca Controller";
    }
}
