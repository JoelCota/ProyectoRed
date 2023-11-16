/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.itson.conexion.ConexionBD;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IEstadosDAO;
import org.itson.red.dominio.Estado;

/**
  * Clase encargada de gestionar los metodos necesarios para persistir estados 
 * en la base de datos.
 * @author oscar
 */
public class EstadosDAO implements IEstadosDAO{
    
    private final EntityManagerFactory emf;

    /**
     * Constructor por default
     */
    public EstadosDAO() {
        emf = ConexionBD.getConection();
    }
   
    /**
     * Metodo para persistir estados en la base de datos.
     * @param estado es el estados a persistir.
     * @return el estado persistido.
     * @throws PersistenciaException se lanza en caso de algun problema al persistir.
     */
    @Override
    public Estado registrarEstado(Estado estado) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        
        try {
            if (estado == null) {
                throw new PersistenciaException("No hay información del estado");
            }
            
            em.getTransaction().begin();
            em.persist(estado);
            em.getTransaction().commit();
        } catch (EntityExistsException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo insertar el estado a la base de datos.", e.getCause());
        } catch (RollbackException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Hubo un error de commit.", e.getCause());
        } catch (IllegalStateException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        } finally {
            em.close();
        }
        
        return estado;
    }

    /**
     * Metodo para editar un estado que ya esta persistido en la base de datos.
     * @param estado es el estado que se desea editar.
     * @return el estado ya editado.
     * @throws PersistenciaException se lanza en caso de algun problema al persistir.
     */
    @Override
    public Estado editarEstado(Estado estado) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        
        try {
            if (estado == null) {
                throw new PersistenciaException("No existe un estado a actualizar");
            }
            
            em.getTransaction().begin();
            em.merge(estado);
            em.getTransaction().commit();
        } catch (TransactionRequiredException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo actualizar el estado.", e.getCause());
        } catch (RollbackException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Hubo en error de commit.", e.getCause());
        } catch (IllegalArgumentException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        } finally {
            em.close();
        }
        
        return estado;
    }

    @Override
    public List<Estado> consultaListaEstados() throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
         try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Estado> criteria = builder.createQuery(Estado.class);
            TypedQuery<Estado> query = em.createQuery(criteria);
            List<Estado> estados = query.getResultList();
            em.getTransaction().commit();
            return estados;
        } catch (PersistenciaException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al buscar estados ", e);
        } finally {
            em.close();
        }
    }
}
