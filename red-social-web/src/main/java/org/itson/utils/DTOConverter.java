/**
 * DTOConverter.java
 * Jul 7, 2023 11:34:01 AM
 */
package org.itson.utils;

import java.util.LinkedList;
import java.util.List;
import org.itson.dto.ComentarioDTO;
import org.itson.dto.CrearComentarioDTO;
import org.itson.dto.PeticionPostAncladoDTO;
import org.itson.dto.PeticionPostComunDTO;
import org.itson.dto.CrearRespuestaComentarioDTO;
import org.itson.dto.EliminarDTO;
import org.itson.dto.PostAncladoDTO;
import org.itson.dto.PostComunDTO;
import org.itson.dto.PostEditadoDTO;
import org.itson.dto.PostComunEditadoDTO;
import org.itson.dto.PostEliminadoDTO;
import org.itson.dto.RespuestaComentarioDTO;
import org.itson.excepciones.ValidacionesDTOException;
import org.itson.red.dominio.Anclado;
import org.itson.red.dominio.Comentario;
import org.itson.red.dominio.Comun;
import org.itson.red.dominio.Post;

/**
 * Descripción de la cimport org.itson.red.dominio.Post; lase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class DTOConverter {

    public static PostAncladoDTO crearPostAncladoDTO(Anclado postAnclado) {

        PostAncladoDTO postAncladoDTO = new PostAncladoDTO();

        postAncladoDTO.setIdPost(postAnclado.getId());
        postAncladoDTO.setTitulo(postAnclado.getTitulo());
        postAncladoDTO.setContenido(postAnclado.getContenido());
        postAncladoDTO.setFechaCreacion(postAnclado.getFechaCreacionToString());

        return postAncladoDTO;
    }

    public static PostComunDTO crearPostComunDTO(Comun postComun) {

        PostComunDTO postComunDTO = new PostComunDTO();

        postComunDTO.setIdPost(postComun.getId());
        postComunDTO.setTitulo(postComun.getTitulo());
        postComunDTO.setContenido(postComun.getContenido());
        postComunDTO.setFechaCreacion(postComun.getFechaCreacionToString());

        List<Comentario> comentariosPost = postComun.getComentarios();

        List<ComentarioDTO> comentariosPostDTO = new LinkedList<>();

        for (Comentario comentario : comentariosPost) {
            comentariosPostDTO.add(
                    crearComentarioDTO(comentario));
        }

        postComunDTO.setComentarios(comentariosPostDTO);

        return postComunDTO;
    }

    public static ComentarioDTO crearComentarioDTO(Comentario comentario) {

        ComentarioDTO comentarioDTO = new ComentarioDTO();

        comentarioDTO.setContenidoComentario(comentario.getContenido());
        comentarioDTO.setIdPost(comentario.getPostComun().getId());
        comentarioDTO.setUsuarioNombreCompleto(
                comentario.getUsuarioNormal().getNombreCompleto());

        List<Comentario> respuestasComentario = comentario.getRespuestas();
        List<RespuestaComentarioDTO> respuestasDTO = new LinkedList<>();

        for (Comentario respuesta : respuestasComentario) {
            respuestasDTO.add(crearRespuestaComentarioDTO(respuesta));
        }

        comentarioDTO.setRespuestasComentario(respuestasDTO);

        return comentarioDTO;

    }

    public static Comentario crearComentarioPorPeticion(CrearComentarioDTO comentarioDTO) {

        Comentario comentario = new Comentario();
        comentario.setContenido(comentarioDTO.getContenidoComentario());

        return comentario;
    }

    public static RespuestaComentarioDTO crearRespuestaComentarioDTO(
            Comentario respuesta) {

        RespuestaComentarioDTO respuestaDTO = new RespuestaComentarioDTO();

        respuestaDTO.setUsuarioNombreCompleto(
                respuesta.getUsuarioNormal().getNombreCompleto());
        respuestaDTO.setContenidoRespuesta(respuesta.getContenido());
        respuestaDTO.setIdComentario(respuesta.getComentario().getId());

        return respuestaDTO;
    }

    public static Comentario crearRespuestaComentarioPorPeticion(
            CrearRespuestaComentarioDTO respuestaDTO) {

        Comentario respuesta = new Comentario();

        respuesta.setContenido(respuestaDTO.getContenido());

        return respuesta;
    }

    public static Comun crearPostComunPorPeticion(
            PeticionPostComunDTO postComunDTO) {

        validarPeticionPostComunDTO(postComunDTO);

        Comun postComun = new Comun();

        postComun.setTitulo(postComunDTO.getTituloPost());
        postComun.setContenido(postComunDTO.getContenidoPost());

        return postComun;
    }

    public static Anclado crearPostAncladoPorPeticion(
            PeticionPostAncladoDTO postAncladoDTO) {

        Anclado postAnclado = new Anclado();

        validarPeticionPostAncaldoDTO(postAncladoDTO);
        
        postAnclado.setTitulo(postAncladoDTO.getTituloPost());
        postAnclado.setContenido(postAncladoDTO.getContenidoPost());

        return postAnclado;
    }

    public static PostEliminadoDTO crearPostComunEliminadoDTO(Comun postComun) {

        PostEliminadoDTO postEliminado = new PostEliminadoDTO();

        postEliminado.setIdPostEliminado(postComun.getId());
        postEliminado.setContenidoEliminado(postComun.getContenido());
        postEliminado.setTituloEliminado(postComun.getTitulo());
        postEliminado.setNombreUsuarioPropietarioPost(
                postComun.getUsuario().getNombreCompleto());

        return postEliminado;
    }

    public static PostEliminadoDTO crearPostAncladoEliminadoDTO(Post post) {

        PostEliminadoDTO postEliminado = new PostEliminadoDTO();

        postEliminado.setIdPostEliminado(post.getId());
        postEliminado.setContenidoEliminado(post.getContenido());
        postEliminado.setTituloEliminado(post.getTitulo());
        if (post instanceof Anclado) {
            Anclado anclado = (Anclado) post;
            postEliminado.setNombreUsuarioPropietarioPost(
                    anclado.getAdministrador().getNombreCompleto());
        }

        if (post instanceof Comun) {
            Comun comun = (Comun) post;
            postEliminado.setNombreUsuarioPropietarioPost(
                    comun.getUsuario().getNombreCompleto());
        }

        return postEliminado;
    }

    public static PostEditadoDTO crearPosEditadoDTO(
            Post post) {

        PostEditadoDTO postEditadoAnclado = new PostEditadoDTO();

        postEditadoAnclado.setIdPost(post.getId());
        postEditadoAnclado.setTituloPost(post.getTitulo());
        postEditadoAnclado.setContenidoPost(post.getContenido());

        return postEditadoAnclado;
    }

    public static PostComunEditadoDTO crearPostComunEditadoDTO(
            Comun comun) {

        PostComunEditadoDTO postEditadoComun = new PostComunEditadoDTO();

        postEditadoComun.setIdPost(comun.getId());
        postEditadoComun.setTituloPost(comun.getTitulo());
        postEditadoComun.setContenidoPost(comun.getContenido());

        return postEditadoComun;
    }

    // Se crean los métodos para validar las DTO

    /**
     * 
     * @param peticionPostDTO
     * @throws ValidacionesDTOException
     */
    private static void validarPeticionPostComunDTO(PeticionPostComunDTO peticionPostDTO) throws ValidacionesDTOException {

        String errores = "";

        //Valida si cuenta con el título
        String tituloPost = peticionPostDTO.getTituloPost();

        if(tituloPost == null || tituloPost.trim().isBlank()){
            errores+= "- No hay titulo en la petición\n";
        }

        String contenidoPost = peticionPostDTO.getContenidoPost();

        if(contenidoPost == null || contenidoPost.trim().isBlank()){
            errores+= " No hay contenido\n";
        }

        if(!errores.isEmpty()){
            throw new ValidacionesDTOException(errores);
        }
    }
    
    /**
     * 
     * @param peticionPostDTO
     * @throws ValidacionesDTOException
     */
    private static void validarPeticionPostAncaldoDTO(PeticionPostAncladoDTO peticionPostDTO) throws ValidacionesDTOException {

        String errores = "";

        //Valida si cuenta con el título
        String tituloPost = peticionPostDTO.getTituloPost();

        if(tituloPost == null || tituloPost.trim().isBlank()){
            errores+= "- No hay titulo en la petición\n";
        }

        String contenidoPost = peticionPostDTO.getContenidoPost();

        if(contenidoPost == null || contenidoPost.trim().isBlank()){
            errores+= " No hay contenido\n";
        }

        if(!errores.isEmpty()){
            throw new ValidacionesDTOException(errores);
        }
    }
    
    
}
