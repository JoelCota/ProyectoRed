/**
* RespuestaJson.java
* Jul 5, 2023 10:30:21 AM
*/ 

package org.itson.dto;

import java.util.LinkedList;
import java.util.List;

/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class RespuestaJsonDTO{
    
    private String mensaje;
    
    private String mensajeError;
    
    private Object objetoEnviar;

    public Object getObjetoEnviar() {
        return objetoEnviar;
    }

    public void setObjetoEnviar(Object objetoEnviar) {
        this.objetoEnviar = objetoEnviar;
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}
