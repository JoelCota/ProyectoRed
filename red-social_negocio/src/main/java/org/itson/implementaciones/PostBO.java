/**
 * PostBO.java
 * Jun 24, 2023 10:15:20 AM
 */
package org.itson.implementaciones;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;
import org.itson.excepciones.BOException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionException;
import org.itson.interfaces.IPostBO;
import org.itson.red.dominio.Administrador;
import org.itson.red.dominio.Anclado;
import org.itson.red.dominio.Comun;
import org.itson.red.dominio.Post;
import org.itson.red.dominio.Usuario;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class PostBO implements IPostBO {

    FachadaPersistencia persistencia;

    /**
     * Constructor por default
     */
    public PostBO() {
        persistencia = new FachadaPersistencia();
    }

    @Override
    public Post consultarPostPorId(Long id) throws BOException {

        try {
            this.validacionConsultarPostPorId(id);
            return persistencia.consultarPostPorId(id);
        } catch (ValidacionException | PersistenciaException e) {
            throw new BOException("Ocurrió un error al buscar el post"
                    + "por su id: ", e);
        }

    }

    private void validacionConsultarPostPorId(Long id) throws ValidacionException {

        String validacionesIncorrectas = "";

        if (id == null || id < 0) {
            validacionesIncorrectas += "- Id Inválido\n";
        }

        if (!validacionesIncorrectas.trim().isBlank()) {
            throw new ValidacionException("Válidaciones no aprobadas:\n"
                    + validacionesIncorrectas);
        }

    }

    @Override
    public List<Anclado> consultarPostsAncladosPaginadoRecientes(int elementosPorPagina, int numeroPagina) throws BOException {
        try {

            this.validarConsultarPostPaginadoRecientes(elementosPorPagina, numeroPagina);

            return persistencia.consultarPostsAncladosPaginadoRecientes(elementosPorPagina, numeroPagina);

        } catch (ValidacionException | PersistenciaException e) {
            throw new BOException("Ocurrió un error al buscar post "
                    + "anclados por páginado", e);
        }
    }

    @Override
    public List<Comun> consultarPostsComunesPaginadoRecientes(int elementosPorPagina, int numeroPagina) throws BOException {
        try {

            this.validarConsultarPostPaginadoRecientes(elementosPorPagina, numeroPagina);

            return persistencia.consultarPostsComunesPaginadoRecientes(elementosPorPagina, numeroPagina);

        } catch (ValidacionException | PersistenciaException e) {
            throw new BOException("Ocurrió un error al buscar post "
                    + "comunes por páginado", e);
        }
    }

    private void validarConsultarPostPaginadoRecientes(int elementosPorPagina, int numeroPagina) throws ValidacionException {

        String validacionesIncorrectas = "";

        if (numeroPagina <= 0) {
            validacionesIncorrectas += "- La página debe ser mayor a 0";
        }

        if (elementosPorPagina <= 0) {
            validacionesIncorrectas += "- La cantidad de elementos no puede ser menor a 0";
        }

        if (!validacionesIncorrectas.trim().isBlank()) {
            throw new ValidacionException("Válidaciones no aprobadas:\n"
                    + validacionesIncorrectas);
        }
    }

    @Override
    public Post registrarPostComun(Comun post) throws ValidacionException {
        try {
            this.validarRegistroPostComun(post);
            return this.persistencia.registrarPostComun(post);
        } catch (ValidacionException | PersistenceException e) {
            throw new ValidacionException(e);
        }
    }

    private void validarRegistroPostComun(Comun post) throws ValidacionException {

        String validacionesIncorrectas = "";

        if (post == null) {
            //No hay datos del post
            throw new ValidacionException("No hay información del post.");
        }

        //Validar el título del post
        String tituloPost = post.getTitulo();

        if (tituloPost == null || tituloPost.trim().isBlank()) {
            //No hay datos del titulo
            validacionesIncorrectas += "- No hay ningún título.\n";
        }

        //Validar el contenido del post
        String contenidoPost = post.getContenido();

        if (contenidoPost == null || contenidoPost.trim().isBlank()) {
            validacionesIncorrectas += "- No hay ningún contenido.\n";
        }

        //Validamos el usuario que creó el post
        Usuario usuarioPost = post.getUsuario();

        if (usuarioPost == null) {
            //No hay usuario que indique que creó el post
            validacionesIncorrectas += "- No hay información del usuario.\n";
        }

        if (usuarioPost != null) {
            //Validar si el usuario existe
            //Consultar en la BD para encontrar al usuario y validar que exista
            Usuario usuarioConsultado = persistencia.consultarUsuarioPorId(usuarioPost.getId());

            if (usuarioConsultado == null) {
                //No hay usuario en la BD
                validacionesIncorrectas += "- El usuario que creó el post, "
                        + "no existe.\n";
            }
        }

        if (!validacionesIncorrectas.trim().isBlank()) {
            //La cadena de validaciones es diferente de estar vacío
            throw new ValidacionException(validacionesIncorrectas);
        }
    }

    @Override
    public Post registrarPostAnclado(Anclado post) throws ValidacionException {
        try {
            this.validarRegistroPostAnclado(post);
            return persistencia.registrarPostAnclado(post);
        } catch (ValidacionException | PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    private void validarRegistroPostAnclado(Anclado post) throws ValidacionException {

        String validacionesIncorrectas = "";

        if (post == null) {
            throw new ValidacionException("No hay información del post.");
        }

        //Validar el título del post
        String tituloPost = post.getTitulo();

        if (tituloPost == null || tituloPost.trim().isBlank()) {
            //No hay datos del titulo
            validacionesIncorrectas += "- No hay ningún título.\n";
        }

        //Validar el contenido del post
        String contenidoPost = post.getContenido();

        if (contenidoPost == null || contenidoPost.trim().isBlank()) {
            validacionesIncorrectas += "- No hay ningún contenido.\n";
        }

        Administrador administradorPost = post.getAdministrador();

        if (administradorPost == null) {
            validacionesIncorrectas += "- No hay información del usuario que "
                    + "creó el post";
        }

        if (administradorPost != null) {
            //Validamos que exista en la base de datos
            Usuario usuarioConsultado = persistencia.consultarUsuarioPorId(administradorPost.getId());

            if (usuarioConsultado == null) {
                //No se encontró ningún usuario en la base de datos
                validacionesIncorrectas += "- El usuario que creó el post, "
                        + "no existe";
            }

            if (usuarioConsultado != null && !(usuarioConsultado instanceof Administrador)) {
                //El usuario que consultó, no es adminnistrador
                validacionesIncorrectas += "- Solo un administrador puede "
                        + "generar post anclados";
            }
        }

        if (!validacionesIncorrectas.trim().isBlank()) {
            //Si hay errores agregados a la variable "validaciones incorrectas"
            throw new ValidacionException(validacionesIncorrectas);
        }

    }

    @Override
    public Post editarPostComun(Comun post) throws BOException {
        try {
            this.validarRegistroPostComun(post);

            return this.persistencia.editarPostComun(post);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage());
        }
    }

    @Override
    public Post editarPostAnclado(Anclado post) throws BOException {
        try {
            this.validarRegistroPostAnclado(post);

            return this.persistencia.editarPostAnclado(post);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage());
        }
    }

    @Override
    public Post eliminarPost(Post post) throws BOException {
        try {
            return this.persistencia.eliminarPost(post);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage());
        }
    }

    @Override
    public List<Comun> consultarPostsComunesPorUsuarioPaginadoRecientes(Usuario usuario, int elementosPorPagina, int numeroPagina) throws PersistenciaException {
        try {
            return this.persistencia.consultarPostsComunesPorUsuarioPaginadoRecientes(usuario, elementosPorPagina, numeroPagina);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage());
        }
    }

    @Override
    public List<Anclado> consultarPostsAncladosPorUsuarioPaginadoRecientes(Usuario usuario, int elementosPorPagina, int numeroPagina) throws PersistenciaException {
        try {
            return this.persistencia.consultarPostsAncladosPorUsuarioPaginadoRecientes(usuario, elementosPorPagina, numeroPagina);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage());
        }
    }

    @Override
    public Anclado eliminarPostAnclado(Anclado anclado) throws BOException {
        try {
            return this.persistencia.eliminarPostAnclado(anclado);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage());
        }
    }

    @Override
    public Comun eliminarPostComun(Comun comun) throws BOException {
        try {
            return this.persistencia.eliminarPostComun(comun);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage());
        }
    }

    @Override
    public Post editarPost(Post post) throws BOException {
        try {
            post.setFechaEdicion(Calendar.getInstance());
            return this.persistencia.editarPost(post);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage());
        }
    }

    private GregorianCalendar obtenerFechaYHora() {
        return new GregorianCalendar();
    }

    @Override
    public List<Post> buscadorPost(String busqueda) throws PersistenceException {
        try {
            return this.persistencia.buscadorPost(busqueda);
        } catch (PersistenciaException e) {
            throw new BOException(e.getMessage());
        }
    }
}
