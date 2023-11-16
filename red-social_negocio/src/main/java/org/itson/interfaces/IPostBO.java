/**
 * IPostBO.java
 * Jun 23, 2023 4:03:58 PM
 */
package org.itson.interfaces;

import java.util.List;
import javax.persistence.PersistenceException;
import org.itson.excepciones.BOException;
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
public interface IPostBO {

    public Post consultarPostPorId(Long id) throws BOException;

    public List<Anclado> consultarPostsAncladosPaginadoRecientes(int elementosPorPagina, int numeroPagina) throws BOException;

    public List<Comun> consultarPostsComunesPaginadoRecientes(int elementosPorPagina, int numeroPagina) throws BOException;

    public Post registrarPostComun(Comun post) throws BOException;

    public Post registrarPostAnclado(Anclado post) throws BOException;

    public Post editarPostComun(Comun post) throws BOException;

    public Post editarPostAnclado(Anclado post) throws BOException;

    public Post eliminarPost(Post post) throws BOException;

    public List<Comun> consultarPostsComunesPorUsuarioPaginadoRecientes(Usuario usuario, int elementosPorPagina, int numeroPagina) throws PersistenciaException;

    public List<Anclado> consultarPostsAncladosPorUsuarioPaginadoRecientes(Usuario usuario, int elementosPorPagina, int numeroPagina) throws PersistenciaException;

    public Anclado eliminarPostAnclado(Anclado anclado) throws BOException;

    public Comun eliminarPostComun(Comun comun) throws BOException;
    
    public Post editarPost(Post post) throws BOException;
    
    public List<Post> buscadorPost(String busqueda) throws PersistenceException;
}
