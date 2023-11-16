/**
 * Comun.java
 * 10 jun. 2023 12:44:04
 */
package org.itson.red.dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
@Entity
@DiscriminatorValue(value = "comun")
public class Comun extends Post implements Serializable {

    /**
     * Lista de comentarios que tiene el post
     */
    @OneToMany(mappedBy = "postComun", cascade = CascadeType.REMOVE)
    private List<Comentario> comentarios;

    /**
     * Usuario quien realizó el post
     */
    @ManyToOne()
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    /**
     * Constructor por default
     */
    public Comun() {

    }

    /**
     * Constructor para crear un post nuevo con id, fecha de creación, contenido
     * y título
     *
     * @param comentarios Lista de comentarios que recibió el post común
     * @param usuario Usuario que realizó el post común
     * @param id Id del post
     * @param fechaCreacion Fecha en la que se creó el post
     * @param contenido Contenido del post
     * @param titulo Titulo del post
     */
    public Comun(List<Comentario> comentarios, Usuario usuario, Long id, Calendar fechaCreacion, String contenido, String titulo) {
        super(id, fechaCreacion, contenido, titulo);
        this.comentarios = comentarios;
        this.usuario = usuario;
    }

    /**
     * Constructor para modificar un post antiguo con id, fecha de creación,
     * contenido, título y fecha en la que se modificó el post
     *
     * @param comentarios Lista de comentarios que recibió el post común
     * @param usuario Usuario que realizó el post común
     * @param id Id del post
     * @param fechaCreacion Fecha en la que se creó el post
     * @param contenido Contenido del post
     * @param titulo Titulo del post
     * @param fechaEdicion Fecha en la que se modificó el post
     */
    public Comun(List<Comentario> comentarios, Usuario usuario, Long id, Calendar fechaCreacion, String contenido, String titulo, Calendar fechaEdicion) {
        super(id, fechaCreacion, contenido, titulo, fechaEdicion);
        this.comentarios = comentarios;
        this.usuario = usuario;
    }

    /**
     * Constructor para modificar un post antiguo con fecha de creación,
     * contenido, título y fecha en la que se modificó el post
     *
     * @param comentarios Lista de comentarios que recibió el post común
     * @param usuario Usuario que realizó el post común
     * @param fechaCreacion Fecha en la que se creó el post
     * @param contenido Contenido del post
     * @param titulo Titulo del post
     * @param fechaEdicion Fecha en la que se modificó el post
     */
    public Comun(List<Comentario> comentarios, Usuario usuario, Calendar fechaCreacion, String contenido, String titulo, Calendar fechaEdicion) {
        super(fechaCreacion, contenido, titulo, fechaEdicion);
        this.comentarios = comentarios;
        this.usuario = usuario;
    }

    /**
     * Constructor para crear un post nuevo con fecha de creación, contenido y
     * título
     *
     * @param comentarios Lista de comentarios que recibió el post común
     * @param usuario Usuario que realizó el post común
     * @param fechaCreacion Fecha en la que se creó el post
     * @param contenido Contenido del post
     * @param titulo Titulo del post
     */
    public Comun(List<Comentario> comentarios, Usuario usuario, Calendar fechaCreacion, String contenido, String titulo) {
        super(fechaCreacion, contenido, titulo);
        this.comentarios = comentarios;
        this.usuario = usuario;
    }

    /**
     * Constructor para crear un post nuevo con id, fecha de creación, contenido
     * y título
     *
     * @param usuario Usuario que realizó el post común
     * @param id Id del post
     * @param fechaCreacion Fecha en la que se creó el post
     * @param contenido Contenido del post
     * @param titulo Titulo del post
     */
    public Comun(Usuario usuario, Long id, Calendar fechaCreacion, String contenido, String titulo) {
        super(id, fechaCreacion, contenido, titulo);
        this.usuario = usuario;
    }

    /**
     * Constructor para modificar un post antiguo con id, fecha de creación,
     * contenido, título y fecha en la que se modificó el post
     *
     * @param usuario Usuario que realizó el post común
     * @param id Id del post
     * @param fechaCreacion Fecha en la que se creó el post
     * @param contenido Contenido del post
     * @param titulo Titulo del post
     * @param fechaEdicion Fecha en la que se modificó el post
     */
    public Comun(Usuario usuario, Long id, Calendar fechaCreacion, String contenido, String titulo, Calendar fechaEdicion) {
        super(id, fechaCreacion, contenido, titulo, fechaEdicion);
        this.usuario = usuario;
    }

    /**
     * Constructor para modificar un post antiguo con fecha de creación,
     * contenido, título y fecha en la que se modificó el post
     *
     * @param usuario Usuario que realizó el post común
     * @param fechaCreacion Fecha en la que se creó el post
     * @param contenido Contenido del post
     * @param titulo Titulo del post
     * @param fechaEdicion Fecha en la que se modificó el post
     */
    public Comun(Usuario usuario, Calendar fechaCreacion, String contenido, String titulo, Calendar fechaEdicion) {
        super(fechaCreacion, contenido, titulo, fechaEdicion);
        this.usuario = usuario;
    }

    /**
     * Constructor para crear un post nuevo con fecha de creación, contenido y
     * título
     *
     * @param usuario Usuario que realizó el post común
     * @param fechaCreacion Fecha en la que se creó el post
     * @param contenido Contenido del post
     * @param titulo Titulo del post
     */
    public Comun(Usuario usuario, Calendar fechaCreacion, String contenido, String titulo) {
        super(fechaCreacion, contenido, titulo);
        this.usuario = usuario;
    }

    /**
     * Obtiene la lista de comentarios que se realizó en este post
     *
     * @return Lista de comentarios que se realizó en este post
     */
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    /**
     * Establece la lista de comentarios que se realizaron en este post
     *
     * @param comentarios Lista de comentarios que se realizaron a este post
     */
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * Agrega comentario a la lista de comentarios que se realizaron a este post
     *
     * @param comentario Comentario que se realizó al post
     * @return Lista de comentarios que se realizaron al post
     */
    public List<Comentario> agregarComentario(Comentario comentario) {
        if (this.comentarios == null) {
            this.comentarios = new LinkedList<>();
        }
        this.comentarios.add(comentario);
        return this.comentarios;
    }

    /**
     * Elimina comentario de la lista de comentarios que se realizaron a este
     * post
     *
     * @param comentario Comentario que se eliminó del post
     * @return Lista de comentarios que se realizaron al post
     */
    public List<Comentario> eliminarComentario(Comentario comentario) {
        if (this.comentarios == null || this.comentarios.isEmpty()) {
            return this.comentarios;
        }
        this.comentarios.remove(comentario);
        return this.comentarios;
    }

    /**
     * Obtiene el usuario que realizó el post
     *
     * @return Usuario que realizó el post
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario que realizó el post
     *
     * @param usuario Usuario que realizó el post
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
