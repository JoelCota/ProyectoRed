/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.itson.conexion.ConexionBD;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.IPostsDAO;
import org.itson.red.dominio.Anclado;
import org.itson.red.dominio.Comentario;
import org.itson.red.dominio.Comun;
import org.itson.red.dominio.Post;
import org.itson.red.dominio.Usuario;

/**
 * Clase encargada de gestionar todos los metodos necesarios para persistir un
 * post en la base de datos.
 *
 * @author oscar
 */
public class PostsDAO implements IPostsDAO {

    private final EntityManagerFactory emf;

    /**
     * Constructor por default
     */
    public PostsDAO() {
        emf = ConexionBD.getConection();
    }

    /**
     * Metodo encargado de registrar un post comun en la base de datos.
     *
     * @param post Es el post comun que se desea registrar.
     * @return el post que se registro en la base de datos.
     * @throws PersistenciaException se lanza en caso de algun problema al
     * persistir.
     */
    @Override
    public Post registrarPostComun(Comun post) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();

        try {
            if (post == null) {
                throw new PersistenciaException("No hay información del post");
            }
            
            em.getTransaction().begin();
            em.persist(post);
            em.getTransaction().commit();
        } catch (EntityExistsException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo insertar el post a la base de datos.", e.getCause());
        } catch (RollbackException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Hubo un error de commit.", e.getCause());
        } catch (IllegalStateException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        } finally {
            em.close();
        }

        return post;
    }

    /**
     * Metodo para registrar un post anclado.
     *
     * @param post es el post anclado que se desea registrar.
     * @return el post que se registro.
     * @throws PersistenceException se lanza en caso de algun problema al
     * persistir.
     */
    @Override
    public Post registrarPostAnclado(Anclado post) throws PersistenceException {
        EntityManager em = emf.createEntityManager();

        try {
            if (post == null) {
                throw new PersistenciaException("No hay información del post");
            }

            em.getTransaction().begin();
            em.persist(post);
            em.getTransaction().commit();
        } catch (EntityExistsException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo insertar el post a la base de datos.", e.getCause());
        } catch (RollbackException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Hubo un error de commit.", e.getCause());
        } catch (IllegalStateException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        } finally {
            em.close();
        }

        return post;
    }

    /**
     * Metodo para editar un post comun registrado en la base de datos.
     *
     * @param post es el post que se desea editar.
     * @return el post ya editado.
     * @throws PersistenciaException se lanza en caso de algun problema al
     * persistir.
     */
    @Override
    public Post editarPostComun(Comun post) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();

        try {
            if (post == null) {
                throw new PersistenciaException("No existe un post a actualizar");
            }

            em.getTransaction().begin();
            em.merge(post);
            em.getTransaction().commit();
        } catch (TransactionRequiredException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo actualizar el post.", e.getCause());
        } catch (RollbackException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Hubo en error de commit.", e.getCause());
        } catch (IllegalArgumentException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        } finally {
            em.close();
        }

        return post;
    }
    
    /**
     * Metodo para editar un post comun registrado en la base de datos.
     *
     * @param post es el post que se desea editar.
     * @return el post ya editado.
     * @throws PersistenciaException se lanza en caso de algun problema al
     * persistir.
     */
    @Override
    public Post editarPost(Post post) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();

        try {
            if (post == null) {
                throw new PersistenciaException("No existe un post a actualizar");
            }

            em.getTransaction().begin();
            em.merge(post);
            em.getTransaction().commit();
        } catch (TransactionRequiredException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo actualizar el post.", e.getCause());
        } catch (RollbackException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Hubo en error de commit.", e.getCause());
        } catch (IllegalArgumentException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        } finally {
            em.close();
        }

        return post;
    }

    /**
     * Metodo para editar un post anclado.
     *
     * @param post es el post anclado que se desea editar.
     * @return el post ya editado.
     * @throws PersistenciaException se lanza en caso de algun problema al
     * persistir.
     */
    @Override
    public Post editarPostAnclado(Anclado post) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();

        try {
            if (post == null) {
                throw new PersistenciaException("No existe un post a actualizar");
            }

            em.getTransaction().begin();
            em.merge(post);
            em.getTransaction().commit();
        } catch (TransactionRequiredException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo actualizar el post.", e.getCause());
        } catch (RollbackException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Hubo en error de commit.", e.getCause());
        } catch (IllegalArgumentException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        } finally {
            em.close();
        }

        return post;
    }

    /**
     * Metodo para elimianr un post de la base de datos.
     *
     * @param post es el post que se desea elimianr.
     * @return el post que se elimino.
     * @throws PersistenceException se lanza en caso de algun problema al
     * persistir.
     */
    @Override
    public Post eliminarPost(Post post) throws PersistenceException {
        EntityManager em = emf.createEntityManager();
        try {
            if (post == null) {
                throw new PersistenceException("No hay información del post");
            }
            em.getTransaction().begin();
            Post postMerge = em.merge(post);
            em.remove(postMerge);
            em.getTransaction().commit();
        } catch (TransactionRequiredException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo eliminar el post.", e.getCause());
        } catch (RollbackException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Hubo un error de commit.", e.getCause());
        } catch (IllegalArgumentException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        } finally {
            em.close();
        }
        return post;
    }

    @Override
    public Post consultarPostPorId(Long id) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();

        try {

            if (id == null) {
                throw new PersistenciaException("No hay información del id ");
            }

            em.getTransaction().begin();
            Post post = em.find(Post.class, id);
            em.getTransaction().commit();
            return post;
        } catch (PersistenciaException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al buscar el post: ", e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Anclado> consultarPostsAncladosPaginadoRecientes(int elementosPorPagina, int numeroPagina) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        int saltarResultados = (numeroPagina - 1) * elementosPorPagina;
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Anclado> criteria = builder.createQuery(Anclado.class);
            Root<Anclado> root = criteria.from(Anclado.class);
            criteria.select(root);
            criteria.orderBy(builder.desc(root.get("fechaCreacion")));

            TypedQuery<Anclado> query = em.createQuery(criteria);
            query.setFirstResult(saltarResultados);
            query.setMaxResults(elementosPorPagina);
            List<Anclado> postsAnclados = query.getResultList();
            for (Anclado postsAnclado : postsAnclados) {
                em.refresh(postsAnclado);
            }
            em.getTransaction().commit();
            return postsAnclados;
        } catch (PersistenciaException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al buscar el post: ", e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Comun> consultarPostsComunesPaginadoRecientes(int elementosPorPagina, int numeroPagina) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        int saltarResultados = (numeroPagina - 1) * elementosPorPagina;
        try {

            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Comun> criteria = builder.createQuery(Comun.class);
            Root<Comun> root = criteria.from(Comun.class);
            criteria.select(root);
            criteria.orderBy(builder.desc(root.get("fechaCreacion")));

            TypedQuery<Comun> query = em.createQuery(criteria);
            query.setFirstResult(saltarResultados);
            query.setMaxResults(elementosPorPagina);
            List<Comun> postComunes = query.getResultList();
            for (Comun postComun : postComunes) {
                em.refresh(postComun);
                for (Comentario comentario : postComun.getComentarios()) {
                    em.refresh(comentario);
                }
            }
            em.getTransaction().commit();
            return postComunes;
        } catch (PersistenciaException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al buscar el post: ", e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Comun> consultarPostsComunesPorUsuarioPaginadoRecientes(Usuario usuario, int elementosPorPagina, int numeroPagina) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        int saltarResultados = (numeroPagina - 1) * elementosPorPagina;
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();

            CriteriaQuery<Comun> criteria = builder.createQuery(Comun.class);

            Root<Comun> postComun = criteria.from(Comun.class);

            criteria.select(postComun)
                    .where(
                            builder.equal(postComun.get("usuario"), usuario)
                    );
            criteria.orderBy(builder.desc(postComun.get("fechaCreacion")));

            TypedQuery<Comun> query = em.createQuery(criteria);
            query.setFirstResult(saltarResultados);
            query.setMaxResults(elementosPorPagina);

            List<Comun> listaPublicaciones = query.getResultList();
            for (Comun posts : listaPublicaciones) {
                em.refresh(posts);
                for (Comentario comentario : posts.getComentarios()) {
                    em.refresh(comentario);
                }
            }
            em.getTransaction().commit();
            return listaPublicaciones;
        } catch (PersistenciaException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al buscar el post: ", e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Anclado> consultarPostsAncladosPorUsuarioPaginadoRecientes(Usuario usuario, int elementosPorPagina, int numeroPagina) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        int saltarResultados = (numeroPagina - 1) * elementosPorPagina;
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();

            CriteriaQuery<Anclado> criteria = builder.createQuery(Anclado.class);

            Root<Anclado> postComun = criteria.from(Anclado.class);

            criteria.select(postComun)
                    .where(
                            builder.equal(postComun.get("usuario"), usuario)
                    );
            criteria.orderBy(builder.desc(postComun.get("fechaCreacion")));

            TypedQuery<Anclado> query = em.createQuery(criteria);
            query.setFirstResult(saltarResultados);
            query.setMaxResults(elementosPorPagina);

            List<Anclado> listaPublicaciones = query.getResultList();
            for (Anclado posts : listaPublicaciones) {
                em.refresh(posts);
            }
            em.getTransaction().commit();
            return listaPublicaciones;
        } catch (PersistenciaException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al buscar el post: ", e);
        } finally {
            em.close();
        }
    }

    @Override
    public Anclado eliminarPostAnclado(Anclado postAnclado) throws PersistenceException {
        EntityManager em = emf.createEntityManager();
        try {
            if (postAnclado == null) {
                throw new PersistenceException("No hay información del post");
            }
            em.getTransaction().begin();
            Post postMarged = em.merge(postAnclado);
            em.remove(postMarged);
            em.getTransaction().commit();
        } catch (TransactionRequiredException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo eliminar el post.", e.getCause());
        } catch (RollbackException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Hubo un error de commit.", e.getCause());
        } catch (IllegalArgumentException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        } finally {
            em.close();
        }
        return postAnclado;
    }

    @Override
    public Comun eliminarPostComun(Comun postComun) throws PersistenceException {
        EntityManager em = emf.createEntityManager();
        try {
            if (postComun == null) {
                throw new PersistenceException("No hay información del post");
            }
            em.getTransaction().begin();
            Post managedPostComun = em.merge(postComun);
            em.remove(managedPostComun);
            em.getTransaction().commit();
        } catch (TransactionRequiredException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("No se pudo eliminar el post.", e.getCause());
        } catch (IllegalArgumentException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException(e.getMessage());
        } finally {
            em.close();
        }
        return postComun;
    }
    
    public List<Post> buscadorPost(String busqueda) throws PersistenceException{
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();

            CriteriaQuery<Post> criteria = builder.createQuery(Post.class);

            Root<Post> posts = criteria.from(Post.class);

            criteria.select(posts)
                    .where(
                            builder.like(posts.get("titulo"), "%" + busqueda + "%")
                    );
            criteria.orderBy(builder.desc(posts.get("fechaCreacion")));

            TypedQuery<Post> query = em.createQuery(criteria);

            List<Post> listaPublicaciones = query.getResultList();
            for (Post listaPublicacione : listaPublicaciones) {
                em.refresh(listaPublicacione);
            }
            em.getTransaction().commit();
            return listaPublicaciones;
        } catch (PersistenciaException e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error al buscar el post: ", e);
        } finally {
            em.close();
        }
    }

}
