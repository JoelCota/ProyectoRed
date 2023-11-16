/**
 * Post.java
 * 9 jun. 2023 23:13:12
 */
package org.itson.red.dominio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
@Entity
@Table(name = "posts")
@DiscriminatorColumn(name = "tipoPost")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Post implements Serializable {

    /**
     * Id del post
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Fecha en la que se creó el post
     */
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaCreacion;

    /**
     * Contenido del post
     */
    @Column(name = "contenido", columnDefinition = "TEXT")
    private String contenido;

    /**
     * Título del post
     */
    @Column(name = "titulo")
    private String titulo;

    /**
     * Fecha en la que se modificó el post
     */
    @Column(name = "fechaEdicion")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaEdicion;

    /**
     * Constructor por default
     */
    public Post() {

    }
    
    @PrePersist
    private void prePersist(){
        this.fechaCreacion = new GregorianCalendar();
    }
    
    @PreUpdate
    private void preUpdate(){
        this.fechaEdicion = new GregorianCalendar();
    }

    /**
     * Constructor para crear un post nuevo con id, fecha de creación, contenido
     * y título
     *
     * @param id Id del post
     * @param fechaCreacion Fecha en la que se creó el post
     * @param contenido Contenido del post
     * @param titulo Titulo del post
     */
    public Post(Long id, Calendar fechaCreacion, String contenido, String titulo) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.contenido = contenido;
        this.titulo = titulo;
    }

    /**
     * Constructor para modificar un post antiguo con id, fecha de creación,
     * contenido, título y fecha en la que se modificó el post
     *
     * @param id Id del post
     * @param fechaCreacion Fecha en la que se creó el post
     * @param contenido Contenido del post
     * @param titulo Titulo del post
     * @param fechaEdicion Fecha en la que se modificó el post
     */
    public Post(Long id, Calendar fechaCreacion, String contenido, String titulo, Calendar fechaEdicion) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.contenido = contenido;
        this.titulo = titulo;
        this.fechaEdicion = fechaEdicion;
    }

    /**
     * Constructor para modificar un post antiguo con fecha de creación,
     * contenido, título y fecha en la que se modificó el post
     *
     * @param fechaCreacion Fecha en la que se creó el post
     * @param contenido Contenido del post
     * @param titulo Titulo del post
     * @param fechaEdicion Fecha en la que se modificó el post
     */
    public Post(Calendar fechaCreacion, String contenido, String titulo, Calendar fechaEdicion) {
        this.fechaCreacion = fechaCreacion;
        this.contenido = contenido;
        this.titulo = titulo;
        this.fechaEdicion = fechaEdicion;
    }

    /**
     * Constructor para crear un post nuevo con fecha de creación, contenido y
     * título
     *
     * @param fechaCreacion Fecha en la que se creó el post
     * @param contenido Contenido del post
     * @param titulo Titulo del post
     */
    public Post(Calendar fechaCreacion, String contenido, String titulo) {
        this.fechaCreacion = fechaCreacion;
        this.contenido = contenido;
        this.titulo = titulo;
    }

    /**
     * Obtiene el id del post
     *
     * @return Id del post
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el id del post
     *
     * @param id Id del post
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha en la que se creó el post
     * @return Fecha en la que se creó el post
     */
    public Calendar getFechaCreacion() {
        return fechaCreacion;
    }
    
    /**
     * Obtiene la fecha en la que se creó el post en string
     * @return Fecha en la que se creó el post
     */
    public String getFechaCreacionToString() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada =  formatoFecha.format(getFechaCreacion().getTime());
        return fechaFormateada;
    }

    /**
     * Establece la fecha de creación
     * @param fechaCreacion Fecha en la que se creó el post
     */
    public void setFechaCreacion(Calendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Obtiene el contenido del post
     * 
     * @return Contenido del post
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Establece el contenido del post
     * 
     * @param contenido Contenido del post
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Obtiene el título del post
     * 
     * @return Título del post
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del post
     * 
     * @param titulo Título del post
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene la fecha en la que se editó el post
     * 
     * @return Fecha en la que se editó el post
     */
    public Calendar getFechaEdicion() {
        return fechaEdicion;
    }

    /**
     * Obtiene la fecha en la que se edito el post en string
     * @return Fecha en la que se creó el post
     */
    public String getFechaEdicionToString() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada =  formatoFecha.format(getFechaEdicion().getTime());
        return fechaFormateada;
    }
    
    /**
     * Establece la fecha en la que se editó el post
     * 
     * @param fechaEdicion Fecha en la que se editó el post
     */
    public void setFechaEdicion(Calendar fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
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
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una representación en formato de cadena del objeto Post.
     *
     * @return Una cadena que representa al objeto Post.
     */
    @Override
    public String toString() {
        return "org.itson.red.dominio.Post[ id=" + id + " ]";
    }
}
