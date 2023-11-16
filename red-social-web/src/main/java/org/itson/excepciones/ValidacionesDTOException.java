/**
* ValidacionesDTOException.java
* Jul 9, 2023 6:20:01 PM
*/ 

package org.itson.excepciones;
/**
 * Descripción de la clase: 
 * 
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class ValidacionesDTOException extends RuntimeException{

    /**
     * Constructor por default
     */
    public ValidacionesDTOException(){
        super();
    }

    public ValidacionesDTOException(String message) {
        super(message);
    }

    public ValidacionesDTOException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidacionesDTOException(Throwable cause) {
        super(cause);
    }

    public ValidacionesDTOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
}
