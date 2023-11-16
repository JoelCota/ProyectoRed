/**
* CrearPostAncladoDTO.java
* Jul 6, 2023 1:31:56 PM
*/ 

package org.itson.dto;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class PeticionPostAncladoDTO {
    
    private String tituloPost;
    private String contenidoPost;

    /**
     *
     */
    public PeticionPostAncladoDTO(){

    }

    public PeticionPostAncladoDTO(String tituloPost, String contenidoPost) {
        this.tituloPost = tituloPost;
        this.contenidoPost = contenidoPost;
    }

    public String getTituloPost() {
        return tituloPost;
    }

    public void setTituloPost(String tituloPost) {
        this.tituloPost = tituloPost;
    }

    public String getContenidoPost() {
        return contenidoPost;
    }

    public void setContenidoPost(String contenidoPost) {
        this.contenidoPost = contenidoPost;
    }
    
}
