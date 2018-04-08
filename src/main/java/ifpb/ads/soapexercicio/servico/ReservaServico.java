package ifpb.ads.soapexercicio.servico;

import ifpb.ads.soapexercicio.dao.ReservaDAO;
import ifpb.ads.soapexercicio.model.Livro;
import ifpb.ads.soapexercicio.model.Reserva;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Document ClienteDAO
 *
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
@Stateless
public class ReservaServico {

    @Inject
    private ReservaDAO reservaDAO;

    @Inject
    private LivroServico livroServico;

    public void create(Reserva reserva, String tituloLivro) {

        Livro livro = livroServico.findLivroByTitle(tituloLivro);

        if (livro.isDisponivel() == Boolean.TRUE) {
            livro.setDisponivel(Boolean.FALSE);
            livroServico.edit(livro);
            reserva.getLivros().add(livro);
            reservaDAO.create(reserva);
        } else {
            System.out.println("Já alocado");
        }

    }

    public void edit(Reserva reserva) {

        reservaDAO.edit(reserva);
    }

    public void edit(String usuario, String titulo) {

        Reserva reserva = findReservaByUser(usuario);

        Livro livroBuscado = livroServico.findLivroByTitle(titulo);

        List<Livro> livros = reserva.getLivros();

        livros.add(livroBuscado);

        if (livroBuscado != null) {
            livroBuscado.setDisponivel(Boolean.FALSE);
            livroServico.edit(livroBuscado);
        }
        reservaDAO.edit(reserva);
    }

    public void destroy(long id) {
  
        Reserva reserva = reservaDAO.findReserva(id);
        
        List<Livro> livros = reserva.getLivros();

        for (Livro livro : livros) {
            livro.setDisponivel(Boolean.TRUE);
            livroServico.edit(livro);
        }
        reservaDAO.destroy(id);
    }

    public void destroy(Reserva reserva, String titulo) {
      
        List<Livro> livros = reserva.getLivros();
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo)) {
                reserva.getLivros().remove(livro);
                livro.setDisponivel(Boolean.TRUE);
                livroServico.edit(livro);

            }
        reservaDAO.edit(reserva);
        }

    }

    public void destroy(Reserva reserva) {
      
        List<Livro> livros = reserva.getLivros();

        for (Livro livro : livros) {
            livro.setDisponivel(Boolean.TRUE);
            livroServico.edit(livro);
        }
        reservaDAO.destroy(reserva);
    }

    public Reserva findReservaById(long id) {
        return reservaDAO.findReserva(id);
    }

    public Reserva findReservaByUser(String usuario) {
        return reservaDAO.selecionarPorUsuario(usuario);
    }

    public List<Reserva> findAll() {
        return reservaDAO.findAll();
    }

}