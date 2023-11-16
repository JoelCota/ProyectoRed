/**
 * ServletException.java
 * Jul 9, 2023 6:34:57 PM
 */
package org.itson.excepciones;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class ServletException extends RuntimeException {

    /**
     * Constructor por default
     */
    public ServletException() {
        super();
    }

    public ServletException(String message) {
        super(message);
    }

    public ServletException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServletException(Throwable cause) {
        super(cause);
    }

    public ServletException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
