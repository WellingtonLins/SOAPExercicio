package ifpb.ads.soapexercicio.servico;

import ifpb.ads.soapexercicio.dao.LivroDAO;
import ifpb.ads.soapexercicio.model.Livro;
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
public class LivroServico {


@Inject
    private LivroDAO livroDAO;

    public void create(Livro autor) {
        livroDAO.create(autor);
    }

    public void edit(Livro livro) throws Exception {
        livroDAO.edit(livro);
    }

    public void destroy(long id) throws Exception {
        livroDAO.destroy(id);
    }

    public Livro findLivroById(long id) {
        return livroDAO.findLivro(id);
    }


    public List<Livro> findAll() {
        return livroDAO.findAll();
    }

}
