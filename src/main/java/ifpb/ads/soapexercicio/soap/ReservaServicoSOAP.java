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
public class ReservaServicoSOAP {

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
    @WebMethod(operationName = "editarReserva2")
    public void edit2(@WebParam(name = "usuario") String usuario,
            @WebParam(name = "titulo") String titulo) {

        reservaServico.edit(usuario, titulo);

    }

    @Oneway
    @WebMethod(operationName = "deletarReserva1")
    public void destroy1(@WebParam(name = "id") Long id) {

        reservaServico.destroy(id);
    }

    @Oneway
    @WebMethod(operationName = "deletarReserva2")
    public void destroy2(@WebParam(name = "reserva") Reserva reserva,
            @WebParam(name = "titulo") String titulo) {
        reservaServico.destroy(reserva, titulo);
    }

    @Oneway
    @WebMethod(operationName = "deletarReserva3")
    public void destroy3(@WebParam(name = "reserva") Reserva reserva) {
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
    public List<Reserva> findAll() {
        return reservaServico.findAll();
    }

}
