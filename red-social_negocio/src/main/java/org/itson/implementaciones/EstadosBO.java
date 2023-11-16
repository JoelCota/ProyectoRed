/**
 * EstadosBO.java
 * Jun 27, 2023 11:00:16 PM
 */
package org.itson.implementaciones;

import java.util.List;
import org.itson.excepciones.BOException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionException;
import org.itson.interfaces.IEstadosBO;
import org.itson.red.dominio.Estado;

/**
 *
 *
 * @author Joel Antonio Lopez Cota ID:228926
 */
public class EstadosBO implements IEstadosBO {

    FachadaPersistencia persistencia;

    /**
     *
     */
    public EstadosBO() {
        persistencia = new FachadaPersistencia();
    }

    @Override
    public List<Estado> consultaListaEstados() throws PersistenciaException {
        try {
            return persistencia.consultaListaEstados();
        } catch (ValidacionException | PersistenciaException e) {
            throw new BOException("Ocurrió un error al recuperar los estados ");
        }
    }
}
