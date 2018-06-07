package controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import excepciones.ArticuloException;
import excepciones.LoteException;
import excepciones.OrdenDeCompraException;
import excepciones.PedidoException;
import excepciones.UbicacionException;
import negocio.Articulo;
import negocio.ArticuloDeposito;
import negocio.ItemOrdenDeCompra;
import negocio.ItemOrdenDePedido;
import negocio.Lote;
import negocio.OrdenDeCompra;
import negocio.OrdenDePedido;
import negocio.Proveedor;

public class ControladorCompras {

	private List<OrdenDeCompra> misOC;

	public OrdenDeCompra buscarOrdenDeCompraById(int idOC){
		return null;
	}
	public void emitirOC(OrdenDePedido op, Proveedor prov, List<ItemOrdenDePedido> articulosAPedir) throws ArticuloException, OrdenDeCompraException{
		OrdenDeCompra oc = new OrdenDeCompra();
		oc.setEstado("PENDIENTE");
		oc.setOrdenPedido(op);
		oc.setProv(prov);
		for (ItemOrdenDePedido item : articulosAPedir) {
			//el 1 es el idItem, deberia autogenerarse
			ItemOrdenDeCompra itemOC = new ItemOrdenDeCompra(oc, 1, item.getArticulo(), item.getCant(), item.getArticulo().getPrecioVentaUnitario());
			oc.nuevoItemOC(itemOC);
		}
		this.misOC.add(oc);
		oc.save();
	}
	public List<OrdenDeCompra> buscarByEstado(String estado){
		return misOC;
	}
	public void actualizarEstado(OrdenDeCompra oc, String estado){

	}
	public List<Proveedor> busarUltimosTres(OrdenDeCompra oc){
		return null;
	}

	public void procesarOC(OrdenDeCompra oc) throws PedidoException, SQLException, ArticuloException, LoteException, OrdenDeCompraException, UbicacionException {
		Lote loteRandom=null;
		oc.setEstado("COMPLETADA");
		//Cambio en memoria
		for(OrdenDeCompra miOc : misOC) {
			if(miOc.getIdOc() == oc.getIdOc()) {
				miOc.setEstado("COMPLETADA");
				break;
			}
		}
		oc.update();
		List<ArticuloDeposito> articulosRecibidos = new ArrayList<ArticuloDeposito>();
		//seteo por defecto que el lote vence en 180 dias
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 180);
		Date fechaLote = c.getTime();
		for (ItemOrdenDeCompra item : oc.getItems()) {
			loteRandom=generarLote(fechaLote);
			//Crear funcion que genere un lote random
			for (int cant = item.getCantidad() ; cant > 0 ; cant--)
				articulosRecibidos.add(new ArticuloDeposito(item.getArticulo(), loteRandom));
		}		
		ControladorDeposito.getInstancia().ubicar(articulosRecibidos);
		ControladorDeposito.getInstancia().completarPedido(oc.getOrdenPedido().getPedido());
	}
	
	
	private Lote generarLote(Date fechaLote) throws LoteException {
		int numero= (int) (Math.random() * 99999) + 10000;
		Lote lote = new Lote(numero,fechaLote);
		lote.save();
		return lote;
	}
}
