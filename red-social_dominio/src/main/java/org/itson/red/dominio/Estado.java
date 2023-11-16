/**
 * Estado.java
 * 10 jun. 2023 11:51:23
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
@Entity
@Table(name = "estados")
public class Estado implements Serializable {

    /**
     * Id del estado
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del estado
     */
    @Column(name = "nombre")
    private String nombre;

    /**
     * Lista de municipios que representa los municipios dentro del estado
     */
    @OneToMany(mappedBy = "estado" )
    private List<Municipio> municipios;

    /**
     * Constructor por default
     */
    public Estado() {

    }

    /**
     * Constructor que crea un estado con id, nombre y su lista de municipios
     *
     * @param id Id del estado
     * @param nombre Nombre del estado
     * @param municipios Lista de municipios dentro del estado
     */
    public Estado(Long id, String nombre, List<Municipio> municipios) {
        this.id = id;
        this.nombre = nombre;
        this.municipios = municipios;
    }

    /**
     * Constructor que crea un estado con nombre y su lista de municipios
     *
     * @param nombre Nombre del estado
     * @param municipios Lista de municipios dentro del estado
     */
    public Estado(String nombre, List<Municipio> municipios) {
        this.nombre = nombre;
        this.municipios = municipios;
    }

    /**
     * Obtiene el id del estado
     *
     * @return Id del estado
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el id del estado
     *
     * @param id Id del estado
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del estado
     *
     * @return Nombre del estado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del estado
     *
     * @param nombre Nombre del estado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de los municipios que representa los municipios dentro
     * del estado
     *
     * @return Lista de municipios
     */
    public List<Municipio> getMunicipios() {
        return municipios;
    }

    /**
     * Establece la lista de los municipios que representa los municipios dentro
     * del estado
     *
     * @param municipios Lista de municipios
     */
    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }

    /**
     * Agrega un municipio a lista de municipios, que representa los municipios
     * que se encuentra dentro del estado
     *
     * @param municipio Municipio que se agrega a la lista de municipios que se
     * encuentra dentro del estado
     * @return Lista de los municipios dentro del estado
     */
    public List<Municipio> agregarMunicipio(Municipio municipio) {
        if (this.municipios == null) {
            this.municipios = new LinkedList<>();
        }
        this.municipios.add(municipio);
        return this.municipios;
    }

    /**
     * Elimina un municipio de la lista de municipios, que representa los
     * municipios que se encuentra dentro del estado
     *
     * @param municipio Municipio que se elimina de la lista de municipios que
     * se encuentra dentro del estado
     * @return Lista de los municipios dentro del estado
     */
    public List<Municipio> eliminarMunicipio(Municipio municipio) {
        if (this.municipios == null || this.municipios.isEmpty()) {
            return this.municipios;
        }
        this.municipios.remove(municipio);
        return this.municipios;
    }

    /**
     * Devuelve el código hash de este Estado.
     *
     * @return el código hash de este Estado
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara si el objeto es igual a este Estado.
     *
     * @param object el objeto a comparar
     * @return true si el objeto es igual a este Estado, false en caso contrario
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Advertencia: este método no funcionará si los campos id no están configurados
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una representación en forma de cadena de este Estado.
     *
     * @return una cadena que representa este Estado
     */
    @Override
    public String toString() {
        return "org.itson.red.dominio.Estado[ id=" + id + " ]";
    }

}
