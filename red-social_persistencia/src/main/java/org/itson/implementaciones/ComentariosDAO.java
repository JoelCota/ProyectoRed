/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import org.itson.excepciones.PersistenciaException;
import org.itson.conexion.ConexionBD;
import org.itson.interfaces.IComentariosDAO;
import org.itson.red.dominio.Comentario;

/**
 * Clase encargada de gestionar los metodos necesarios para persistir
 * comentarios en la base de datos.
 *
 * @author oscar
 */
public class ComentariosDAO implements IComentariosDAO {

    private final EntityManagerFactory emf;

    /**
     * Constructor por default
     */
    public ComentariosDAO() {
        emf = ConexionBD.getConection();
    }

    /**
     * Metodo para registrar un comentario en la base de datos.
     *
     * @param comentario es el comentario a persistir.
     * @return el comentario que se ha persistido.
     * @throws PersistenciaException se lanza en caso de algun problema al
     * persistir.
     */
    @Override
    public Comentario registarComentario(Comentario comentario) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();

        try {
            if (comentario == null) {
                throw new PersistenciaException("No hay información del comentario");
            }

            em.getTransaction().begin();
            em.persist(comentario);
            em.getTransaction().commit();
        } catch (EntityExistsException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo insertar el comentario a la base de datos.", e.getCause());
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

        return comentario;
    }

    /**
     * Metodo para eliminar un comentario de la base de datos.
     *
     * @param comentario es el comentario que se desea eliminar.
     * @return el comentario eliminado.
     * @throws PersistenciaException se lanza en caso de algun problema al
     * persistir.
     */
    @Override
    public Comentario eliminarComentario(Comentario comentario) throws PersistenciaException {

        EntityManager em = emf.createEntityManager();
        try {
            if (comentario == null) {
                throw new PersistenciaException("No hay información del comentario");
            }
            em.getTransaction().begin();
            Comentario comMerge = em.merge(comentario);
            em.remove(comMerge);
            em.getTransaction().commit();
        } catch (EntityExistsException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo eliminar el comentario a la base de datos.", e.getCause());
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
        return comentario;
    }

    @Override
    public Comentario consultarComentarioPorId(Long id) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            if (id == null) {
                throw new PersistenciaException("No hay información del id");
            }
            em.getTransaction().begin();
            Comentario comentario = em.find(Comentario.class, id);
            em.getTransaction().commit();
            return comentario;
        } catch (EntityExistsException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo eliminar el comentario a la base de datos.", e.getCause());
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

    }
}
