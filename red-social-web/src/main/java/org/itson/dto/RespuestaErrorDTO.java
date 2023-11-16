/**
* RespuestaErrorDTO.java
* Jul 9, 2023 11:08:37 AM
*/ 

package org.itson.dto;
/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class RespuestaErrorDTO {
    
    private String hrefPaginaError;

    /**
     * Constructor por default
     */
    public RespuestaErrorDTO(){

    }

    public String getHrefPaginaError() {
        return hrefPaginaError;
    }

    public void setHrefPaginaError(String hrefPaginaError) {
        this.hrefPaginaError = hrefPaginaError;
    }
    
    
}
