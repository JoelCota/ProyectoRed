/**
* PublicacionDTO.java
* Jul 5, 2023 11:47:04 PM
*/ 

package org.itson.dto;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class PeticionPostComunDTO {
    
    private String tituloPost;
    
    private String contenidoPost;
    
    
    /**
     *
     */
    public PeticionPostComunDTO(){

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
