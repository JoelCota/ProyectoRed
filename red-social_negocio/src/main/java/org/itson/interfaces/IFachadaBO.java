/**
 * IFachadaBO.java
 * Jun 24, 2023 10:40:47 AM
 */
package org.itson.interfaces;

import java.util.List;
import javax.persistence.PersistenceException;
import org.itson.excepciones.BOException;
import org.itson.excepciones.PersistenciaException;
import org.itson.red.dominio.Administrador;
import org.itson.red.dominio.Anclado;
import org.itson.red.dominio.Comentario;
import org.itson.red.dominio.Comun;
import org.itson.red.dominio.Estado;
import org.itson.red.dominio.Municipio;
import org.itson.red.dominio.Normal;
import org.itson.red.dominio.Post;
import org.itson.red.dominio.Usuario;

/**
 * Descripción de la interface:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public interface IFachadaBO {

    public Post consultarPostPorId(Long id) throws BOException;

    public List<Anclado> consultarPostsAncladosPaginadoRecientes(int elementosPorPagina, int numeroPagina) throws BOException;

    public List<Comun> consultarPostsComunesPaginadoRecientes(int elementosPorPagina, int numeroPagina) throws BOException;

    public Comentario registarComentario(Comentario comentario) throws BOException;

    public Comentario eliminarComentario(Comentario comentario) throws BOException;

    public Usuario registrarUsuarioNormal(Normal usuario) throws PersistenciaException;

    public Usuario registrarUsuarioAdministrador(Administrador usuario) throws PersistenciaException;

    public Usuario consultarUsuarioParaLogin(String correo, String password) throws PersistenciaException;

    public Usuario consultarUsuarioPorId(Long id) throws PersistenciaException;

    public Comentario consultarComentarioPorId(Long id) throws BOException;

    public Post registrarPostComun(Comun post) throws BOException;

    public Post registrarPostAnclado(Anclado post) throws BOException;

    public List<Estado> consultaListaEstados() throws PersistenciaException;
    
    public List<Municipio> consultaListaMunicipios() throws PersistenciaException;

    public Municipio buscarMunicipioNombre(String nombre) throws PersistenceException;

    public Post editarPostComun(Comun post) throws BOException;
    
    public Post editarPostAnclado(Anclado post) throws BOException;
    
    public Post eliminarPost(Post post) throws BOException;
    
    public List<Comun> consultarPostsComunesPorUsuarioPaginadoRecientes (Usuario usuario, int elementosPorPagina, int numeroPagina) throws PersistenciaException; 
    
    public List<Anclado> consultarPostsAncladosPorUsuarioPaginadoRecientes (Usuario usuario, int elementosPorPagina, int numeroPagina) throws PersistenciaException; 
    
    public Anclado eliminarPostAnclado(Anclado anclado) throws BOException;

    public Comun eliminarPostComun(Comun comun) throws BOException;
    
    public Post editarPost(Post post) throws BOException;
    
    public List<Post> buscadorPost(String busqueda) throws PersistenceException;
}
