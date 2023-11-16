/**
 * IFactoryDAO.java
 * 13 jun. 2023 07:35:41
 */
package org.itson.implementaciones;

import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IComentariosDAO;
import org.itson.interfaces.IEstadosDAO;
import org.itson.interfaces.IMunicipioDAO;
import org.itson.interfaces.IPostsDAO;
import org.itson.interfaces.IUsuariosDAO;

/**
 * Clase encargada de crea
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class FactoryDAO {

    /**
     * Constructor por default
     */
    public FactoryDAO() {

    }

    public static IComentariosDAO getComentariosDAO() throws PersistenciaException {
        return new ComentariosDAO();
    }

    public static IEstadosDAO getEstadosDAO() throws PersistenciaException {
        return new EstadosDAO();
    }

    public static IPostsDAO getPostsDAO() throws PersistenciaException {
        return new PostsDAO();
    }

    public static IUsuariosDAO getUsuariosDAO() throws PersistenciaException {
        return new UsuariosDAO();
    }

    public static IMunicipioDAO getMunicipioDAO() throws PersistenciaException {
        return new MunicipioDAO();
    }
}
