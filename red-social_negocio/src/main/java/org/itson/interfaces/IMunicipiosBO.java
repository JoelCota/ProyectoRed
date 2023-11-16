/**
* IMunicipiosBO.java
* Jun 28, 2023 5:47:13 PM
*/ 

package org.itson.interfaces;

import java.util.List;
import javax.persistence.PersistenceException;
import org.itson.excepciones.PersistenciaException;
import org.itson.red.dominio.Municipio;

/**
 * Descripción de la interface: 
 *
 * @author Joel Antonio Lopez Cota ID:228926
 */
public interface IMunicipiosBO {
  
    public List<Municipio> consultaListaMunicipios() throws PersistenciaException;

    public Municipio buscarMunicipioNombre(String nombre) throws PersistenceException;
}
