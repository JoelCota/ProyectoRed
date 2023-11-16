/**
 * ComentarioBO.java
 * Jun 25, 2023 11:04:23 AM
 */
package org.itson.implementaciones;

import org.itson.excepciones.BOException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionException;
import org.itson.interfaces.IComentarioBO;
import org.itson.red.dominio.Administrador;
import org.itson.red.dominio.Anclado;
import org.itson.red.dominio.Comentario;
import org.itson.red.dominio.Post;
import org.itson.red.dominio.Usuario;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class ComentarioBO implements IComentarioBO {

    FachadaPersistencia persistencia;

    /**
     * Constructor por default
     */
    public ComentarioBO() {
        persistencia = new FachadaPersistencia();
    }

    @Override
    public Comentario registarComentario(Comentario comentario) throws BOException {

        try {

            if (comentario == null) {
                throw new ValidacionException("No hay información del comentario");
            }

            this.validarRegistrarComentario(comentario);

            return persistencia.registarComentario(comentario);

        } catch (ValidacionException | PersistenciaException e) {
            throw new BOException(e);
        }
    }

    private void validarRegistrarComentario(Comentario comentario) throws ValidacionException {

        String validacionesIncorrectas = "";

        if (comentario == null) {
            throw new ValidacionException("No hay información del comentario");
        }

        if (comentario.getUsuarioNormal() == null || comentario.getUsuarioNormal().getId() == null) {
            validacionesIncorrectas += "- No hay información del usuario\n";
        } else {
            try {

                Long idBuscarUsuario = comentario.getUsuarioNormal().getId();
                Usuario usuario = persistencia.consultarUsuarioPorId(idBuscarUsuario);

                //Validamos que el usuario exista
                if (usuario == null) {
                    throw new ValidacionException("No existe el usuario "
                            + "con el id: " + idBuscarUsuario);
                }
                //Validamos que el id del usuario no apunte a un administrador
                if (usuario instanceof Administrador) {
                    validacionesIncorrectas += "Un administrador no puede realizar "
                            + "comentarios";
                }
            } catch (ValidacionException e) {
                validacionesIncorrectas += e.getMessage();
            } catch (PersistenciaException a) {
                throw new ValidacionException(a);
            }

        }

        try {

            Long idPost;
            
            if(isRespuesta(comentario)){
                this.validarRespuesta(comentario);
                idPost = comentario.getComentario().getPostComun().getId();
            }else{
                idPost = comentario.getPostComun().getId();
            }
            
            

            Post post = persistencia.consultarPostPorId(idPost);

            //Validar que el post exista
            if (post == null) {
                throw new ValidacionException("El post que se quiere comentar, "
                        + "no existe");
            }

            //Validar que el comentario no apunte a un post anclado 
            if (post instanceof Anclado) {
                validacionesIncorrectas += "- Los post anclados no pueden "
                        + "ser comentados";
            }

        } catch (ValidacionException e) {
            validacionesIncorrectas += e.getMessage();
        } catch (PersistenciaException a) {
            throw new ValidacionException(a);
        }

        if (comentario.getContenido().trim().isBlank()) {
            validacionesIncorrectas += "El contenido no puede estar vacío";
        }

        if (!validacionesIncorrectas.trim().isBlank()) {
            throw new ValidacionException(validacionesIncorrectas);
        }

    }

    private void validarRespuesta(Comentario comentario) throws ValidacionException {

        if (comentario == null) {
            throw new ValidacionException("No hay información del comentario");
        }

        //Validar que el comentario que se responde existe
        Long idComentarioBuscar = comentario.getComentario().getId();
        try {
            Comentario comentarioBuscado = persistencia.consultarComentarioPorId(idComentarioBuscar);
            
            if(comentarioBuscado == null){
                throw new ValidacionException("El comentario a quien se responde "
                        + "no existe");
            }
        } catch (PersistenciaException | ValidacionException e) {
            throw new ValidacionException(e);
        }

    }

    private boolean isRespuesta(Comentario comentario) throws ValidacionException {

        if (comentario == null) {
            throw new ValidacionException("No hay información del comentario");
        }

        if (comentario.getComentario() != null) {
            return true;
        }

        return false;
    }

    @Override
    public Comentario eliminarComentario(Comentario comentario) throws BOException {
        try {

            if (comentario == null) {
                throw new ValidacionException("No hay información del id");
            }

            return persistencia.eliminarComentario(comentario);
        } catch (PersistenciaException | ValidacionException e) {
            throw new BOException(e);
        }
    }

    @Override
    public Comentario consultarComentarioPorId(Long id) throws BOException {

        try {

            if (id == null) {
                throw new ValidacionException("No hay información del id");
            }

            return persistencia.consultarComentarioPorId(id);
        } catch (PersistenciaException | ValidacionException e) {
            throw new BOException(e);
        }
    }
}
