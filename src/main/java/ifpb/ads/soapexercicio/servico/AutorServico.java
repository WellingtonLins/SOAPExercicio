package ifpb.ads.soapexercicio.servico;


import ifpb.ads.soapexercicio.model.Autor;
import ifpb.ads.soapexercicio.dao.AutorDAO;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Document ClienteDAO
 *
 * @Date 25/04/2016 @Time 18:50:38
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
public class AutorServico {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Soap_PU");
    private AutorDAO autorDAO = new AutorDAO(emf);

    public void create(Autor autor) {
            autorDAO.create(autor);
    }

    public void edit(Autor autor) throws Exception {
        autorDAO.edit(autor);
    }

    public void destroy(long id) throws Exception {
        autorDAO.destroy(id);
    }

    public Autor findAutorById(long id) {
        return autorDAO.findCliente(id);
    }

    public Autor findAutorByEmail(String email) {
        return autorDAO.selecionarPorEmail(email);
    }


      public List<Autor> findAll() {
       return autorDAO.findAll();
      }

}
