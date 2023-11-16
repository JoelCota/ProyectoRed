/**
 * Comentario.java
 * 10 jun. 2023 13:55:11
 */
package org.itson.red.dominio;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
@Entity
@Table(name = "comentarios")
public class Comentario implements Serializable {

    /**
     * Id del comentario
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Es el contenido o mensaje del comentario
     */
    @Column(name = "contenido", columnDefinition = "TEXT")
    private String contenido;

    /**
     * Comentario, al que se le contestó
     */
    @ManyToOne()
    @JoinColumn(name = "idComentario", referencedColumnName = "id")
    private Comentario comentario;

    /**
     * Lista de comentarios en caso que un comentario sea contestado
     */
    @OneToMany(mappedBy = "comentario", cascade = {CascadeType.REMOVE})
    private List<Comentario> respuestas;

    /**
     * Usuario que escribió el comentario
     */
    @ManyToOne()
    @JoinColumn(name = "idUsuarioNormal")
    private Normal usuarioNormal;

    /**
     * Post al que se realizó el comentario
     */
    @ManyToOne()
    @JoinColumn(name = "idPost")
    private Comun postComun;

    @PreRemove
    private void preRemove() {
        if(this.comentario != null){
            this.comentario = null;
        }
    }

    /**
     * Constructor por default
     */
    public Comentario() {

    }

    /**
     * Comentario que se le realiza a un post
     *
     * @param id Id del comentario al post
     * @param contenido Contenido del texto del comentario
     * @param usuarioNormal Usuario que realizó el comentario
     * @param postComun Post al que se realiza el comentario
     */
    public Comentario(Long id, String contenido, Normal usuarioNormal, Comun postComun) {
        this.id = id;
        this.contenido = contenido;
        this.usuarioNormal = usuarioNormal;
        this.postComun = postComun;
    }

    /**
     * Comentario que se le realiza a un post
     *
     * @param contenido Contenido del texto del comentario
     * @param usuarioNormal Usuario que realizó el comentario
     * @param postComun Post al que se realiza el comentario
     */
    public Comentario(String contenido, Normal usuarioNormal, Comun postComun) {
        this.contenido = contenido;
        this.usuarioNormal = usuarioNormal;
        this.postComun = postComun;
    }

    /**
     * Comentario que se le realiza a un post
     *
     * @param id Id del comentario al post
     * @param contenido Contenido del texto del comentario
     * @param respuestas Lista de respuestas que tiene el comentario
     * @param usuarioNormal Usuario que realizó el comentario
     * @param postComun Post al que se realiza el comentario
     */
    public Comentario(Long id, String contenido, List<Comentario> respuestas, Normal usuarioNormal, Comun postComun) {
        this.id = id;
        this.contenido = contenido;
        this.respuestas = respuestas;
        this.usuarioNormal = usuarioNormal;
        this.postComun = postComun;
    }

    /**
     * Comentario que se le realiza a un post
     *
     * @param contenido Contenido del texto del comentario
     * @param respuestas Lista de respuestas que tiene el comentario
     * @param usuarioNormal Usuario que realizó el comentario
     * @param postComun Post al que se realiza el comentario
     */
    public Comentario(String contenido, List<Comentario> respuestas, Normal usuarioNormal, Comun postComun) {
        this.contenido = contenido;
        this.respuestas = respuestas;
        this.usuarioNormal = usuarioNormal;
        this.postComun = postComun;
    }

    /**
     * Constructor que realiza una respuesta a un comentario
     *
     * @param id Id del comentario que termina siendo una respuesta
     * @param contenido Contenido de la respuesta
     * @param comentario Comentario al que se le hace respuesta
     * @param usuarioNormal Usuario quién realiza la respuesta
     * @param postComun Post al que le pertenece esa respuesta al comentario
     */
    public Comentario(Long id, String contenido, Comentario comentario, Normal usuarioNormal, Comun postComun) {
        this.id = id;
        this.contenido = contenido;
        this.comentario = comentario;
        this.usuarioNormal = usuarioNormal;
        this.postComun = postComun;
    }

    /**
     * Constructor que realiza una respuesta a un comentario
     *
     * @param contenido Contenido de la respuesta
     * @param comentario Comentario al que se le hace respuesta
     * @param usuarioNormal Usuario quién realiza la respuesta
     * @param postComun Post al que le pertenece esa respuesta al comentario
     */
    public Comentario(String contenido, Comentario comentario, Normal usuarioNormal, Comun postComun) {
        this.contenido = contenido;
        this.comentario = comentario;
        this.usuarioNormal = usuarioNormal;
        this.postComun = postComun;
    }

    /**
     * Constructor que realiza una respuesta a un comentario pero con respuestas
     * dentro del mismo
     *
     * @param id Id del comentario que termina siendo una respuesta
     * @param contenido Contenido de la respuesta
     * @param comentario Comentario al que se le hace respuesta
     * @param respuestas Lista de respuestas que tiene el comentario que es una
     * respuesta
     * @param usuarioNormal Usuario quién realiza la respuesta
     * @param postComun Post al que le pertenece esa respuesta al comentario
     */
    public Comentario(Long id, String contenido, Comentario comentario, List<Comentario> respuestas, Normal usuarioNormal, Comun postComun) {
        this.id = id;
        this.contenido = contenido;
        this.comentario = comentario;
        this.respuestas = respuestas;
        this.usuarioNormal = usuarioNormal;
        this.postComun = postComun;
    }

    /**
     * Constructor que realiza una respuesta a un comentario pero ya con
     * respuestas dentro del mismo
     *
     * @param contenido Contenido de la respuesta
     * @param comentario Comentario al que se le hace respuesta
     * @param respuestas Lista de respuestas que tiene el comentario que es una
     * respuesta
     * @param usuarioNormal Usuario quién realiza la respuesta
     * @param postComun Post al que le pertenece esa respuesta al comentario
     */
    public Comentario(String contenido, Comentario comentario, List<Comentario> respuestas, Normal usuarioNormal, Comun postComun) {
        this.contenido = contenido;
        this.comentario = comentario;
        this.respuestas = respuestas;
        this.usuarioNormal = usuarioNormal;
        this.postComun = postComun;
    }

    /**
     * Obtiene el id del comentario
     *
     * @return Id del comentario
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el id del comentario
     *
     * @param id Id del comentario
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el contenido del comentario
     *
     * @return Contenido del comentario
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Establece el contenido del comentario
     *
     * @param contenido Contenido del comentario
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Obtiene el comentario al que se le respondió
     *
     * @return Comentario al que se le respondió
     */
    public Comentario getComentario() {
        return comentario;
    }

    /**
     * Establece el comentario al que le respondió
     *
     * @param comentario Comentario al que se le respondió
     */
    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    /**
     * Obtiene la lista de respuestas que el comentario recibió
     *
     * @return Lista de respuestas que el comentario recibió
     */
    public List<Comentario> getRespuestas() {
        return respuestas;
    }

    /**
     * Establece la lista de respuestas que recibió el comentario
     *
     * @param respuestas Lista de respuestas que recibió el comentario
     */
    public void setRespuestas(List<Comentario> respuestas) {
        this.respuestas = respuestas;
    }

    /**
     * Obtiene el usuario que realizó el comentario
     *
     * @return Usuario que realizó el comentario
     */
    public Normal getUsuarioNormal() {
        return usuarioNormal;
    }

    /**
     * Establece el usuario que realizó el comentario
     *
     * @param usuarioNormal Usuario normal que realizó el comentario
     */
    public void setUsuarioNormal(Normal usuarioNormal) {
        this.usuarioNormal = usuarioNormal;
    }

    /**
     * Obtiene el post al que se le hizo el comentario
     *
     * @return Post al que se le hizo el comentario
     */
    public Comun getPostComun() {
        return postComun;
    }

    /**
     * Establece el post al que se le hace el comentario
     *
     * @param postComun Post al que se le hace el comentario
     */
    public void setPostComun(Comun postComun) {
        this.postComun = postComun;
    }

    /**
     * Agregar respuesta al comentario
     *
     * @param respuesta Respuesta que recibe el comentario
     * @return Lista de respuestas que recibió el comentario
     */
    public List<Comentario> agregarRespuesta(Comentario respuesta) {
        if (this.respuestas == null) {
            this.respuestas = new LinkedList<>();
        }
        this.respuestas.add(respuesta);
        return this.respuestas;
    }

    /**
     * Elimina respuesta del comentario
     *
     * @param respuesta Respuesta que se elimina del comentario
     * @return Lista de respuestas que recibió el comentario
     */
    public List<Comentario> eliminarRespuesta(Comentario respuesta) {
        if (this.respuestas == null || this.respuestas.isEmpty()) {
            return this.respuestas;
        }
        this.respuestas.remove(respuesta);
        return this.respuestas;
    }

    /**
     * Calcula el valor hash para el objeto Comentario. El valor hash se basa en
     * el atributo 'id'.
     *
     * @return el valor hash calculado.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara si el objeto Comentario es igual a otro objeto. La comparación se
     * realiza verificando si ambos objetos son instancias de Comentario y si
     * tienen el mismo valor para el atributo 'id'.
     *
     * @param object el objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - este método no funcionará si los campos 'id' no están establecidos
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Comentario. La
     * cadena resultante contiene el valor del atributo 'id'.
     *
     * @return la representación en forma de cadena del objeto.
     */
    @Override
    public String toString() {
        return "org.itson.red.dominio.Comentario[ id=" + id + " ]";
    }

}
