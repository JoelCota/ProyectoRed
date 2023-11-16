/**
 * IMunicipio.java
 * 13 jun. 2023 07:47:05
 */
package org.itson.interfaces;

import java.util.List;
import javax.persistence.PersistenceException;
import org.itson.excepciones.PersistenciaException;
import org.itson.red.dominio.Municipio;

/**
 * Descripción de la interface:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface IMunicipioDAO {

    public Municipio registrarMunicipio(Municipio municipio) throws PersistenceException;

    public List<Municipio> consultaListaMunicipios() throws PersistenciaException;

    public Municipio buscarMunicipioNombre(String nombre) throws PersistenceException;

}
