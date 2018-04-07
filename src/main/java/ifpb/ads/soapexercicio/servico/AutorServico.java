package ifpb.ads.soapexercicio.servico;

import ifpb.ads.soapexercicio.model.Autor;
import ifpb.ads.soapexercicio.dao.AutorDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Document ClienteDAO
 *
 * @Date 25/04/2016 @Time 18:50:38
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
@Stateless
public class AutorServico {

    @Inject
    private AutorDAO autorDAO;

    public void create(Autor autor) {
        autorDAO.create(autor);
    }

    public void edit(Autor autor)  {
        autorDAO.edit(autor);
    }

    public void destroy(long id) {
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
