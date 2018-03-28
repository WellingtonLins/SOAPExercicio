package ifpb.ads.soapexercicio.soap;

import ifpb.ads.soapexercicio.model.Autor;
import ifpb.ads.soapexercicio.servico.AutorServico;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author wellington
 */
@WebService
public class AutorServiceSOAP {

    AutorServico autorServico = new AutorServico();
    
    @WebMethod(operationName = "salvarAutor")
    public void salvarAutor(@WebParam(name = "autor") Autor autor) {
       autorServico.create(autor);
    }
    
}

// /Users/job/Documents/dev/testes/20172/pos-soap-jse/src/main/java
// wsimport -Xnocompile -keep -verbose http://localhost:8080/CalculadoraSOAPService/CalculadoraSOAP?wsdl

//http://localhost:8080/CalculadoraSOAPService/CalculadoraSOAP?wsdl
//http://localhost:8080/CalculadoraSOAPService/CalculadoraSOAP?tester
