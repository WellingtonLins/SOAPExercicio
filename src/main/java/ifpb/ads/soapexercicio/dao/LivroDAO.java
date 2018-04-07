package ifpb.ads.soapexercicio.dao;

import ifpb.ads.soapexercicio.model.Autor;
import ifpb.ads.soapexercicio.model.Livro;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
@Stateless
public class LivroDAO {

    @PersistenceContext(unitName = "Autor_PU")
    private EntityManager em;

    public void create(Livro livro) {

        em.persist(livro);

    }

    public void edit(Livro livro) throws Exception {

        livro = em.merge(livro);

    }

    public void destroy(long id) throws Exception {

        Livro livro = em.getReference(Livro.class, id);

        em.remove(livro);


    }

    public Livro findLivro(long id) {

        return em.find(Livro.class, id);

    }

    public Livro selecionarPorId(Long id) {

        return (Livro) em.createNamedQuery("Livro.consultarPorId")
                .setParameter("id", id)
                .getSingleResult();

    }

    public List<Livro> findAll() {

        return em.createNamedQuery("Livro.consultarTodos").getResultList();

    }
}
