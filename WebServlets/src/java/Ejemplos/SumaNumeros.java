/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Ejemplos;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author CC4-PC01
 */
public class SumaNumeros extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Suma de números</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ejemplo de Servlet</h1>");

            String v1 = request.getParameter("v1");
            String v2 = request.getParameter("v2");

            if (v1 != null && v2 != null) {
                try {
                    int n1 = Integer.parseInt(v1);
                    int n2 = Integer.parseInt(v2);
                    int resultado = n1 + n2;
                    out.println("<h3>Resultado: " + n1 + " + " + n2 + " = " + resultado + "</h3><hr/>");
                } catch (NumberFormatException e) {
                    out.println("<h3 style='color:red;'>Error: Por favor ingrese números válidos.</h3><hr/>");
                }
            }

            out.println("<form action='sumanumeros' method='post'>");
            out.println("Primer número: <input type='number' name='v1' value='" + (v1 != null ? v1 : "") + "' /> <br/>");
            out.println("Segundo número: <input type='number' name='v2' value='" + (v2 != null ? v2 : "") + "' /><br/>");
            out.println("<input type='submit' value='Sumar' name='btn'/></form><br/>");
            out.println("</body>");
            out.println("</html>");
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
        return "Short description";
    }// </editor-fold>

}
