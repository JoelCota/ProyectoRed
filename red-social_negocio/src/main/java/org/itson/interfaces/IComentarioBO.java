/**
 * IComentarioBO.java
 * Jun 25, 2023 11:03:34 AM
 */
package org.itson.interfaces;

import org.itson.excepciones.BOException;
import org.itson.red.dominio.Comentario;
import org.itson.red.dominio.Usuario;

/**
 * Descripción de la interface:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface IComentarioBO {

    public Comentario registarComentario(Comentario comentario) throws BOException;

    public Comentario eliminarComentario(Comentario comentario) throws BOException;

    public Comentario consultarComentarioPorId(Long id) throws BOException;

}
