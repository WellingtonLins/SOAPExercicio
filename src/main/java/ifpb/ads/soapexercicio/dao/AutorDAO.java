package ifpb.ads.soapexercicio.dao;


import ifpb.ads.soapexercicio.model.Autor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;

/**
 * Document ClienteDAO
 *
 * @Date 25/04/2016 @Time 18:50:38
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
public class AutorDAO  {

    public AutorDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Autor autor) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(autor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Autor autor) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            autor = em.merge(autor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = autor.getId();
                if (findCliente(id) == null) {
                    throw new Exception("The autor with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(long id) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
           Autor autor;
            try {
                autor = em.getReference(Autor.class, id);
                autor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new Exception("The autor with id " + id + " no longer exists.", enfe);
            }
            em.remove(autor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }




    public Autor findCliente(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Autor.class, id);
        } finally {
            em.close();
        }
    }



    public Autor selecionarPorEmail(String email) {
        EntityManager em = getEntityManager();

        try {
            return (Autor) em.createNamedQuery("Autor.consultarPorEmail")
                    .setParameter("email", email)
                    .getSingleResult();

        } finally {
            em.close();
        }
    }

    public List<Autor> findAll() {
        EntityManager em = getEntityManager();

        try {
            return em.createNamedQuery("Autor.consultarTodos").getResultList();

        } finally {
            em.close();
        }
    }

}
