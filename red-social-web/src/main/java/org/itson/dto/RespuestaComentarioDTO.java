/**
* RespuestaComentarioDTO.java
* Jul 6, 2023 8:25:45 PM
*/ 

package org.itson.dto;
/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class RespuestaComentarioDTO {
    
    private Long idComentario;
    
    private String usuarioNombreCompleto;
    
    private String contenidoRespuesta;

    /**
     * Constructor por default
     */
    public RespuestaComentarioDTO(){

    }

    public Long getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Long idComentario) {
        this.idComentario = idComentario;
    }

    public String getUsuarioNombreCompleto() {
        return usuarioNombreCompleto;
    }

    public void setUsuarioNombreCompleto(String usuarioNombreCompleto) {
        this.usuarioNombreCompleto = usuarioNombreCompleto;
    }

    public String getContenidoRespuesta() {
        return contenidoRespuesta;
    }

    public void setContenidoRespuesta(String contenidoRespuesta) {
        this.contenidoRespuesta = contenidoRespuesta;
    }
    
    
}
