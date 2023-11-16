/**
* IEstadosBO.java
* Jun 27, 2023 10:58:01 PM
*/ 

package org.itson.interfaces;

import java.util.List;
import org.itson.excepciones.PersistenciaException;
import org.itson.red.dominio.Estado;

/**
 * Descripción de la interface: 
 *
 * @author Joel Antonio Lopez Cota ID:228926
 */
public interface IEstadosBO {
    
        public List<Estado> consultaListaEstados()throws PersistenciaException;

}
