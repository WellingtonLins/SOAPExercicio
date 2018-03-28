package ifpb.ads.soapexercicio;

import ifpb.ads.soapexercicio.model.Autor;
import ifpb.ads.soapexercicio.dao.AutorDAO;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author wellington
 */
public class Principal {

    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Soap_PU");

        AutorDAO cjc = new AutorDAO(emf);
        criarAutores(cjc);

    }

    private static void criarAutores(AutorDAO autorDao) {
        Autor autor = new Autor("Caio Gomes", "caio@gmail.com", "CG");
        Autor autor2 = new Autor("Maria Leidiane", "maria@gmail.com", "ML");

        autorDao.create(autor);
        autorDao.create(autor2);
    }

}
