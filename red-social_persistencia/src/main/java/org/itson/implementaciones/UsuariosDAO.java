/**
 * UsuarioDAO.java
 * 11 jun. 2023 02:17:45
 */
package org.itson.implementaciones;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.itson.conexion.ConexionBD;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IUsuariosDAO;
import org.itson.red.dominio.Administrador;
import org.itson.red.dominio.Normal;
import org.itson.red.dominio.Usuario;

/**
 * Descripción de la clase:
 *
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class UsuariosDAO implements IUsuariosDAO{

    private final EntityManagerFactory emf;

    /**
     * Constructor por default
     */
    public  UsuariosDAO() {
        emf = ConexionBD.getConection();
    }
    /**
     * Metodo para registrar un usuario normal en la base de datos.
     * @param usuario el usuario a registrar.
     * @return el usuario que se persisitio.
     * @throws PersistenciaException se lanza en caso de algun problema al persistir.
     */
    @Override
    public Usuario registrarUsuarioNormal(Normal usuario) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        
        try {
            if (usuario == null) {
                throw new PersistenciaException("No hay información del usuario");
            }
            
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (EntityExistsException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo insertar el usuario a la base de datos.", e.getCause());
        } catch (RollbackException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Hubo un error de commit.", e.getCause());
        } catch (IllegalStateException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        } finally {
            em.close();
        }
        
        return usuario;
    }
    /**
     * Metodo para registrrar un usuario de tipo administrador.
     * @param usuario el usuario a registrar.
     * @return el usuario persistido.
     * @throws PersistenciaException se lanza en caso de algun problema al persistir.
     */
    @Override
    public Usuario registrarUsuarioAdministrador(Administrador usuario) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        
        try {
            if (usuario == null) {
                throw new PersistenciaException("No hay información del usuario");
            }
            
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (EntityExistsException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo insertar el usuario a la base de datos.", e.getCause());
        } catch (RollbackException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Hubo un error de commit.", e.getCause());
        } catch (IllegalStateException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        } finally {
            em.close();
        }
        
        return usuario;
    }

    @Override
    public Usuario consultarUsuarioParaLogin(String correo, String password) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();

            CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);

            Root<Usuario> usuario = criteria.from(Usuario.class);
            
            List<Predicate> filtros = new LinkedList<>();
            
            filtros.add(builder.equal(usuario.get("correo"), correo));
            filtros.add(builder.equal(usuario.get("contrasena"), password));
            
            criteria.select(usuario).where(builder.and(filtros.toArray(new Predicate[0])));
            
            TypedQuery<Usuario> query = em.createQuery(criteria);

            Usuario usuarioEncontrado = query.getSingleResult();
            
            return usuarioEncontrado;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Usuario consultarUsuarioPorId(Long id) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            Usuario usuario = em.find(Usuario.class, id);
            em.refresh(usuario);
            em.getTransaction().commit();
            return usuario;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        } finally {
            em.close();
        }
    }

}
