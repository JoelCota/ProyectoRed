/**
* PostEliminadoDTO.java
* Jul 8, 2023 1:29:17 PM
*/ 

package org.itson.dto;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class PostEliminadoDTO {
    
    private Long idPostEliminado;
    
    private String nombreUsuarioPropietarioPost;
    
    private String tituloEliminado;
    
    private String contenidoEliminado;

    /**
     *
     */
    public PostEliminadoDTO(){

    }

    public Long getIdPostEliminado() {
        return idPostEliminado;
    }

    public void setIdPostEliminado(Long idPostEliminado) {
        this.idPostEliminado = idPostEliminado;
    }

    public String getNombreUsuarioPropietarioPost() {
        return nombreUsuarioPropietarioPost;
    }

    public void setNombreUsuarioPropietarioPost(String nombreUsuarioPropietarioPost) {
        this.nombreUsuarioPropietarioPost = nombreUsuarioPropietarioPost;
    }

    public String getTituloEliminado() {
        return tituloEliminado;
    }

    public void setTituloEliminado(String tituloEliminado) {
        this.tituloEliminado = tituloEliminado;
    }

    public String getContenidoEliminado() {
        return contenidoEliminado;
    }

    public void setContenidoEliminado(String contenidoEliminado) {
        this.contenidoEliminado = contenidoEliminado;
    }
    
}
