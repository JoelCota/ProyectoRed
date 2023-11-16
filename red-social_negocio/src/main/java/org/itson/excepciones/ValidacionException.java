/**
* ValidacionException.java
* Jun 24, 2023 10:16:32 AM
*/ 

package org.itson.excepciones;
/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class ValidacionException extends RuntimeException{

    /**
     * Constructor por default
     */
    public ValidacionException(){

    }

    public ValidacionException(String message) {
        super(message);
    }

    public ValidacionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidacionException(Throwable cause) {
        super(cause);
    }

    public ValidacionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
}
