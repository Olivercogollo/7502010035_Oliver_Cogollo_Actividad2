/*
 * Servlet que actua como controlador de los estudianteshechas por una persona 
que utilice nuestra App para realizar operaciones sobre la entidad usuario, 
mediante las vistas de usuario
 */
package co.edu.udec.devweb.actividad2.oliver_cogollo.controladores;

import co.edu.udec.devweb.actividad2.oliver_cogollo.modelo.ConexionModelo;
import co.edu.udec.devweb.actividad2.oliver_cogollo.modelo.dao.DaoUsuario;
import co.edu.udec.devweb.actividad2.oliver_cogollo.modelo.entidades.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Oliver
 */
public class ControladorUsuario extends HttpServlet {

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
        recuperarAccion(request, response);
        
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Sistema de Estudiantes</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Saludos desde" + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    }
    //Metodo para procesar las acciones que llegan a la vista desde el controlador
    public void recuperarAccion(HttpServletRequest request, HttpServletResponse response){
     String accion = request.getParameter("accion");
     if(accion.equals("Guardar")== true){
         guardarUsuario(request, response);
         
     }
    }
    public void guardarUsuario(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        String cc = request.getParameter("cc");
        String pasword = request.getParameter("pasword");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");      
        Usuario alguien = new Usuario();
        alguien.setCedula(cc);
        alguien.setPasword(pasword);
        alguien.setNombre(nombre);
        alguien.setApellido(apellido);
        alguien.setEmail(email);
        alguien.setTelefono(telefono);
        // Establecer una conexion con la base de datos 
        ConexionModelo conexion = ConexionModelo.getConexionModelo();
        DaoUsuario daoUser = new DaoUsuario(conexion.getFabricaConexion());
        daoUser.agregar(alguien);
        try{
            response.sendRedirect("web/usuario/agregar.jsp?mensaje = OK, usuario Agregado al Sistema");
        } catch (IOException ex) {
            // Lo hacemos despues
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
