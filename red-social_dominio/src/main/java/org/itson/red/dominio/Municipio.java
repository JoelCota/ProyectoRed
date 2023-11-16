/**
 * Municipio.java
 * 10 jun. 2023 11:51:34
 */
package org.itson.red.dominio;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
@Entity
@Table(name = "municipios")
public class Municipio implements Serializable {

    /**
     * Id del municipio
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del municipio
     */
    @Column(name = "nombre")
    private String nombre;

    /**
     * Estado en dónde se encuentra el municipio
     */
    @ManyToOne()
    @JoinColumn(name = "idEstado")
    private Estado estado;

    /**
     * Lista de usuarios que se úbican en este municipio
     */
    @OneToMany(mappedBy = "municipio")
    private List<Usuario> usuarios;

    /**
     * Constructor por default
     */
    public Municipio() {

    }

    /**
     * Constructor que crea un municipio con id, nombre y su estado
     *
     * @param id Id del municipio
     * @param nombre Nombre del municipio
     * @param estado Estado dónde se encuentra el municipio
     * @param usuarios Lista de usuarios que se úbican en este municipio
     */
    public Municipio(Long id, String nombre, Estado estado, List<Usuario> usuarios) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.usuarios = usuarios;
    }

    /**
     * Constructor que crea un municipio con nombre y su estado
     *
     * @param nombre Nombre del municipio
     * @param estado Estado dónde se encuentra el municipio
     * @param usuarios Lista de usuarios que se úbican en este municipio
     */
    public Municipio(String nombre, Estado estado, List<Usuario> usuarios) {
        this.nombre = nombre;
        this.estado = estado;
        this.usuarios = usuarios;
    }

    /**
     * Obtiene el id del municipio
     *
     * @return Id del municipio
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el id del municipio
     *
     * @param id Id del municipio
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del municipio
     *
     * @return Nombre del municipio
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del municipio
     *
     * @param nombre Nombre del municipio
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el estado dónde se úbica el municipio
     *
     * @return Obtiene el estado dónde se úbica el municipio
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Establece el estado dónde se úbica el municipio
     *
     * @param estado Estado dónde se úbica el municipio
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la lista de ususarios que se úbican en este municipio
     *
     * @return Lista de usuarios que se úbican en este municipio
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Establece la lista de usuarios que se úbican en este municipio
     *
     * @param usuarios Lista de usuarios que se úbican en este municipio
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Agrega un usuario a la lista de usuarios que se úbican en este municipio
     *
     * @param usuario Usuario que se agregará a la lista de usuarios que se
     * úbican en este municipio
     * @return Lista de usuarios que se úbican en este municipio
     */
    public List<Usuario> agregarUsuario(Usuario usuario) {
        if (this.usuarios == null) {
            this.usuarios = new LinkedList<>();
        }
        this.usuarios.add(usuario);
        return this.usuarios;
    }

    /**
     * Elimina un usuario a la lista de usuarios que se úbican en este municipio
     *
     * @param usuario Usuario que se eliminará de la lista de usuarios que se
     * úbican en este municipio
     * @return Lista de usuarios que se úbican en este municipio
     */
    public List<Usuario> eliminarUsuario(Usuario usuario) {
        if (this.usuarios == null || this.usuarios.isEmpty()) {
            return this.usuarios;
        }
        this.usuarios.remove(usuario);
        return this.usuarios;
    }
    
    /**
     * Devuelve el código hash de este Municipio.
     *
     * @return el código hash de este Municipio
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara si el objeto es igual a este Municipio.
     *
     * @param object el objeto a comparar
     * @return true si el objeto es igual a este Municipio, false en caso
     * contrario
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Advertencia: este método no funcionará si los campos id no están configurados
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una representación en forma de cadena de este Municipio.
     *
     * @return una cadena que representa este Municipio
     */
    @Override
    public String toString() {
        return "org.itson.red.dominio.Municipio[ id=" + id + " ]";
    }

}
