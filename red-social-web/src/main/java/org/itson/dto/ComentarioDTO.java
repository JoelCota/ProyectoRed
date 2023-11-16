/**
* RegresarComentarioDTO.java
* Jul 6, 2023 8:25:28 PM
*/ 

package org.itson.dto;

import java.util.List;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class ComentarioDTO {
    
    private Long idPost;
    
    private String usuarioNombreCompleto;
    
    private String contenidoComentario;
    
    private List<RespuestaComentarioDTO> respuestasComentario;

    /**
     * Constructor por default
     */
    public ComentarioDTO(){

    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public String getUsuarioNombreCompleto() {
        return usuarioNombreCompleto;
    }

    public void setUsuarioNombreCompleto(String usuarioNombreCompleto) {
        this.usuarioNombreCompleto = usuarioNombreCompleto;
    }

    public String getContenidoComentario() {
        return contenidoComentario;
    }

    public void setContenidoComentario(String contenidoComentario) {
        this.contenidoComentario = contenidoComentario;
    }

    public List<RespuestaComentarioDTO> getRespuestasComentario() {
        return respuestasComentario;
    }

    public void setRespuestasComentario(List<RespuestaComentarioDTO> respuestasComentario) {
        this.respuestasComentario = respuestasComentario;
    }
    
    public void agregarRespuestaDTO(){
        
    }
}
