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
import org.itson.dto.EditarPostDTO;
import org.itson.dto.EliminarDTO;
import org.itson.dto.PeticionPostAncladoDTO;
import org.itson.dto.PeticionPostComunDTO;
import org.itson.dto.PostAncladoDTO;
import org.itson.dto.PostEditadoDTO;
import org.itson.dto.PostComunDTO;
import org.itson.dto.PostEliminadoDTO;
import org.itson.excepciones.BOException;
import org.itson.excepciones.ValidacionesDTOException;
import org.itson.implementaciones.FachadaBO;
import org.itson.red.dominio.Administrador;
import org.itson.red.dominio.Anclado;
import org.itson.red.dominio.Comun;
import org.itson.red.dominio.Post;
import org.itson.red.dominio.Usuario;
import org.itson.utils.DTOConverter;

/**
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
@WebServlet(name = "publicacionesV2Servlet", urlPatterns = {"/publicacionesV2Servlet"})
public class PublicacionesV2Servlet extends HttpServlet {

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

        if (action != null && action.equalsIgnoreCase("crear-post-comun")) {
            this.crearPublicacionComun(request, response);
            return;
        }

        if (action != null && action.equalsIgnoreCase("crear-post-anclado")) {
            this.crearPublicacionAnclado(request, response);
            return;
        }

        if (action != null && action.equalsIgnoreCase("eliminar-post")) {
            this.eliminarPost(request, response);
            return;
        }

        if (action != null && action.equalsIgnoreCase("editar-post")) {
            this.editarPost(request, response);
            return;
        }
    }

    private void crearPublicacionComun(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            String body = IOUtils.toString(request.getInputStream(), "utf-8");

            HttpSession session = request.getSession();

            Usuario usuario = (Usuario) session.getAttribute("usuario");

            PeticionPostComunDTO crearPostDTO
                    = serializadorJSON.fromJson(body, PeticionPostComunDTO.class);

            Comun postComun = DTOConverter.crearPostComunPorPeticion(crearPostDTO);

            //Solo se le asigna el usuario
            postComun.setUsuario(usuario);

            PostComunDTO postComunDTO = null;

            try {
                fachadaBO.registrarPostComun(postComun);
            } catch (BOException e) {
                
            }

            postComunDTO = DTOConverter.crearPostComunDTO(postComun);

            //Se crea la respuesta en formato json
            String respuestaJson = serializadorJSON.toJson(postComunDTO);

            out.write(respuestaJson);
        }

    }

    private void crearPublicacionAnclado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String body = IOUtils.toString(request.getInputStream(), "utf-8");

        HttpSession session = request.getSession();

        Administrador admin = (Administrador) session.getAttribute("usuario");

        PeticionPostAncladoDTO crearPostDTO
                = serializadorJSON.fromJson(body, PeticionPostAncladoDTO.class);

        Anclado postAnclado = DTOConverter.crearPostAncladoPorPeticion(
                crearPostDTO);

        //Solo se le asigna el usuario
        postAnclado.setAdministrador(admin);

        PostAncladoDTO postAncladoDTO = null;

        try {

            fachadaBO.registrarPostAnclado(postAnclado);

            postAncladoDTO = DTOConverter.crearPostAncladoDTO(postAnclado);

        } catch (BOException e) {

        }

        //Se crea la respuesta en formato json
        String respuestaJson = serializadorJSON.toJson(postAncladoDTO);

        try (PrintWriter out = response.getWriter()) {
            out.write(respuestaJson);
        }
    }

    private void eliminarPostComun(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            String body = IOUtils.toString(request.getInputStream(), "utf-8");

            EliminarDTO elimniarPostDTO = serializadorJSON
                    .fromJson(body, EliminarDTO.class);

            Long idPostComun =Long.parseLong(elimniarPostDTO.getIdElemento());
            System.out.println(idPostComun);

            try {
                Post post = fachadaBO.consultarPostPorId(idPostComun);

                fachadaBO.eliminarPost(post);
            } catch (BOException e) {
                out.write(e.getMessage());
            }

        }

    }



    private void editarPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            String body = IOUtils.toString(request.getInputStream(), "utf-8");

            EditarPostDTO editarPostAncladoDTO = serializadorJSON
                    .fromJson(body, EditarPostDTO.class);

            Long idPostAnclado = Long.valueOf(editarPostAncladoDTO.getIdPost());

            try {
                Post post = fachadaBO.consultarPostPorId(idPostAnclado);

                post.setTitulo(editarPostAncladoDTO.getTituloNuevo());
                post.setContenido(editarPostAncladoDTO.getContenidoNuevo());

                fachadaBO.editarPost(post);

                PostEditadoDTO postEditadoAnclado = DTOConverter
                        .crearPosEditadoDTO(post);

                String respuestaJson = serializadorJSON.toJson(postEditadoAnclado);

                out.write(respuestaJson);
            } catch (BOException e) {
                out.write(e.getMessage());
            }
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

    private void validarEliminarDTO(EliminarDTO eliminarDTO) throws ValidacionesDTOException {
        String errores = "";

        String idElementoEliminar = eliminarDTO.getIdElemento();

        if (idElementoEliminar == null || idElementoEliminar.trim().isBlank()) {
            errores += "- No hay ningún id en la petición\n";
        }

        if (idElementoEliminar != null) {
            try {
                Long idElementoCast = Long.valueOf(idElementoEliminar);
            } catch (NumberFormatException e) {
                errores += "- El id del elemento, no es válido\n";
            }
        }

        if (!errores.isEmpty()) {
            throw new ValidacionesDTOException(errores);
        }
    }

    private void validarEditarPostDTO(EditarPostDTO editarPost) throws ValidacionesDTOException {
        String errores = "";

        String idPost = editarPost.getIdPost();

        if (idPost == null || idPost.trim().isBlank()) {
            errores += "- No hay ningún id del post en la petición\n";
        }

        if (idPost != null) {
            try {
                Long idElementoCast = Long.valueOf(idPost);
            } catch (NumberFormatException e) {
                errores += "- El id del post, no es válido\n";
            }
        }

        String tituloNuevo = editarPost.getTituloNuevo();

        if (tituloNuevo == null || tituloNuevo.trim().isBlank()) {
            errores += "- No hay ningún titulo nuevo "
                    + "y no se puede guardar un nuevo post sin "
                    + "título del post en la petición\n";
        }

        String contenidoNuevo = editarPost.getContenidoNuevo();

        if (contenidoNuevo == null || contenidoNuevo.trim().isBlank()) {
            errores += "- No hay ningún contenido nuevo "
                    + "y no se puede guardar un nuevo post sin "
                    + "contenido del post en la petición\n";
        }

        if (!errores.isEmpty()) {
            throw new ValidacionesDTOException(errores);
        }
    }

}
