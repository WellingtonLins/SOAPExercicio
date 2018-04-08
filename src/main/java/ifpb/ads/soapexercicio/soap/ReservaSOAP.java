package ifpb.ads.soapexercicio.soap;

import ifpb.ads.soapexercicio.model.Reserva;
import ifpb.ads.soapexercicio.servico.ReservaServico;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.Oneway;
import javax.jws.WebService;

/**
 * Document ClienteDAO
 *
 * @author Wellington Lins Claudino Duarte
 * @mail wellingtonlins2013@gmail.com
 */
@WebService
@Stateless
public class ReservaSOAP {

    @Inject
    private ReservaServico reservaServico;

    @Oneway
    @WebMethod(operationName = "salvarReserva")
    public void create(@WebParam(name = "reserva") Reserva reserva,
            @WebParam(name = "tituloLivro") String tituloLivro) {

        reservaServico.create(reserva, tituloLivro);

    }

    @Oneway
    @WebMethod(operationName = "editarReserva1")
    public void edit1(@WebParam(name = "reserva") Reserva reserva) {

        reservaServico.edit(reserva);
    }

    @Oneway
    @WebMethod(operationName = "editarReservaByUserAndTitle")
    public void editarReservaByUserAndTitle(@WebParam(name = "usuario") String usuario,
            @WebParam(name = "titulo") String titulo) {

        reservaServico.edit(usuario, titulo);

    }

    @Oneway
    @WebMethod(operationName = "destroyReservaByID")
    public void destroyReservaByID(@WebParam(name = "id") Long id) {

        reservaServico.destroy(id);
    }

    @Oneway
    @WebMethod(operationName = "destroyJustOneReservaFromUser")
    public void destroyJustOneReservaFromUser(@WebParam(name = "reserva") Reserva reserva,
            @WebParam(name = "titulo") String titulo) {
        reservaServico.destroy(reserva, titulo);
    }

    @Oneway
    @WebMethod(operationName = "destroyReserva")
    public void destroyReserva(@WebParam(name = "reserva") Reserva reserva) {
        reservaServico.destroy(reserva);
    }

    @WebMethod(operationName = "buscarReservaPorId")
    public Reserva findReservaById(@WebParam(name = "id") Long id) {
        return reservaServico.findReservaById(id);
    }

    @WebMethod(operationName = "buscarReservaPorUsuario")
    public Reserva findReservaByUser(@WebParam(name = "usuario") String usuario) {
        return reservaServico.findReservaByUser(usuario);
    }

    @WebMethod(operationName = "buscarTodasReservas")
    public List<Reserva> buscarTodasReservas() {
        return reservaServico.findAll();
    }

}
