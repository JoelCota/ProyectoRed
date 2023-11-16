/**
* PostComunEditadoDTO.java
* Jul 8, 2023 10:37:48 PM
*/ 

package org.itson.dto;
/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class PostComunEditadoDTO {
    
    private Long idPost;
    
    private String tituloPost;
    
    private String contenidoPost;


    /**
     * Constructor por default
     */
    public PostComunEditadoDTO(){

    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
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
