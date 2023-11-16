/**
 * Usuario.java
 * 9 jun. 2023 21:51:26
 */
package org.itson.red.dominio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
@Entity
@Table(name = "usuarios")
@DiscriminatorColumn(name = "tipoUsuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Usuario implements Serializable {

    /**
     * Id del usuario
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombres del usuario
     */
    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 50 )
    private String apellidos;

    @Lob
    @Column(name = "imagenUsuario")
    private byte[] imagenUsuario;

    /**
     * Género del usuario, puede ser Masculino o Femenino
     */
    @Column(name = "genero", nullable = false)
    @Enumerated(EnumType.STRING)
    private Genero genero;

    /**
     * Fecha de nacimiento del usuario
     */
    @Column(name = "fechaNacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;

    /**
     * Teléfono del usuario
     */
    @Column(name = "telefono" , nullable = false, length = 12)
    private String telefono;

    /**
     * Ciudad dónde vive el usuario
     */
    @Column(name = "ciudad", nullable = false, length = 25)
    private String ciudad;

    /**
     * Correo del usuario
     */
    @Column(name = "correo", nullable = false, length = 50)
    private String correo;

    /**
     * Contraseña del usuario
     */
    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    /**
     * Municipio en el que se encuentra el usuario
     */
    @ManyToOne()
    @JoinColumn(name = "idMunicipio" , nullable = false)
    private Municipio municipio;

    /**
     * Lista de post hechos por el usuario
     */
    @OneToMany(mappedBy = "usuario")
    private List<Comun> listaPostComunes;

    /**
     * Constructor por default
     */
    public Usuario() {
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
    public Usuario(Long id, String nombres, String apellidos, byte[] imagenUsuario, Genero genero, Calendar fechaNacimiento, String telefono, String ciudad, String correo, String contrasena, Municipio municipio, List<Comun> listaPostComun) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.imagenUsuario = imagenUsuario;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.correo = correo;
        this.contrasena = contrasena;
        this.municipio = municipio;
        this.listaPostComunes = listaPostComun;
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
    public Usuario(String nombres, String apellidos, byte[] imagenUsuario, Genero genero, Calendar fechaNacimiento, String telefono, String ciudad, String correo, String contrasena, Municipio municipio, List<Comun> listaPostComun) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.imagenUsuario = imagenUsuario;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.correo = correo;
        this.contrasena = contrasena;
        this.municipio = municipio;
        this.listaPostComunes = listaPostComun;
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
    public Usuario(Long id, String nombres, String apellidos, byte[] imagenUsuario, Genero genero, Calendar fechaNacimiento, String telefono, String ciudad, String correo, String contrasena, Municipio municipio) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.imagenUsuario = imagenUsuario;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.correo = correo;
        this.contrasena = contrasena;
        this.municipio = municipio;
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
    public Usuario(String nombres, String apellidos, byte[] imagenUsuario, Genero genero, Calendar fechaNacimiento, String telefono, String ciudad, String correo, String contrasena, Municipio municipio) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.imagenUsuario = imagenUsuario;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.correo = correo;
        this.contrasena = contrasena;
        this.municipio = municipio;
    }

    /**
     * Obtiene el id del usuario
     *
     * @return Id del usuario
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el id del usuario
     *
     * @param id Id del usuario
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene nombres del usuario
     *
     * @return Nombres del usuario
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece nombres del usuario
     *
     * @param nombres Nombres del usuario
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene los apellidos del usuario
     *
     * @return Apellidos del usuario
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del usuario
     *
     * @param apellidos Apellidos del usuario
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene la imagen en bytes del usuario
     *
     * @return Obtiene la imgagen del usuario en bytes
     */
    public byte[] getImagenUsuario() {
        return imagenUsuario;
    }

    /**
     * Establece la imagen del usuario en bytes
     *
     * @param imagenUsuario Imagen del usuario en bytes
     */
    public void setImagenUsuario(byte[] imagenUsuario) {
        this.imagenUsuario = imagenUsuario;
    }

    /**
     * Obtiene la lista de post comunes que ha realizado el usuario
     *
     * @return Lista de post comunes que ha realizado el usuario
     */
    public List<Comun> getListaPostComunes() {
        return listaPostComunes;
    }

    /**
     * Establece la lista de post comunes del usuario
     * 
     * @param listaPostComunes 
     */
    public void setListaPostComunes(List<Comun> listaPostComunes) {
        this.listaPostComunes = listaPostComunes;
    }

    /**
     * Obtiene el género del usuario
     *
     * @return Género del usuario
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * Establece el género del usuario
     *
     * @param genero Género del usuario (Masculino o Femenino)
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la fecha de nacimiento del usuario en tipo Calendar
     *
     * @return Fecha de nacimiento del usuario en tipo Calendar
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    /**
     * Obtiene la fecha de nacimiento del usuario en tipo Calendar
     *
     * @return Fecha de nacimiento del usuario en tipo Calendar
     */
    public String getFechaNacimientoToString() {
        SimpleDateFormat formateado = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = formateado.format((getFechaNacimiento().getTime()));
        return fechaFormateada;
    }

    /**
     * Establece la fecha de nacimiento con tipo Calendar
     *
     * @param fechaNacimiento Fecha de nacimiento de tipo Calendar
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el teléfono del usuario
     *
     * @return Teléfono del usuario
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del usuario
     *
     * @param telefono Teléfono del usuario
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la ciudad dónde vive el usuario
     *
     * @return Ciudad dónde vive el usuario
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad dónde vive el usuario
     *
     * @param ciudad Ciudad dónde vive el usuario
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene el correo del usuario
     *
     * @return Correo del usuario
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo del usuario
     *
     * @param correo Correo del usuario
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la contraseña del usuario
     *
     * @return Contraseña del usuario
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario
     *
     * @param contrasena Contraseña del usuario
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el municipio dónde se encuentra el usuario
     *
     * @return Municipio dónde se encuentra el usuario
     */
    public Municipio getMunicipio() {
        return municipio;
    }

    /**
     * Establece el municipio dónde se encuentra el usuario
     *
     * @param municipio Municipio dónde se encuentra el usaurio
     */
    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    /**
     * Obtiene el nombre completo del usuario
     *
     * @return Nombre completo del usuario
     */
    public String getNombreCompleto() {
        return nombres + " " + apellidos;
    }

    /**
     * Obtiene la lista de posts comunes que realizó el usuario
     *
     * @return Lista de posts comunes que realizó el usuario
     */
    public List<Comun> getListaPostComun() {
        return listaPostComunes;
    }

    /**
     * Establece la lista de posts comunes que realizó el usuario
     *
     * @param listaPostComun Lista de posts comunes que realizó el usuario
     */
    public void setListaPostComun(List<Comun> listaPostComun) {
        this.listaPostComunes = listaPostComun;
    }

    /**
     * Agrega un post común a la lista de posts comunes que realizó el usuario
     *
     * @param postComun Post común que se quiere agregar a la lista de posts
     * comunes que realizó el usuario
     * @return Lista de posts comunes que realizó el usuario
     */
    public List<Comun> agregarPostComun(Comun postComun) {
        if (this.listaPostComunes == null) {
            this.listaPostComunes = new LinkedList<>();
        }
        this.listaPostComunes.add(postComun);
        return this.listaPostComunes;
    }

    /**
     * Elimina un post común a la lista de posts comunes que realizó el usuario
     *
     * @param postComun Post común que se quiere eliminar de la lista de posts
     * comunes que realizó el usuario
     * @return Lista de posts comunes que realizó el usuario
     */
    public List<Comun> eliminarPostComun(Comun postComun) {
        if (this.listaPostComunes == null || this.listaPostComunes.isEmpty()) {
            return this.listaPostComunes;
        }
        this.listaPostComunes.remove(postComun);
        return this.listaPostComunes;
    }

    /**
     * Calcula y devuelve el código hash del objeto.
     *
     * @return El código hash del objeto.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara el objeto actual con otro objeto y determina si son iguales.
     *
     * @param object El objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Advertencia: este método no funcionará si los campos 'id' no están establecidos.
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", imagenUsuario=" + imagenUsuario + ", genero=" + genero + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + ", ciudad=" + ciudad + ", correo=" + correo + ", contrasena=" + contrasena + ", municipio=" + municipio + ", listaPostComunes=" + listaPostComunes + '}';
    }

    
}
