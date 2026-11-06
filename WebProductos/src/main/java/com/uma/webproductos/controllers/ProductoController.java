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
import jakarta.servlet.annotation.MultipartConfig;
import com.uma.webproductos.models.*;
import java.io.*;

/**
 *
 * @author CC4-PC01
 */
@MultipartConfig
public class ProductoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
         Producto producto;
         Marca marca;
         ProductoDAO prodDAO = new ProductoDAO();
         MarcaDAO marcaDAO = new MarcaDAO();
         RequestDispatcher req;
         
         if(request.getParameter("mostrar") != null){
            if(request.getParameter("texto") == null)
                request.setAttribute("DatosProducto", prodDAO.MostrarProductos());
            else
                request.setAttribute("DatosProducto",
                        prodDAO.MostrarProductos(request.getParameter("texto")));
                        }
         
         if(request.getParameter("guardar") != null){
             marca = new Marca(Integer.parseInt(request.getParameter("marca")), "");
             producto = new Producto(0, request.getParameter("nombre"), 
             Float.parseFloat(request.getParameter("precio")),
             request.getPart("imagen").getInputStream(), marca);
             prodDAO.InsertarProducto(producto);
         }
          
         if(request.getParameter("modificar") != null){
              marca = new Marca(Integer.parseInt(request.getParameter("marca")), "");
              InputStream img = null;
              if(request.getPart("imagen").getSize() != 0)
                  img = request.getPart("imagen").getInputStream();
              else
                  img = prodDAO.ObtenerProductoPorId(
                  Integer.parseInt(request.getParameter("id"))).getImagen();
             producto = new Producto (Integer.parseInt(request.getParameter("id")),
                 request.getParameter(("nombre")),
                 Float.parseFloat(request.getParameter("precio")), img, marca);
             prodDAO.ModificarProducto(producto);
         }
          
         if(request.getParameter("eliminar") != null){
          producto = new Producto(Integer.parseInt(request.getParameter("id")),
          "", 0, null, null);
          prodDAO.EliminarProducto(producto);
          }
          
          req = request.getRequestDispatcher("VistaProducto.jsp");
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
        return "Short description";
    }
}
