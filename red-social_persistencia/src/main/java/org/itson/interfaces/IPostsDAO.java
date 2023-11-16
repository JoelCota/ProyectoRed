/**
 * IPostsDAO.java
 * 13 jun. 2023 07:20:59
 */
package org.itson.interfaces;

import java.util.List;
import javax.persistence.PersistenceException;
import org.itson.excepciones.PersistenciaException;
import org.itson.red.dominio.Anclado;
import org.itson.red.dominio.Comun;
import org.itson.red.dominio.Post;
import org.itson.red.dominio.Usuario;

/**
 * Descripción de la interface:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface IPostsDAO {

    public Post registrarPostComun(Comun post) throws PersistenciaException;

    public Post registrarPostAnclado(Anclado post) throws PersistenciaException;

    public Post editarPostComun(Comun post) throws PersistenciaException;

    public Post editarPostAnclado(Anclado post) throws PersistenciaException;

    public Post eliminarPost(Post post) throws PersistenciaException;

    public Anclado eliminarPostAnclado(Anclado anclado) throws PersistenceException;

    public Comun eliminarPostComun(Comun comun) throws PersistenceException;

    public Post consultarPostPorId(Long id) throws PersistenciaException;

    public List<Anclado> consultarPostsAncladosPaginadoRecientes(int elementosPorPagina, int numeroPagina) throws PersistenciaException;

    public List<Comun> consultarPostsComunesPaginadoRecientes(int elementosPorPagina, int numeroPagina) throws PersistenciaException;

    public List<Comun> consultarPostsComunesPorUsuarioPaginadoRecientes(Usuario usuario, int elementosPorPagina, int numeroPagina) throws PersistenciaException;

    public List<Anclado> consultarPostsAncladosPorUsuarioPaginadoRecientes(Usuario usuario, int elementosPorPagina, int numeroPagina) throws PersistenciaException;

    public Post editarPost(Post post) throws PersistenciaException;

    public List<Post> buscadorPost(String busqueda) throws PersistenceException;
}
