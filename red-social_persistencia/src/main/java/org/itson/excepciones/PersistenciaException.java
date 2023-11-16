/**
* PersistenceException.java
* 11 jun. 2023 01:58:31
*/ 

package org.itson.excepciones;
/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class PersistenciaException extends RuntimeException{

    /**
     * Constructor por default
     */
    public PersistenciaException(){

    }

    /**
     * Método constructor que recibe un mensaje
     * @param message a recibir
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Método constructor que recibe un mensaje y una causa
     * @param message a recibir
     * @param cause a describir
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistenciaException(Throwable cause) {
        super(cause);
    }

    public PersistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
