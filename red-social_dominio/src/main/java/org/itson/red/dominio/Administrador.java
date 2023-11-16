/**
 * Administrador.java
 * 9 jun. 2023 23:05:53
 */
package org.itson.red.dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
@Entity
@DiscriminatorValue(value = "administrador")
public class Administrador extends Usuario implements Serializable {

    /**
     * Lista de post anclados por el administrador
     */
    @OneToMany(mappedBy = "administrador")
    private List<Anclado> listaPostAnclados;

    /**
     * Constructor por default
     */
    public Administrador() {

    }

    /**
     * Constructor con el que puedes crear un usuario, con su id, nombres,
     * apellido paterno, apellido materno, su género, fecha de nacimiento,
     * teléfono, ciudad, correo, contraseña y sus post comunes que realizó el
     * usuario
     *
     * @param listaPostAnclados Lista de post anclados del administrador
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
     * @param listaPostComun Lista de post comunes que realizó el usuario
     */
    public Administrador(List<Anclado> listaPostAnclados, Long id, String nombres, String apellidos, byte[] imagenUsuario, Genero genero, Calendar fechaNacimiento, String telefono, String ciudad, String correo, String contrasena, Municipio municipio, List<Comun> listaPostComun) {
        super(id, nombres, apellidos, imagenUsuario, genero, fechaNacimiento, telefono, ciudad, correo, contrasena, municipio, listaPostComun);
        this.listaPostAnclados = listaPostAnclados;
    }

    /**
     * Constructor con el que puedes crear un usuario, con sus nombres, apellido
     * paterno, apellido materno, su género, fecha de nacimiento, teléfono,
     * ciudad, correo, contraseña y sus post comunes que realizó el usuario
     *
     * @param listaPostAnclados Lista de post anclados del administrador
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
     * @param listaPostComun Lista de post comunes que realizó el usuario
     */
    public Administrador(List<Anclado> listaPostAnclados, String nombres, String apellidos, byte[] imagenUsuario, Genero genero, Calendar fechaNacimiento, String telefono, String ciudad, String correo, String contrasena, Municipio municipio, List<Comun> listaPostComun) {
        super(nombres, apellidos, imagenUsuario, genero, fechaNacimiento, telefono, ciudad, correo, contrasena, municipio, listaPostComun);
        this.listaPostAnclados = listaPostAnclados;
    }

    /**
     * Constructor con el que puedes crear un usuario, con su id, nombres,
     * apellido paterno, apellido materno, su género, fecha de nacimiento,
     * teléfono, ciudad, correo y contraseña
     *
     * @param listaPostAnclados Lista de post anclados del administrador
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
    public Administrador(List<Anclado> listaPostAnclados, Long id, String nombres, String apellidos, byte[] imagenUsuario, Genero genero, Calendar fechaNacimiento, String telefono, String ciudad, String correo, String contrasena, Municipio municipio) {
        super(id, nombres, apellidos, imagenUsuario, genero, fechaNacimiento, telefono, ciudad, correo, contrasena, municipio);
        this.listaPostAnclados = listaPostAnclados;
    }

    /**
     * Constructor con el que puedes crear un usuario, con su id, nombres,
     * apellido paterno, apellido materno, su género, fecha de nacimiento,
     * teléfono, ciudad, correo y contraseña
     *
     * @param listaPostAnclados Lista de post anclados del administrador
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
    public Administrador(List<Anclado> listaPostAnclados, String nombres, String apellidos, byte[] imagenUsuario, Genero genero, Calendar fechaNacimiento, String telefono, String ciudad, String correo, String contrasena, Municipio municipio) {
        super(nombres, apellidos, imagenUsuario, genero, fechaNacimiento, telefono, ciudad, correo, contrasena, municipio);
        this.listaPostAnclados = listaPostAnclados;
    }

    /**
     * Constructor con el que puedes crear un usuario, con su id, nombres,
     * apellido paterno, apellido materno, su género, fecha de nacimiento,
     * teléfono, ciudad, correo, contraseña y sus post comunes que realizó el
     * usuario
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
     * @param listaPostComun Lista de post comunes que realizó el usuario
     */
    public Administrador(Long id, String nombres, String apellidos, byte[] imagenUsuario, Genero genero, Calendar fechaNacimiento, String telefono, String ciudad, String correo, String contrasena, Municipio municipio, List<Comun> listaPostComun) {
        super(id, nombres, apellidos, imagenUsuario, genero, fechaNacimiento, telefono, ciudad, correo, contrasena, municipio, listaPostComun);
    }

    /**
     * Constructor con el que puedes crear un usuario, con sus nombres, apellido
     * paterno, apellido materno, su género, fecha de nacimiento, teléfono,
     * ciudad, correo, contraseña y sus post comunes que realizó el usuario
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
     * @param municipio Municipio en el que se encuentra el usuario
     * @param listaPostComun Lista de post comunes que realizó el usuario
     */
    public Administrador(String nombres, String apellidos, byte[] imagenUsuario, Genero genero, Calendar fechaNacimiento, String telefono, String ciudad, String correo, String contrasena, Municipio municipio, List<Comun> listaPostComun) {
        super(nombres, apellidos, imagenUsuario, genero, fechaNacimiento, telefono, ciudad, correo, contrasena, municipio, listaPostComun);
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
    public Administrador(Long id, String nombres, String apellidos, byte[] imagenUsuario, Genero genero, Calendar fechaNacimiento, String telefono, String ciudad, String correo, String contrasena, Municipio municipio) {
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
    public Administrador(String nombres, String apellidos, byte[] imagenUsuario, Genero genero, Calendar fechaNacimiento, String telefono, String ciudad, String correo, String contrasena, Municipio municipio) {
        super(nombres, apellidos, imagenUsuario, genero, fechaNacimiento, telefono, ciudad, correo, contrasena, municipio);
    }
    
    /**
     * Obtiene la lista de post anclados que el administrador tenga
     *
     * @return Lista de post anclados que el administrador tenga
     */
    public List<Anclado> getListaPostAnclados() {
        return listaPostAnclados;
    }

    /**
     * Establece la lista de post anclados que el administrador tenga
     *
     * @param listaPostAnclados Lista de post anclados que el administrador
     * tenga
     */
    public void setListaPostAnclados(List<Anclado> listaPostAnclados) {
        this.listaPostAnclados = listaPostAnclados;
    }

    /**
     * Agrega un post anclado a la lista de post anclados que el administrador
     * tenga
     *
     * @param postAnclado Post anclado que se desea agregar a la lista de post
     * anclados que el administrador tenga
     * @return Lista de post anclados que el administrador tenga
     */
    public List<Anclado> agregarPostAnclados(Anclado postAnclado) {
        if (this.listaPostAnclados == null) {
            this.listaPostAnclados = new LinkedList<>();
        }
        this.listaPostAnclados.add(postAnclado);
        return this.listaPostAnclados;
    }

    /**
     * Elimina un post anclado a la lista de post anclados que el administrador
     * tenga
     *
     * @param postAnclado Post anclado que se desea eliminar de la lista de post
     * anclados que el administrador tiene
     * @return Lista de post anclados que el administrador tenga
     */
    public List<Anclado> eliminarPostAnclados(Anclado postAnclado) {
        if (this.listaPostAnclados == null || this.listaPostAnclados.isEmpty()) {
            return this.listaPostAnclados;
        }
        this.listaPostAnclados.remove(postAnclado);
        return this.listaPostAnclados;
    }
}
