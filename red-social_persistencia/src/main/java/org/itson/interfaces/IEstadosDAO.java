/**
* IEstadosDAO.java
* 13 jun. 2023 07:20:36
*/ 

package org.itson.interfaces;

import java.util.List;
import org.itson.excepciones.PersistenciaException;
import org.itson.red.dominio.Estado;

/**
 * Descripción de la interface: 
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface IEstadosDAO {

    public Estado registrarEstado(Estado estado) throws PersistenciaException;
    
    public Estado editarEstado(Estado estado) throws PersistenciaException;
    
    public List<Estado> consultaListaEstados()throws PersistenciaException;
}
