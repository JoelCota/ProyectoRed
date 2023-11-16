/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.itson.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.itson.excepciones.BOException;
import org.itson.implementaciones.FachadaBO;
import org.itson.red.dominio.Comentario;
import org.itson.red.dominio.Comun;
import org.itson.red.dominio.Normal;
import org.itson.red.dominio.Post;
import org.itson.red.dominio.Usuario;

/**
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
@WebServlet(name = "comentarios", urlPatterns = {"/comentarios"})
public class ComentarioServlet extends HttpServlet {

    FachadaBO fachadaBO = new FachadaBO();

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Comentario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Comentario at " + request.getContextPath() + "</h1>");
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
        String action = request.getParameter("action");

        if (action != null && action.equalsIgnoreCase("comentar")) {
            this.processCreateComentario(request, response);
            return;
        }

        if (action != null && action.equalsIgnoreCase("responder")) {
            this.processCreateRespuesta(request, response);
            return;
        }

    }

    private void processCreateRespuesta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long idUsuario = Long.valueOf(request.getParameter("idUsuario"));
        Long idComentario = Long.valueOf(request.getParameter("idComentario"));
        String contenidoRespuesta = request.getParameter("respuesta");

        Normal usuarioNormal = null;
        Comentario comentario = null;

        try {
            usuarioNormal = (Normal) fachadaBO.consultarUsuarioPorId(idUsuario);
            comentario = fachadaBO.consultarComentarioPorId(idComentario);
            fachadaBO.registarComentario(new Comentario(contenidoRespuesta, comentario, usuarioNormal, null));
        } catch (BOException e) {
            this.getServletContext()
                    .getRequestDispatcher("/paginas/errorJava.jsp")
                    .forward(request, response);
        }

        response.sendRedirect(request.getContextPath() + "/posts?action=ver-publicaciones");
    }

    private void processCreateComentario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Usuario usuarioSession = (Usuario) session.getAttribute("usuario");

//        Long idPost = Long.valueOf(request.getParameter("idPost"));
//
//        String contenido = request.getParameter("comentario");
//
//        //Consulta el post
//        Post post = fachadaBO.consultarPostPorId(idPost);
//
//        Comun postComun = null;
//
//        if (post != null && post instanceof Comun) {
//            postComun = (Comun) post;
//        } else {
//            //Debe redireccionar a la página de error
//            this.getServletContext()
//                    .getRequestDispatcher("/paginas/errorJava.jsp")
//                    .forward(request, response);
//        }
//
//        Normal usuarioNormal = null;
//
//        if (usuario != null && usuario instanceof Normal) {
//            usuarioNormal = (Normal) usuario;
//        } else {
//            //Debe redireccionar a la página de error
//            this.getServletContext()
//                    .getRequestDispatcher("/paginas/errorJava.jsp")
//                    .forward(request, response);
//        }
//
//        //Crea el objeto del comentario
//        Comentario comentario = new Comentario(contenido, usuarioNormal, postComun);
//
//        fachadaBO.registarComentario(comentario);
//
//        if (comentario.getId() == null) {
//            //Redireccionar a la página, porque no guardó
//        }
//
//        JsonObject json = Json.createObjectBuilder().build();
//        String url = "/posts?action=ver-publicaciones";
//        json.put("url", null);

        Long idPost = Long.valueOf(request.getParameter("idPost"));
//        Long idUsuario = Long.valueOf(request.getParameter("idUsuario"));
        String contenido = request.getParameter("comentario");

        //Consulta el post
        Post post = fachadaBO.consultarPostPorId(idPost);

        Comun postComun = null;

        if (post != null && post instanceof Comun) {
            postComun = (Comun) post;
        } else {
            //Debe redireccionar a la página de error
            this.getServletContext()
                    .getRequestDispatcher("/paginas/errorJava.jsp")
                    .forward(request, response);
        }

        Normal usuarioNormal = null;

        if (usuarioSession != null && usuarioSession instanceof Normal) {
            usuarioNormal = (Normal) usuarioSession;
        } else {
            //Debe redireccionar a la página de error
            this.getServletContext()
                    .getRequestDispatcher("/paginas/errorJava.jsp")
                    .forward(request, response);
        }

        //Crea el objeto del comentario
        Comentario comentario = new Comentario(contenido, usuarioNormal, postComun);

        fachadaBO.registarComentario(comentario);

        if (comentario.getId() == null) {
            //Redireccionar a la página, porque no guardó
        }

        response.sendRedirect(request.getContextPath()+"/posts?action=ver-publicaciones");
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
