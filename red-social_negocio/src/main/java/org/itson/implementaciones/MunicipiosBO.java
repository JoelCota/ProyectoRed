/**
 * MunicipiosBO.java
 * Jun 28, 2023 5:46:47 PM
 */
package org.itson.implementaciones;

import java.util.List;
import javax.persistence.PersistenceException;
import org.itson.excepciones.BOException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionException;
import org.itson.interfaces.IMunicipiosBO;
import org.itson.red.dominio.Municipio;

/**
 *
 *
 * @author Joel Antonio Lopez Cota ID:228926
 */
public class MunicipiosBO implements IMunicipiosBO {

    FachadaPersistencia persistencia;

    /**
     *
     */
    public MunicipiosBO() {
        persistencia = new FachadaPersistencia();
    }

    @Override
    public List<Municipio> consultaListaMunicipios() throws PersistenciaException {
        try {
            return persistencia.consultaListaMunicipios();
        } catch (ValidacionException | PersistenciaException e) {
            throw new BOException("Ocurrió un error al recuperar los municipio");
        }
    }

    @Override
    public Municipio buscarMunicipioNombre(String nombre) throws PersistenceException {
        try {
            return persistencia.buscarMunicipioNombre(nombre);
        } catch (ValidacionException | PersistenciaException e) {
            throw new BOException("Ocurrió un error al recuperar el municipio ");
        }
    }
}
