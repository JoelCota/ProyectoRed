/**
 * DataBaseConection.java
 * 11 jun. 2023 01:52:46
 */
package org.itson.conexion;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class ConexionBD {

    /**
     * Direccion para la conexión a la base de datos
     */
    private String direccion = "org.itson_red-social_dominio_jar_1.0-SNAPSHOTPU";

    /**
     * Entity manager factory que utilizaremos para llamar al entity manager
     */
    private static EntityManagerFactory factory;

    /**
     * Una instancia de la misma clase para que solo pueda llamarse y
     * construirse a así misma
     */
    private static ConexionBD conexion;

    /**
     * Constructor que inicializa el entitymanager factory
     */
    private ConexionBD() {
        try {
            factory = Persistence.createEntityManagerFactory(direccion);
        } catch (Exception e) {
            throw new PersistenceException("Ocurrió un error al conectarse con la base de datos");
        }
    }

    /**
     * Obtiene el entityManager para realizar las operaciones dentro de la base
     * de datos, además de realizar la construcción para la conexión en caso de
     * nunca haber sido llamada
     *
     * @return EntityManagerFactory para la conexión a la base de datos
     */
    public static EntityManagerFactory getConection() {
        if (conexion == null) {
            ConexionBD.conexion = new ConexionBD();
        }
        return factory;
    }
}
