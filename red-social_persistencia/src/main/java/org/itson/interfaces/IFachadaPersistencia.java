/**
 * IPersistencia.java
 * Jun 13, 2023 1:44:06 AM
 */
package org.itson.interfaces;

import java.util.List;
import javax.persistence.PersistenceException;
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
 * @author Joel Antonio Lopez Cota ID:228926
 */
public interface IFachadaPersistencia {

    Post registrarPostComun(Comun post) throws PersistenciaException;

    Post registrarPostAnclado(Anclado post) throws PersistenciaException;

    Post editarPostComun(Comun post) throws PersistenciaException;

    Post editarPostAnclado(Anclado post) throws PersistenciaException;

    Post eliminarPost(Post post) throws PersistenceException;

    Usuario registrarUsuarioNormal(Normal usuario) throws PersistenciaException;

    Usuario registrarUsuarioAdministrador(Administrador usuario) throws PersistenciaException;

    Usuario consultarUsuarioParaLogin(String correo, String password) throws PersistenciaException;

    Usuario consultarUsuarioPorId(Long id) throws PersistenceException;

    Estado registrarEstado(Estado estado) throws PersistenciaException;

    Estado editarEstado(Estado estado) throws PersistenciaException;

    List<Estado> consultaListaEstados() throws PersistenciaException;

    Comentario consultarComentarioPorId(Long id) throws PersistenciaException;

    Comentario registarComentario(Comentario comentario) throws PersistenciaException;

    Comentario eliminarComentario(Comentario comentario) throws PersistenciaException;

    Municipio registrarMunicipio(Municipio municipio) throws PersistenciaException;

    Post consultarPostPorId(Long id) throws PersistenciaException;

    List<Anclado> consultarPostsAncladosPaginadoRecientes(int elementosPorPagina, int numeroPagina) throws PersistenciaException;
    
    List<Comun> consultarPostsComunesPorUsuarioPaginadoRecientes (Usuario usuario, int elementosPorPagina, int numeroPagina) throws PersistenciaException; 

    public List<Anclado> consultarPostsAncladosPorUsuarioPaginadoRecientes(Usuario usuario, int elementosPorPagina, int numeroPagina) throws PersistenciaException;   
    
    public List<Comun> consultarPostsComunesPaginadoRecientes(int elementosPorPagina, int numeroPagina) throws PersistenciaException;

    public List<Municipio> consultaListaMunicipios() throws PersistenciaException;

    public Municipio buscarMunicipioNombre(String nombre) throws PersistenceException;
    
    public Anclado eliminarPostAnclado(Anclado anclado) throws PersistenceException;
    
    public Comun eliminarPostComun(Comun comun) throws PersistenceException;
    
    public Post editarPost(Post post) throws PersistenciaException;
    
    public List<Post> buscadorPost(String busqueda) throws PersistenceException;
}
