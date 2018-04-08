package ifpb.ads.soapexercicio.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author wellington
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.consultarTodas", query = "SELECT r FROM Reserva r"),
            @NamedQuery(name = "Reserva.consultarPorId", query = "SELECT r FROM Reserva r WHERE r.id = :id"),
            @NamedQuery(name = "Reserva.consultarPorUsuario", query = "SELECT r FROM Reserva r WHERE r.usuario = :usuario")})
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String usuario;
    
 
    private LocalDate dataReserva;
    

    @OneToMany(fetch = FetchType.EAGER)
    private List<Livro> livros;

    public Reserva() {
        livros = new ArrayList();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

        @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }
    
    
    
    
    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public void addLivro(Livro livro) {
        livros.add(livro);
    }

    public void removeLivro(Livro livro) {
        livros.remove(livro);
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", usuario=" + usuario + ", livros=" + livros + '}';
    }


    

}