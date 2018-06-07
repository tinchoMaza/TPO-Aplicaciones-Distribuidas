package vista;

import java.rmi.RemoteException;
import java.util.List;

import delegado.BusinessDelegate;
import dto.ClienteDTO;
import excepciones.ArticuloException;
import excepciones.ClienteException;
import excepciones.OrdenDePedidoException;
import dto.UbicacionDTO;


public class Test1 {
	public static void main(String[] args) {

		/****BUSCA UN CLIENTE****/

		/*ClienteDTO cliente;
		try {
			cliente = BusinessDelegate.getInstancia().buscarClienteByCuit(23126864);
			System.out.println("El nombre del cliente es "+ cliente.getNombre());
		} catch (ClienteException e) {
			System.out.println(e.getMessage());
		} catch (RemoteException e) {
			e.printStackTrace();
		} */


		/****BUSCA UN ARTICULO****/

		/*ArticuloDTO articulo;
		try {
			articulo = BusinessDelegate.getInstancia().buscarArticuloById(27);
			System.out.println("El nombre del articulo es" + articulo.getDescripcion());
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (ArticuloException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}*/


		/****CARGA LAS UBICACIONES Y LOS ARTICULOS****/
		/****DEBERIA HACERSE EN EL SERVER DESPUES DEL NEW SERVER() O NO??****/
		/*try {
			BusinessDelegate.getInstancia().cargarTodasUbicacionesYArticulos();
			List<UbicacionDTO> u = BusinessDelegate.getInstancia().getUbicaciones();
			for (UbicacionDTO ubicacion : u){
				System.out.println(ubicacion.getIdUbicacion());
				System.out.println(ubicacion.getArticulos().size());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
