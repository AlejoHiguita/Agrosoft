package Agrosoft.servlet;

import Agrosoft.entidades.Usuario;
import Agrosoft.negocio.UsuarioN;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Autenticacion extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String user = request.getParameter("txtusuario");
        String clave = request.getParameter("txtclave");
        request.setAttribute("mensajeError", "");
        request.setAttribute("target", null);
        UsuarioN un = new UsuarioN();
        Usuario entU = new Usuario();
        

        String men = "";
        if ("".equals(user) || null == user) {
            men += "Ingrese el Usuario y/0 Contraseña";
        }
        if ("".equals(clave) || null == clave) {
            men += "Ingrese La clave Y/O Usuario";
        }
        if ("".equals(men)) {
            entU = un.getValidarIngreso(user, clave);
            if (entU.getUsuario() != "0") {
                /*Crear una session a partir de los datos envidos por el
                 * usuario, en este caso con los datos del usuario
                 * que ingresa al sistema ver a continunación
                 */
                request.getSession(true).setAttribute("usuario", entU);
                request.setAttribute("target", "FPrincipal.jsp");
            } else {
                request.setAttribute("target", "FLoginBox.jsp");
                men = "Error, los datos no considen ";
            }// fin si <> "0"
        }// fin si men = ""
        request.setAttribute("mensajeError", men);
        request.getRequestDispatcher("./Principal.jsp").forward(request, response);
    } /// fin procesRequest
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
