/**
 * Normal.java
 * 9 jun. 2023 23:08:14
 */
package org.itson.red.dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
@Entity
public class Normal extends Usuario implements Serializable {

    /**
     * Lista de comentarios que ha realizado el usuario
     */
    @OneToMany(mappedBy = "usuarioNormal")
    private List<Comentario> comentarios;

    /**
     * Constructor por default
     */
    public Normal() {
        super();
    }

    /**
     * Constructor con el que puedes crear un usuario, con su id, nombres,
     * apellido paterno, apellido materno, su género, fecha de nacimiento,
     * teléfono, ciudad, correo y contraseña
     *
     * @param id Id del usuario
     * @param nombres Nombres del usuario
     * @param apellidos Apellido paterno y materno del usuario
     * @param imagenUsuario Imagen del usuario en bytes
     * @param genero Género del usuario (Masculino o Femenino)
     * @param fechaNacimiento Fecha de nacimiento del usuario
     * @param telefono Teléfono del usuario
     * @param ciudad Ciudad dónde vive el usuario
     * @param correo Correo del usuario
     * @param contrasena Contraseña del usuario
     * @param municipio Municipio en el que se encuentra el usuario
     */
    public Normal(Long id, String nombres, String apellidos, byte[] imagenUsuario, Genero genero, Calendar fechaNacimiento, String telefono, String ciudad, String correo, String contrasena, Municipio municipio) {
        super(id, nombres, apellidos, imagenUsuario, genero, fechaNacimiento, telefono, ciudad, correo, contrasena, municipio);
    }

    /**
     * Constructor con el que puedes crear un usuario, con su id, nombres,
     * apellido paterno, apellido materno, su género, fecha de nacimiento,
     * teléfono, ciudad, correo y contraseña
     *
     * @param nombres Nombres del usuario
     * @param apellidos Apellido paterno y materno del usuario
     * @param imagenUsuario Imagen del usuario en bytes
     * @param genero Género del usuario (Masculino o Femenino)
     * @param fechaNacimiento Fecha de nacimiento del usuario
     * @param telefono Teléfono del usuario
     * @param ciudad Ciudad dónde vive el usuario
     * @param correo Correo del usuario
     * @param contrasena Contraseña del usuario
     * @param municipio Municipio donde se encuentra el usuario
     */
    public Normal(String nombres, String apellidos, byte[] imagenUsuario, Genero genero, Calendar fechaNacimiento, String telefono, String ciudad, String correo, String contrasena, Municipio municipio) {
        super(nombres, apellidos, imagenUsuario, genero, fechaNacimiento, telefono, ciudad, correo, contrasena, municipio);
    }

    /**
     * Constructor con el que puedes crear un usuario, con su lista de
     * comentarios, id, nombres, apellido paterno, apellido materno, su género,
     * fecha de nacimiento, teléfono, ciudad, correo y contraseña
     *
     * @param comentarios Lista de comentarios que ha realizado el usuario
     * @param id Id del usuario
     * @param nombres Nombres del usuario
     * @param apellidos Apellido paterno y materno del usuario
     * @param imagenUsuario Imagen del usuario en bytes
     * @param genero Género del usuario (Masculino o Femenino)
     * @param fechaNacimiento Fecha de nacimiento del usuario
     * @param telefono Teléfono del usuario
     * @param ciudad Ciudad dónde vive el usuario
     * @param correo Correo del usuario
     * @param contrasena Contraseña del usuario
     * @param municipio Municipio en el que se encuentra el usuario
     */
    public Normal(List<Comentario> comentarios, Long id, String nombres, String apellidos, byte[] imagenUsuario, Genero genero, Calendar fechaNacimiento, String telefono, String ciudad, String correo, String contrasena, Municipio municipio) {
        super(id, nombres, apellidos, imagenUsuario, genero, fechaNacimiento, telefono, ciudad, correo, contrasena, municipio);
        this.comentarios = comentarios;
    }

    /**
     * Constructor con el que puedes crear un usuario, con su lista de
     * comentarios, nombres, apellido paterno, apellido materno, su género,
     * fecha de nacimiento, teléfono, ciudad, correo y contraseña
     *
     * @param comentarios Lista de comentarios que ha realizado el usuario
     * @param nombres Nombres del usuario
     * @param apellidos Apellido paterno y materno del usuario
     * @param imagenUsuario Imagen del usuario en bytes
     * @param genero Género del usuario (Masculino o Femenino)
     * @param fechaNacimiento Fecha de nacimiento del usuario
     * @param telefono Teléfono del usuario
     * @param ciudad Ciudad dónde vive el usuario
     * @param correo Correo del usuario
     * @param contrasena Contraseña del usuario
     * @param municipio Municipio donde se encuentra el usuario
     */
    public Normal(List<Comentario> comentarios, String nombres, String apellidos, byte[] imagenUsuario, Genero genero, Calendar fechaNacimiento, String telefono, String ciudad, String correo, String contrasena, Municipio municipio) {
        super(nombres, apellidos, imagenUsuario, genero, fechaNacimiento, telefono, ciudad, correo, contrasena, municipio);
        this.comentarios = comentarios;
    }

    /**
     * Obtiene la lista de comentarios realizados por el usuario normal
     *
     * @return Lista de comentarios que realizó el usuario normal
     */
    public List<Comentario> getComentarios() {
        return comentarios;
    }

    /**
     * Establece los comentarios realizados por el usuario normal
     *
     * @param comentarios Lista de comentarios que realizó el usuario normal
     */
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * Agrega un comentario a la lista de comentarios realizados por el usuario
     * normal
     *
     * @param comentario Comentario realizado por el usuario normal
     * @return Lista de los comentarios realizados por el usuario normal
     */
    public List<Comentario> agregarComentario(Comentario comentario) {
        if (this.comentarios == null) {
            this.comentarios = new LinkedList<>();
        }
        this.comentarios.add(comentario);
        return this.comentarios;
    }
    
    /**
     * Elimina un comentario a la lista de comentarios realizados por el usuario
     * normal
     *
     * @param comentario Comentario realizado por el usuario normal
     * @return Lista de los comentarios realizados por el usuario normal
     */
    public List<Comentario> eliminarComentario(Comentario comentario) {
        if (this.comentarios == null || this.comentarios.isEmpty()) {
            return this.comentarios;
        }
        this.comentarios.remove(comentario);
        return this.comentarios;
    }

}
