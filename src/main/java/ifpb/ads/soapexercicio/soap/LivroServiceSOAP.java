package ifpb.ads.soapexercicio.soap;

import ifpb.ads.soapexercicio.model.Livro;
import ifpb.ads.soapexercicio.servico.LivroServico;
import javax.inject.Inject;
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

    @WebMethod(operationName = "salvarLivro")
    public void salvarLivro(@WebParam(name = "livro") Livro livro) {
        livroServico.create(livro);
    }

}
