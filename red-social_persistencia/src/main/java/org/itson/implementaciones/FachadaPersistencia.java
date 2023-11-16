/**
 * Persistencia.java
 * 13 jun. 2023 07:19:56
 */
package org.itson.implementaciones;

import java.util.List;
import javax.persistence.PersistenceException;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IComentariosDAO;
import org.itson.interfaces.IEstadosDAO;
import org.itson.interfaces.IMunicipioDAO;
import org.itson.interfaces.IPostsDAO;
import org.itson.interfaces.IUsuariosDAO;
import org.itson.red.dominio.Administrador;
import org.itson.red.dominio.Anclado;
import org.itson.red.dominio.Comentario;
import org.itson.red.dominio.Comun;
import org.itson.red.dominio.Estado;
import org.itson.red.dominio.Municipio;
import org.itson.red.dominio.Normal;
import org.itson.red.dominio.Post;
import org.itson.red.dominio.Usuario;
import org.itson.interfaces.IFachadaPersistencia;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class FachadaPersistencia implements IFachadaPersistencia {

    IComentariosDAO comentariosDAO;
    IEstadosDAO estadosDAO;
    IPostsDAO postsDAO;
    IUsuariosDAO usuariosDAO;
    IMunicipioDAO municipioDAO;

    /**
     * Constructor por default
     */
    public FachadaPersistencia() {
        comentariosDAO = FactoryDAO.getComentariosDAO();
        estadosDAO = FactoryDAO.getEstadosDAO();
        postsDAO = FactoryDAO.getPostsDAO();
        usuariosDAO = FactoryDAO.getUsuariosDAO();
        municipioDAO = FactoryDAO.getMunicipioDAO();
    }

    @Override
    public Post registrarPostComun(Comun post) throws PersistenciaException {
        try {
            return postsDAO.registrarPostComun(post);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Post registrarPostAnclado(Anclado post) throws PersistenciaException {
        try {
            return postsDAO.editarPostAnclado(post);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Post editarPostComun(Comun post) throws PersistenciaException {
        try {
            return postsDAO.editarPostComun(post);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Post editarPostAnclado(Anclado post) throws PersistenciaException {
        try {
            return postsDAO.editarPostAnclado(post);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Post eliminarPost(Post post) throws PersistenceException {
        try {
            return postsDAO.eliminarPost(post);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Usuario registrarUsuarioNormal(Normal usuario) throws PersistenciaException {
        try {
            return usuariosDAO.registrarUsuarioNormal(usuario);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Usuario registrarUsuarioAdministrador(Administrador usuario) throws PersistenciaException {
        try {
            return usuariosDAO.registrarUsuarioAdministrador(usuario);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Usuario consultarUsuarioParaLogin(String correo, String password) throws PersistenciaException {
        try {
            return usuariosDAO.consultarUsuarioParaLogin(correo, password);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Usuario consultarUsuarioPorId(Long id) throws PersistenciaException {
        try {
            return usuariosDAO.consultarUsuarioPorId(id);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Estado registrarEstado(Estado estado) throws PersistenciaException {
        try {
            return estadosDAO.registrarEstado(estado);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Estado editarEstado(Estado estado) throws PersistenciaException {
        try {
            return estadosDAO.editarEstado(estado);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Comentario registarComentario(Comentario comentario) throws PersistenciaException {
        try {
            return comentariosDAO.registarComentario(comentario);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Comentario eliminarComentario(Comentario comentario) throws PersistenciaException {
        try {
            return comentariosDAO.eliminarComentario(comentario);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Municipio registrarMunicipio(Municipio municipio) throws PersistenciaException {
        try {
            return municipioDAO.registrarMunicipio(municipio);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Post consultarPostPorId(Long id) throws PersistenciaException {
        try {
            return postsDAO.consultarPostPorId(id);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public List<Anclado> consultarPostsAncladosPaginadoRecientes(int elementosPorPagina, int numeroPagina) throws PersistenciaException {
        try {
            return postsDAO.consultarPostsAncladosPaginadoRecientes(elementosPorPagina, numeroPagina);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public List<Comun> consultarPostsComunesPaginadoRecientes(int elementosPorPagina, int numeroPagina) throws PersistenciaException {
        try {
            return postsDAO.consultarPostsComunesPaginadoRecientes(elementosPorPagina, numeroPagina);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public List<Comun> consultarPostsComunesPorUsuarioPaginadoRecientes(Usuario usuario, int elementosPorPagina, int numeroPagina) throws PersistenciaException {
        try {
            return postsDAO.consultarPostsComunesPorUsuarioPaginadoRecientes(usuario, elementosPorPagina, numeroPagina);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public List<Anclado> consultarPostsAncladosPorUsuarioPaginadoRecientes(Usuario usuario, int elementosPorPagina, int numeroPagina) throws PersistenciaException {
        try {
            return postsDAO.consultarPostsAncladosPorUsuarioPaginadoRecientes(usuario, elementosPorPagina, numeroPagina);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public Comentario consultarComentarioPorId(Long id) throws PersistenciaException {
        try {
            return comentariosDAO.consultarComentarioPorId(id);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public List<Estado> consultaListaEstados() throws PersistenciaException {
        try {
            return estadosDAO.consultaListaEstados();
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public List<Municipio> consultaListaMunicipios() throws PersistenciaException {
        try {
            return municipioDAO.consultaListaMunicipios();
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public Municipio buscarMunicipioNombre(String nombre) throws PersistenceException {
        try {
            return municipioDAO.buscarMunicipioNombre(nombre);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public Anclado eliminarPostAnclado(Anclado anclado) throws PersistenceException {
        try {
            return postsDAO.eliminarPostAnclado(anclado);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public Comun eliminarPostComun(Comun comun) throws PersistenceException {
        try {
            return postsDAO.eliminarPostComun(comun);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public Post editarPost(Post post) throws PersistenciaException {
        try {
            return postsDAO.editarPost(post);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e);
        }
    }

    @Override
    public List<Post> buscadorPost(String busqueda) throws PersistenceException {
        try {
            return postsDAO.buscadorPost(busqueda);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e);
        }
    }

}
