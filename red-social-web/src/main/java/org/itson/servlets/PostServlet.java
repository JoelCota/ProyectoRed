/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.itson.servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedList;
import com.google.gson.Gson;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.itson.excepciones.BOException;
import org.itson.implementaciones.FachadaBO;
import org.itson.red.dominio.Administrador;
import org.itson.red.dominio.Anclado;
import org.itson.red.dominio.Comun;
import org.itson.red.dominio.Normal;
import org.itson.red.dominio.Post;
import org.itson.red.dominio.Usuario;
import org.itson.dto.PostEliminadoDTO;
/**
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
@WebServlet(name = "post", urlPatterns = {"/posts"})
public class PostServlet extends HttpServlet {

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
        String action = request.getParameter("action");

        if (action != null && action.equalsIgnoreCase("ver-publicaciones")) {
            this.cargarVerPublicaciones(request, response);
            return;
        }
        if (action != null && action.equalsIgnoreCase("ver-publicaciones-anterior")) {
            this.cargarVerPublicacionesAnterior(request, response);
            return;
        }
        if (action != null && action.equalsIgnoreCase("ver-publicaciones-siguiente")) {
            this.cargarVerPublicacionesSiguiente(request, response);
            return;
        }
        if (action != null && action.equalsIgnoreCase("crear-publicacion")) {
            this.cargarCrearPublicacion(request, response);
            return;
        }
    }

    private void cancelarCrearPublicacion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private void cargarCrearPublicacion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext()
                .getRequestDispatcher("/paginas/crear-publicacion.jsp")
                .forward(request, response);
    }

    private void cargarVerPublicaciones(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int cantidadAnclados = 2;
        int cantidadComunes = 4;

        boolean atras = false;
        boolean siguiente = true;

        List<Anclado> anclados = new LinkedList<>();
        List<Comun> comunes = new LinkedList<>();

        try {
            anclados = fachadaBO.consultarPostsAncladosPaginadoRecientes(cantidadAnclados, 1);
            comunes = fachadaBO.consultarPostsComunesPaginadoRecientes(cantidadComunes, 1);

            if (anclados.size() < cantidadAnclados && comunes.size() < cantidadComunes) {
                siguiente = false;
            }

        } catch (BOException e) {
            request.setAttribute("error", e.getMessage());
            this.getServletContext()
                    .getRequestDispatcher("/paginas/error.jsp")
                    .forward(request, response);
        }

        String url = "/paginas/ver-publicaciones.jsp";
        request.setAttribute("anclados", anclados);
        request.setAttribute("comunes", comunes);
        request.setAttribute("siguiente", siguiente);
        request.setAttribute("atras", atras);
        request.setAttribute("pagina", 1);
        this.getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    private void cargarVerPublicacionesAnterior(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int cantidadAnclados = 2;
        int cantidadComunes = 4;

        Integer pagina = Integer.valueOf(request.getParameter("pagina"));

        boolean siguiente = true;
        boolean atras = true;

        if ((pagina - 1) <= 0) {
            this.cargarVerPublicaciones(request, response);
            return;
        }

        if ((pagina - 1) == 1) {
            atras = false;
        }

        List<Anclado> anclados = new LinkedList<>();
        List<Comun> comunes = new LinkedList<>();
        try {
            anclados = fachadaBO.consultarPostsAncladosPaginadoRecientes(cantidadAnclados, pagina);
            comunes = fachadaBO.consultarPostsComunesPaginadoRecientes(cantidadComunes, pagina);

            if (anclados.isEmpty() && comunes.isEmpty()) {
                this.cargarVerPublicaciones(request, response);
                return;
            }

            if (anclados.size() < cantidadAnclados && comunes.size() < cantidadComunes) {
                siguiente = false;
            }

        } catch (BOException e) {
            request.setAttribute("error", e.getMessage());
            this.getServletContext()
                    .getRequestDispatcher("/paginas/error.jsp")
                    .forward(request, response);
        }
        String url = "/paginas/ver-publicaciones.jsp";
        request.setAttribute("anclados", anclados);
        request.setAttribute("comunes", comunes);
        request.setAttribute("pagina", pagina);
        request.setAttribute("siguiente", siguiente);
        request.setAttribute("atras", atras);
        this.getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    private void cargarVerPublicacionesSiguiente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int cantidadAnclados = 2;
        int cantidadComunes = 4;

        Integer pagina = Integer.valueOf(request.getParameter("pagina"));

        boolean siguiente = true;
        boolean atras = true;

        if (pagina - 1 < 1) {
            atras = false;
        }

        List<Anclado> anclados = new LinkedList<>();
        List<Comun> comunes = new LinkedList<>();
        try {
            anclados = fachadaBO.consultarPostsAncladosPaginadoRecientes(cantidadAnclados, pagina);
            comunes = fachadaBO.consultarPostsComunesPaginadoRecientes(cantidadComunes, pagina);

            if (anclados.isEmpty() && comunes.isEmpty()) {
                this.cargarVerPublicaciones(request, response);
                return;
            }

            if (anclados.size() < cantidadAnclados && comunes.size() < cantidadComunes) {
                siguiente = false;
            }

        } catch (BOException e) {
            request.setAttribute("error", e.getMessage());
            this.getServletContext()
                    .getRequestDispatcher("/paginas/error.jsp")
                    .forward(request, response);
        }
        String url = "/paginas/ver-publicaciones.jsp";
        request.setAttribute("pagina", pagina);
        request.setAttribute("anclados", anclados);
        request.setAttribute("comunes", comunes);
        request.setAttribute("siguiente", siguiente);
        request.setAttribute("atras", atras);

        this.getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
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

        if (action != null) {
            if (action.equalsIgnoreCase("create")) {
                this.proccessCreate(request, response);
                return;
            }

            if (action != null && action.equalsIgnoreCase("ver-publicaciones")) {
                this.cargarVerPublicaciones(request, response);
                return;
            }

            if (action.equalsIgnoreCase("update")) {
                this.proccessUpdate(request, response);
                return;
            }

            if (action.equalsIgnoreCase("delete")) {
                this.proccessDelete(request, response);
                return;
            }
        }
    }

    private void proccessCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
        Long idUsuario = Long.valueOf(request.getParameter("idUsuario"));

        if (titulo.trim().isBlank() || contenido.trim().isBlank()) {
            request.setAttribute("titulo", titulo);
            request.setAttribute("contenido", contenido);

            this.getServletContext()
                    .getRequestDispatcher("/paginas/crear-publicacion.jsp")
                    .forward(request, response);
        }

        Usuario usuario = fachadaBO.consultarUsuarioPorId(idUsuario);

        if (usuario instanceof Normal) {

            Normal normal = (Normal) usuario;
            Comun comun = new Comun();
            comun.setContenido(contenido);
            comun.setTitulo(titulo);
            comun.setFechaCreacion(Calendar.getInstance());
            comun.setUsuario(normal);
            try {
                this.fachadaBO.registrarPostComun(comun);
            } catch (BOException e) {
                request.setAttribute("error", e.getMessage());
                this.getServletContext()
                        .getRequestDispatcher("/paginas/error.jsp")
                        .forward(request, response);
            }
        }

        if (usuario instanceof Administrador) {
            try {
                Administrador admin = (Administrador) usuario;
                Anclado anclado = new Anclado();
                anclado.setContenido(contenido);
                anclado.setTitulo(titulo);
                anclado.setFechaCreacion(Calendar.getInstance());
                anclado.setAdministrador(admin);
                this.fachadaBO.registrarPostAnclado(anclado);
            } catch (BOException e) {
                request.setAttribute("error", e.getMessage());
                this.getServletContext()
                        .getRequestDispatcher("/paginas/error.jsp")
                        .forward(request, response);
            }
        }

        response.sendRedirect(request.getContextPath() + "/posts?action=ver-publicaciones");
    }

    private void proccessUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");

        Post post = new Post();
        post.setId(id);
        post.setTitulo(titulo);
        post.setContenido(contenido);
        post.setFechaEdicion(Calendar.getInstance());

        if (post instanceof Comun) {
            try {
                this.fachadaBO.editarPostComun((Comun) post);
            } catch (BOException e) {
                request.setAttribute("error", e.getMessage());
                this.getServletContext()
                        .getRequestDispatcher("/paginas/error.jsp")
                        .forward(request, response);
            }
        }

        if (post instanceof Anclado) {
            try {
                this.fachadaBO.editarPostAnclado((Anclado) post);
            } catch (BOException e) {
                request.setAttribute("error", e.getMessage());
                this.getServletContext()
                        .getRequestDispatcher("/paginas/error.jsp")
                        .forward(request, response);
            }
        }

        this.getServletContext()
                .getRequestDispatcher("/ver-publicaciones.jsp")
                .forward(request, response);
    }

    private void proccessDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gson serializadorJSON = new Gson();
        try {
            String datosJSON = IOUtils.toString(request.getInputStream(), "utf-8");
            PostEliminadoDTO postEliminado = serializadorJSON.fromJson(datosJSON, PostEliminadoDTO.class);
            System.out.println(postEliminado.getIdPostEliminado());
            if (postEliminado.getIdPostEliminado()!=null) {
            Post post = this.fachadaBO.consultarPostPorId(postEliminado.getIdPostEliminado());
                System.out.println(post.getContenido());
            this.fachadaBO.eliminarPost(post);
            }
            
        } catch (BOException e) {
            request.setAttribute("error", e.getMessage());
            this.getServletContext()
                    .getRequestDispatcher("/paginas/error.jsp")
                    .forward(request, response);
        }

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
