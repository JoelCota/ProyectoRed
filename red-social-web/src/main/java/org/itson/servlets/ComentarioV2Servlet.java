/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.itson.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.IOUtils;
import org.itson.dto.ComentarioDTO;
import org.itson.dto.CrearComentarioDTO;
import org.itson.dto.CrearRespuestaComentarioDTO;
import org.itson.dto.EliminarDTO;
import org.itson.dto.RespuestaComentarioDTO;
import org.itson.excepciones.BOException;
import org.itson.implementaciones.FachadaBO;
import org.itson.red.dominio.Comentario;
import org.itson.red.dominio.Comun;
import org.itson.red.dominio.Normal;
import org.itson.utils.DTOConverter;

/**
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
@WebServlet(name = "ComentarioV2Servlet", urlPatterns = {"/comentarioV2Servlet"})
public class ComentarioV2Servlet extends HttpServlet {

    FachadaBO fachadaBO = new FachadaBO();
    Gson serializadorJSON = new Gson();

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
            registrarComentario(request, response);
            //Esto es para que no siga avanzando el método
            return;
        }

        if (action != null && action.equalsIgnoreCase("responder")) {
            this.registrarRespuesta(request, response);
            return;
        }
        
        if (action != null && action.equalsIgnoreCase("eliminar-comentario")) {
            this.eliminarComentario(request, response);
            return;
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

    private void registrarComentario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();

            String body = IOUtils.toString(request.getInputStream(), "utf-8");

            CrearComentarioDTO crearComentarioDTO = serializadorJSON
                    .fromJson(body, CrearComentarioDTO.class);

            Long idPostComun = Long.valueOf(crearComentarioDTO.getIdPost());

            Normal usuarioNormal = (Normal) session.getAttribute("usuario");

            try {

                Comun postComun = (Comun) fachadaBO.consultarPostPorId(idPostComun);

                Comentario comentarioNuevo = DTOConverter
                        .crearComentarioPorPeticion(crearComentarioDTO);

                comentarioNuevo.setPostComun(postComun);
                comentarioNuevo.setUsuarioNormal(usuarioNormal);

                fachadaBO.registarComentario(comentarioNuevo);

                ComentarioDTO comentarioDTO = DTOConverter.crearComentarioDTO(comentarioNuevo);

                String respuestaJson = serializadorJSON.toJson(comentarioDTO);

                out.write(respuestaJson);
            } catch (BOException e) {
                out.write(e.getMessage());
            }
        }
    }

    private void registrarRespuesta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();

            String body = IOUtils.toString(request.getInputStream(), "utf-8");

            CrearRespuestaComentarioDTO crearRespuestaDTO = serializadorJSON
                    .fromJson(body, CrearRespuestaComentarioDTO.class);

            Long idComentario = Long.valueOf(crearRespuestaDTO.getIdComentario());

            Normal usuarioNormal = (Normal) session.getAttribute("usuario");

            try {

                Comentario comentario = fachadaBO.consultarComentarioPorId(idComentario);

                Comentario comentarioNuevo = DTOConverter
                        .crearRespuestaComentarioPorPeticion(crearRespuestaDTO);

                comentarioNuevo.setComentario(comentario);
                comentarioNuevo.setUsuarioNormal(usuarioNormal);

                fachadaBO.registarComentario(comentarioNuevo);

                RespuestaComentarioDTO respuestaComentarioDTO = DTOConverter
                        .crearRespuestaComentarioDTO(comentarioNuevo);

                String respuestaJson = serializadorJSON
                        .toJson(respuestaComentarioDTO);

                out.write(respuestaJson);
            } catch (BOException e) {
                out.write(e.getMessage());
            }
        }
    }

    private void eliminarComentario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            String body = IOUtils.toString(request.getInputStream(), "utf-8");

            EliminarDTO eliminarComentarioDTO = serializadorJSON
                    .fromJson(body, EliminarDTO.class);

            Long idComentario = Long.valueOf(eliminarComentarioDTO.getIdElemento());


            try {

                Comentario comentarioEliminar = fachadaBO.consultarComentarioPorId(idComentario);

                fachadaBO.eliminarComentario(comentarioEliminar);

                RespuestaComentarioDTO comentarioDTO = DTOConverter
                        .crearRespuestaComentarioDTO(comentarioEliminar);

                String respuestaJson = serializadorJSON
                        .toJson(comentarioDTO);

                out.write(respuestaJson);
            } catch (BOException e) {
                out.write(e.getMessage());
            }
        }
    }
}
