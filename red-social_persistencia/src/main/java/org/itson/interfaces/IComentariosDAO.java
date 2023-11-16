/**
* IComentariosDAO.java
* 13 jun. 2023 07:20:28
*/ 

package org.itson.interfaces;

import org.itson.excepciones.PersistenciaException;
import org.itson.red.dominio.Comentario;

/**
 * Descripción de la interface: 
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface IComentariosDAO {

    public Comentario consultarComentarioPorId(Long id) throws PersistenciaException;
    
    public Comentario registarComentario(Comentario comentario) throws PersistenciaException;
    
    public Comentario eliminarComentario(Comentario comentario) throws PersistenciaException;
}
