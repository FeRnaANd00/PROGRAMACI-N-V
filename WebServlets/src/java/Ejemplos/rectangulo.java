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
public class rectangulo extends HttpServlet {

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
            out.println("<title>Resultado Rectángulo</title>");
            out.println("</head>");
            out.println("<body>");
            
            if (request.getParameter("btn") != null || request.getParameter("Calcular") != null) {
                try {
                    double b = Double.parseDouble(request.getParameter("base"));
                    double h = Double.parseDouble(request.getParameter("altura"));
                    String op = request.getParameter("op");
                    double resultado = 0;
                    String mensaje = "";

                    if ("A".equals(op)) {
                        resultado = b * h;
                        mensaje = "El área es: ";
                    } else if ("p".equals(op)) {
                        resultado = 2 * (b + h);
                        mensaje = "El perímetro es: ";
                    } else {
                        out.println("<h3 style='color:red;'>Por favor seleccione una opción (Área o Perímetro).</h3>");
                    }

                    if (!mensaje.isEmpty()) {
                        out.println("<h2>" + mensaje + resultado + "</h2>");
                    }
                } catch (NumberFormatException e) {
                    out.println("<h3 style='color:red;'>Error: Ingrese valores numéricos válidos.</h3>");
                }
            }
            
            out.println("<br/><a href='rectangulo.html'>Volver al formulario</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
