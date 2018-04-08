package ifpb.ads.soapexercicio.dao;

import ifpb.ads.soapexercicio.model.Autor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
@Stateless
public class AutorDAO {

    @PersistenceContext(unitName = "Autor_PU")
    private EntityManager em;

    public void create(Autor autor) {

        em.persist(autor);

    }

    public void edit(Autor autor) {

        autor = em.merge(autor);

    }

    public void destroy(long id) {

        Autor autor = em.getReference(Autor.class, id);
        em.remove(autor);
   
    }

    public Autor findCliente(long id) {

        return em.find(Autor.class, id);

    }

    public Autor selecionarPorEmail(String email) {

        return (Autor) em.createNamedQuery("Autor.consultarPorEmail")
                .setParameter("email", email)
                .getSingleResult();

    }

    public List<Autor> findAll() {

        return em.createNamedQuery("Autor.consultarTodos").getResultList();

    }
}
