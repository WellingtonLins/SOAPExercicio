package ifpb.ads.soapexercicio.soap;

import ifpb.ads.soapexercicio.model.Autor;
import ifpb.ads.soapexercicio.servico.AutorServico;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author wellington
 */
@WebService
public class AutorServiceSOAP {

    @Inject
    private AutorServico autorServico;

    @WebMethod(operationName = "salvarAutor")
    public void salvarAutor(@WebParam(name = "autor") Autor autor) {
        autorServico.create(autor);
    }

    @WebMethod(operationName = "destruirAutor")
    public void destruirAutor(@WebParam(name = "id") Long id) {
        autorServico.destroy(id);
    }

    @WebMethod(operationName = "buscarAutorPorId")
    public Autor buscarAutorPorId(@WebParam(name = "id") Long id) {
        return autorServico.findAutorById(id);
    }

    @WebMethod(operationName = "editarAutor")
    public void editarAutor(@WebParam(name = "autor") Autor autor) {
        autorServico.edit(autor);
    }
}

// /Users/job/Documents/dev/testes/20172/pos-soap-jse/src/main/java
// wsimport -Xnocompile -keep -verbose http://localhost:8080/SoapExercicio/AutorServiceSOAPService?wsdl
//http://localhost:8080/CalculadoraSOAPService/CalculadoraSOAP?wsdl
//http://localhost:8080/CalculadoraSOAPService/CalculadoraSOAP?tester
