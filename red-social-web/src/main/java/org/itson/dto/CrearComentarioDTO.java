/**
* ComentarioDTO.java
* Jul 5, 2023 11:40:09 PM
*/ 

package org.itson.dto;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class CrearComentarioDTO {
    
    private String idPost;
    
    private String contenidoComentario;

    /**
     *
     */
    public CrearComentarioDTO(){

    }

    public CrearComentarioDTO(String idPost, String contenidoComentario) {
        this.idPost = idPost;
        this.contenidoComentario = contenidoComentario;
    }

    public String getIdPost() {
        return idPost;
    }

    public void setIdPost(String idPost) {
        this.idPost = idPost;
    }

    public String getContenidoComentario() {
        return contenidoComentario;
    }

    public void setContenidoComentario(String contenidoComentario) {
        this.contenidoComentario = contenidoComentario;
    }
}
