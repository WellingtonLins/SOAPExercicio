package ifpb.ads.soapexercicio.dao;


import ifpb.ads.soapexercicio.model.Reserva;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
@Stateless
public class ReservaDAO {

     @PersistenceContext(unitName = "Autor_PU")
    private EntityManager em;

    public void create(Reserva reserva) {
        em.persist(reserva);
    }

    public void edit(Reserva reserva) {
        reserva = em.merge(reserva);     
    }

    public void destroy(long id) {
        Reserva reserva = em.getReference(Reserva.class, id);
        em.remove(reserva);

    }

    public void destroy(Reserva reserva) {
        em.getReference(Reserva.class, reserva.getId());
        em.remove(reserva);

        System.out.println("Reserva destruida com sucesso");
    }

    public Reserva findReserva(long id) {

        return em.find(Reserva.class, id);

    }

    public Reserva selecionarPorId(Long id) {

        return (Reserva) em.createNamedQuery("Reserva.consultarPorId")
                .setParameter("id", id)
                .getSingleResult();

    }

    public Reserva selecionarPorUsuario(String usuario) {

        return (Reserva) em.createNamedQuery("Reserva.consultarPorUsuario")
                .setParameter("usuario", usuario)
                .getSingleResult();

    }

    public List<Reserva> findAll() {

        return em.createNamedQuery("Reserva.consultarTodas").getResultList();

    }
}
