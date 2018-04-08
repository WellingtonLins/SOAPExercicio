package ifpb.ads.soapexercicio.soap;

import ifpb.ads.soapexercicio.model.Livro;
import ifpb.ads.soapexercicio.servico.LivroServico;
import java.util.List;
import javax.inject.Inject;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author wellington
 */
@WebService
public class LivroServiceSOAP {

    @Inject
    private LivroServico livroServico;
    
    @Oneway
    @WebMethod(operationName = "salvarLivro")
    public void salvarLivro(@WebParam(name = "livro") Livro livro) {
        livroServico.create(livro);
    }

    @Oneway
    @WebMethod(operationName = "editarLivro")
    public void edit(@WebParam(name = "livro") Livro livro) {
        livroServico.edit(livro);
    }

    @Oneway
    @WebMethod(operationName = "deletarLivro")
    public void destroy(@WebParam(name = "id") Long id) {
        livroServico.destroy(id);
    }

    @WebMethod(operationName = "buscarLivroPorId")
    public Livro findLivroById(@WebParam(name = "id") Long id) {
        return livroServico.findLivroById(id);
    }

    @WebMethod(operationName = "buscarLivroPorTitulo")
    public Livro findByTitle(@WebParam(name = "titulo") String titulo) {
        return livroServico.findLivroByTitle(titulo);
    }

    @WebMethod(operationName = "buscarTodosLivros")
    public List<Livro> buscarTodosLivros() {
        return livroServico.findAll();
    }
}
