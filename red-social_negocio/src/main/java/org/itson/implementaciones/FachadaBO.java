/**
 * FachadaBO.java
 * Jun 24, 2023 10:45:43 AM
 */
package org.itson.implementaciones;

import java.util.List;
import javax.persistence.PersistenceException;
import org.itson.excepciones.BOException;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IComentarioBO;
import org.itson.interfaces.IEstadosBO;
import org.itson.interfaces.IFachadaBO;
import org.itson.interfaces.IMunicipiosBO;
import org.itson.interfaces.IPostBO;
import org.itson.interfaces.IUsuarioBO;
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
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class FachadaBO implements IFachadaBO {

    IPostBO postsBO;
    IComentarioBO comentarioBO;
    IUsuarioBO usuarioBO;
    IEstadosBO estadosBO;
    IMunicipiosBO municipiosBO;

    /**
     * Constructor por default
     */
    public FachadaBO() {
        postsBO = BOFactory.getPostBOInstance();
        comentarioBO = BOFactory.getComentarioBOInstance();
        usuarioBO = BOFactory.getUsuarioBOInstance();
        estadosBO = BOFactory.getEstadosBOInstance();
        municipiosBO = BOFactory.getMunicipiosBOInstance();
    }

    @Override
    public Post consultarPostPorId(Long id) throws BOException {
        try {
            return postsBO.consultarPostPorId(id);
        } catch (PersistenciaException e) {
            throw new BOException(e);
        }
    }

    @Override
    public List<Anclado> consultarPostsAncladosPaginadoRecientes(int elementosPorPagina, int numeroPagina) throws BOException {
        try {
            return postsBO.consultarPostsAncladosPaginadoRecientes(elementosPorPagina, numeroPagina);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public List<Comun> consultarPostsComunesPaginadoRecientes(int elementosPorPagina, int numeroPagina) throws BOException {
        try {
            return postsBO.consultarPostsComunesPaginadoRecientes(elementosPorPagina, numeroPagina);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Comentario registarComentario(Comentario comentario) throws BOException {

        try {
            return comentarioBO.registarComentario(comentario);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Comentario eliminarComentario(Comentario comentario) throws BOException {
        try {
            return comentarioBO.eliminarComentario(comentario);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Usuario consultarUsuarioPorId(Long id) throws BOException {
        try {

            return usuarioBO.consultarUsuarioPorId(id);

        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Usuario registrarUsuarioNormal(Normal usuario) throws PersistenciaException {
        try {
            return usuarioBO.registrarUsuarioNormal(usuario);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Usuario registrarUsuarioAdministrador(Administrador usuario) throws PersistenciaException {
        try {
            return usuarioBO.registrarUsuarioAdministrador(usuario);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Usuario consultarUsuarioParaLogin(String correo, String password) throws PersistenciaException {
        try {
            return usuarioBO.consultarUsuarioParaLogin(correo, password);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Comentario consultarComentarioPorId(Long id) throws BOException {
        try {

            return comentarioBO.consultarComentarioPorId(id);

        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Post registrarPostComun(Comun post) throws BOException {
        try {
            return postsBO.registrarPostComun(post);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Post registrarPostAnclado(Anclado post) throws BOException {
        try {
            return postsBO.registrarPostAnclado(post);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public List<Estado> consultaListaEstados() throws PersistenciaException {
        try {
            return estadosBO.consultaListaEstados();
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public List<Municipio> consultaListaMunicipios() throws PersistenciaException {
        try {
            return municipiosBO.consultaListaMunicipios();
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Municipio buscarMunicipioNombre(String nombre) throws PersistenceException {
        try {
            return municipiosBO.buscarMunicipioNombre(nombre);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Post editarPostComun(Comun post) throws BOException {
        try {
            return this.postsBO.editarPostComun(post);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Post editarPostAnclado(Anclado post) throws BOException {
        try {
            return this.postsBO.editarPostAnclado(post);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Post eliminarPost(Post post) throws BOException {
        try {
            return this.postsBO.eliminarPost(post);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public List<Comun> consultarPostsComunesPorUsuarioPaginadoRecientes(Usuario usuario, int elementosPorPagina, int numeroPagina) throws PersistenciaException {
        try {
            return this.postsBO.consultarPostsComunesPorUsuarioPaginadoRecientes(usuario, elementosPorPagina, numeroPagina);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public List<Anclado> consultarPostsAncladosPorUsuarioPaginadoRecientes(Usuario usuario, int elementosPorPagina, int numeroPagina) throws PersistenciaException {
        try {
            return this.postsBO.consultarPostsAncladosPorUsuarioPaginadoRecientes(usuario, elementosPorPagina, numeroPagina);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Anclado eliminarPostAnclado(Anclado anclado) throws BOException {
        try {
            return this.postsBO.eliminarPostAnclado(anclado);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Comun eliminarPostComun(Comun comun) throws BOException {
        try {
            return this.postsBO.eliminarPostComun(comun);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Post editarPost(Post post) throws BOException {
        try {
            return this.postsBO.editarPost(post);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }

    @Override
    public List<Post> buscadorPost(String busqueda) throws PersistenceException {
        try {
            return this.postsBO.buscadorPost(busqueda);
        } catch (BOException e) {
            throw new BOException(e);
        }
    }
}
