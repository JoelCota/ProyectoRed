/**
* PostEditadoDTO.java
* Jul 8, 2023 9:24:55 PM
*/ 

package org.itson.dto;
/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class PostEditadoDTO {
    
    private Long idPost;
    
    private String tituloPost;
    
    private String contenidoPost;

    /**
     * Constructor por default
     */
    public PostEditadoDTO(){

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
