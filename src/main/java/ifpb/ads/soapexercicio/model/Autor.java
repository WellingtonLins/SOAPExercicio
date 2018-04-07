package ifpb.ads.soapexercicio.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wellington
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autor.consultarTodos", query = "SELECT a FROM Autor a"),
            @NamedQuery(name = "Autor.consultarPorId", query = "SELECT a FROM Autor a WHERE a.id = :id"),
            @NamedQuery(name = "Autor.consultarPorNome",query = "SELECT  a FROM Autor a WHERE a.nome = :nome"),
            @NamedQuery(name = "Autor.consultarPorEmail",query = "SELECT  a FROM Autor a WHERE a.email = :email")})
public class Autor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;
    private String abreviacao;

    public Autor() {
    }

    public Autor(String nome, String email, String abreviacao) {
        this.nome = nome;
        this.email = email;
        this.abreviacao = abreviacao;
    }

    public Autor(Long id, String nome, String email, String abreviacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.abreviacao = abreviacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", abreviacao=" + abreviacao + '}';
    }

}
