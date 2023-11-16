/**
 * MunicipioDAO.java
 * 13 jun. 2023 07:47:50
 */
package org.itson.implementaciones;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.itson.conexion.ConexionBD;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IMunicipioDAO;
import org.itson.red.dominio.Municipio;

/**
 * Clase encargada de gestionar todos los metodos necesarios para persisit
 * @author Daniel Armando Peña Garcia ID:229185
 */
public class MunicipioDAO implements IMunicipioDAO {

    EntityManagerFactory emf;

    /**
     * Constructor por default
     */
    public MunicipioDAO() {

        emf = ConexionBD.getConection();
    }
    /**
     * Metood para registrar un municipio en la base de datos.  
     * @param municipio es el municipio que se desea registrar en la base de datos.
     * @return el municipio que se registro en la base de datos.
     * @throws PersistenceException se lanza en caso de algun problema al persistir.
     */
    @Override
    public Municipio registrarMunicipio(Municipio municipio) throws PersistenceException {
        EntityManager em = emf.createEntityManager();
        try {
            if (municipio == null) {
                throw new PersistenceException("No hay información del municipio");
            }
            em.getTransaction().begin();
            em.persist(municipio);
            em.getTransaction().commit();
        } catch (EntityExistsException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo insertar el municipio a la base de datos.", e.getCause());
        } catch (RollbackException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Hubo un error de commit.", e.getCause());
        } catch (IllegalStateException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        } catch (PersistenciaException e) {
            throw new PersistenciaException("Algo salió mal: " + e.getMessage());
        } finally {
            em.close();
        }
        return municipio;
    }

    @Override
    public List<Municipio> consultaListaMunicipios() throws PersistenciaException {
     EntityManager em = emf.createEntityManager();
         try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Municipio> criteria = builder.createQuery(Municipio.class);
            TypedQuery<Municipio> query = em.createQuery(criteria);
            List<Municipio> municipios = query.getResultList();
            em.getTransaction().commit();
            return municipios;
        } catch (PersistenciaException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al buscar municipios: ", e);
        } finally {
            em.close();
        }
    
    }

    @Override
    public Municipio buscarMunicipioNombre(String nombre) throws PersistenceException {
        EntityManager em = emf.createEntityManager();
        
        try {
              em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Municipio> criteria = builder.createQuery(Municipio.class);
            Root<Municipio> municipio = criteria.from(Municipio.class);
            List<Predicate> filtros = new LinkedList<>();
            filtros.add(builder.equal(municipio.get("nombre"), nombre));
            criteria.select(municipio).where(builder.and(filtros.toArray(new Predicate[0])));
            TypedQuery<Municipio> query = em.createQuery(criteria);
            Municipio municipioEncontrado = query.getSingleResult();
            em.getTransaction().commit();
            return municipioEncontrado;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        }}
}
