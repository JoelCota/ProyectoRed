/**
 * Anclado.java
 * 10 jun. 2023 13:11:25
 */
package org.itson.red.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
@Entity
@DiscriminatorValue(value = "anclado")
public class Anclado extends Post implements Serializable {

    /**
     * Administrador que realizó el post anclado
     */
    @ManyToOne()
    @JoinColumn(name = "idAdministrador")
    private Administrador administrador;

    /**
     * Constructor por default
     */
    public Anclado() {

    }

    /**
     * Constructor para crear un post nuevo con id, fecha de creación, contenido
     * y título
     *
     * @param administrador Administrador que realizó el post anclado
     * @param id Id del post
     * @param fechaCreacion Fecha en la que se creó el post
     * @param contenido Contenido del post
     * @param titulo Titulo del post
     */
    public Anclado(Administrador administrador, Long id, Calendar fechaCreacion, String contenido, String titulo) {
        super(id, fechaCreacion, contenido, titulo);
        this.administrador = administrador;
    }

    /**
     * Constructor para modificar un post antiguo con id, fecha de creación,
     * contenido, título y fecha en la que se modificó el post
     *
     * @param administrador Administrador que realizó el post anclado
     * @param id Id del post
     * @param fechaCreacion Fecha en la que se creó el post
     * @param contenido Contenido del post
     * @param titulo Titulo del post
     * @param fechaEdicion Fecha en la que se modificó el post
     */
    public Anclado(Administrador administrador, Long id, Calendar fechaCreacion, String contenido, String titulo, Calendar fechaEdicion) {
        super(id, fechaCreacion, contenido, titulo, fechaEdicion);
        this.administrador = administrador;
    }

    /**
     * Constructor para modificar un post antiguo con fecha de creación,
     * contenido, título y fecha en la que se modificó el post
     *
     * @param administrador Administrador que realizó el post anclado
     * @param fechaCreacion Fecha en la que se creó el post
     * @param contenido Contenido del post
     * @param titulo Titulo del post
     * @param fechaEdicion Fecha en la que se modificó el post
     */
    public Anclado(Administrador administrador, Calendar fechaCreacion, String contenido, String titulo, Calendar fechaEdicion) {
        super(fechaCreacion, contenido, titulo, fechaEdicion);
        this.administrador = administrador;
    }

    /**
     * Constructor para crear un post nuevo con fecha de creación, contenido y
     * título
     *
     * @param administrador Administrador que realizó el post anclado
     * @param fechaCreacion Fecha en la que se creó el post
     * @param contenido Contenido del post
     * @param titulo Titulo del post
     */
    public Anclado(Administrador administrador, Calendar fechaCreacion, String contenido, String titulo) {
        super(fechaCreacion, contenido, titulo);
        this.administrador = administrador;
    }

    /**
     * Obtiene el administrador que realizó el post anclado
     *
     * @return Administrador que realizó el post anclado
     */
    public Administrador getAdministrador() {
        return administrador;
    }

    /**
     * Establece el administrador que realizó el post anclado
     *
     * @param administrador Administrador que realizó el post anclado
     */
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

}
