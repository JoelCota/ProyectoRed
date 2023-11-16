/**
* RespuestaDTO.java
* Jul 5, 2023 11:45:26 PM
*/ 

package org.itson.dto;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class CrearRespuestaComentarioDTO {
    
    private String idComentario;
    
    private String contenido;

    /**
     *
     */
    public CrearRespuestaComentarioDTO(){

    }

    public CrearRespuestaComentarioDTO(String idComentario, String contenido) {
        this.idComentario = idComentario;
        this.contenido = contenido;
    }

    public String getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(String idComentario) {
        this.idComentario = idComentario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    
}
