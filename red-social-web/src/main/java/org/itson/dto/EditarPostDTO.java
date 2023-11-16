/**
* EditarPostAncladoDTO.java
* Jul 8, 2023 7:36:10 PM
*/ 

package org.itson.dto;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class EditarPostDTO {
    
    private String idPost;
    
    private String tituloNuevo;
    
    private String contenidoNuevo;

    /**
     *
     */
    public EditarPostDTO(){

    }

    public String getIdPost() {
        return idPost;
    }

    public void setIdPost(String idPost) {
        this.idPost = idPost;
    }

    public String getTituloNuevo() {
        return tituloNuevo;
    }

    public void setTituloNuevo(String tituloNuevo) {
        this.tituloNuevo = tituloNuevo;
    }

    public String getContenidoNuevo() {
        return contenidoNuevo;
    }

    public void setContenidoNuevo(String contenidoNuevo) {
        this.contenidoNuevo = contenidoNuevo;
    }
}
