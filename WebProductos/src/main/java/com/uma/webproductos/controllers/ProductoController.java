
package com.uma.webproductos.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
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
            
            // BLOQUE CORREGIDO: Manejo de visualización de productos.
            // Permite filtrar productos por nombre si se proporciona el parámetro 'texto'.
            if(request.getParameter("mostrar") != null){
                if(request.getParameter("texto") == null)
                    request.setAttribute("DatosProducto", prodDAO.MostrarProductos());
                else
                    request.setAttribute("DatosProducto",
                            prodDAO.MostrarProductos(request.getParameter("texto")));
            }
            
            // BLOQUE CORREGIDO: Lógica para guardar un nuevo producto.
            // Se cambió el ID 1 por 0 para evitar errores de duplicados en la base de datos.
            if(request.getParameter("guardar") != null){
                marca = new Marca(Integer.parseInt(request.getParameter("marca")), "");
                producto = new Producto(0, request.getParameter("nombre"), 
                    Float.parseFloat(request.getParameter("precio")),
                    request.getPart("imagen").getInputStream(), marca);
                prodDAO.InsertarProducto(producto);
            }
            
            // BLOQUE CORREGIDO: Lógica para modificar un producto existente.
            // Se corrigieron paréntesis extra y se gestiona la imagen (si no se sube una nueva, mantiene la actual).
            if(request.getParameter("modificar") != null){
                marca = new Marca(Integer.parseInt(request.getParameter("marca")), "");
                InputStream img = null;
                if(request.getPart("imagen").getSize() != 0)
                    img = request.getPart("imagen").getInputStream();
                else
                    img = prodDAO.ObtenerProductoPorId(
                    Integer.parseInt(request.getParameter("id"))).getImagen();
                
                producto = new Producto (Integer.parseInt(request.getParameter("id")),
                    request.getParameter("nombre"),
                    Float.parseFloat(request.getParameter("precio")), img, marca);
                prodDAO.ModificarProducto(producto);
            }
            
            // BLOQUE CORREGIDO: Lógica para eliminar un producto.
            // Anteriormente solo creaba el objeto pero NO llamaba al método de eliminar del DAO.
            if(request.getParameter("eliminar") != null){
                producto = new Producto(Integer.parseInt(request.getParameter("id")),
                    "", 0, null, null);
                prodDAO.EliminarProducto(producto);
            }
            
            // BLOQUE CORREGIDO: Redirección a la vista.
            // Es fundamental usar el RequestDispatcher para que el usuario regrese a la página de VistaProducto.jsp.
            req = request.getRequestDispatcher("VistaProducto.jsp");
            req.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Producto Controller";
    }
}
