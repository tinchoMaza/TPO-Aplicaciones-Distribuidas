package vista;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import delegado.BusinessDelegate;
import dto.ItemPedidoDTO;
import excepciones.ArticuloException;
import excepciones.ClienteException;
import excepciones.OrdenDePedidoException;
import excepciones.PedidoException;

public class TestGeneracion {

	public static void main(String[] args) {
	/*	try {
			BusinessDelegate.getInstancia().cargarTodasUbicacionesYArticulos();
		} catch (RemoteException e2) {
			e2.printStackTrace();
		}*/
		/****ALTA PEDIDO CON ITEMS QUE EXISTA STOCK DE TODO****/
		
		List<ItemPedidoDTO> misItems = new ArrayList<ItemPedidoDTO>();
		ItemPedidoDTO item = new ItemPedidoDTO ();
		try {
			item.setArticulo(BusinessDelegate.getInstancia().buscarArticuloById(1));
			item.setCant(30);
			misItems.add(item);
			try {
				BusinessDelegate.getInstancia().altaPedido(misItems, "PENDIENTE", BusinessDelegate.getInstancia().buscarClienteByCuit(23126864), "FormaDePago", "Calle", 123, "Localidad", 1838);
				System.out.println("pedido ok");
			} catch (RemoteException e) {
				System.out.println(e.getMessage());
			} catch (PedidoException e) {
				System.out.println(e.getMessage());
			} catch (ClienteException e) {
				System.out.println(e.getMessage());
			} catch (ArticuloException e) {
				System.out.println(e.getMessage());
			} catch (OrdenDePedidoException e) {
				System.out.println(e.getMessage());
			}
		} catch (RemoteException | ArticuloException e1) {
			System.out.println(e1.getMessage());
		}

		
		


		
		/****ALTA PEDIDO CON ITEMS QUE FALTE 1 o 2 PRODUCTOS****/
		
		/*List<ItemPedidoDTO> misItems2 = new ArrayList<ItemPedidoDTO>();
		ItemPedidoDTO item2 = new ItemPedidoDTO ();
		try {
			item2.setArticulo(BusinessDelegate.getInstancia().buscarArticuloById(13)); //Hay 0
		} catch (RemoteException | ArticuloException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		item2.setCant(1);
		misItems2.add(item2);
		try {
			BusinessDelegate.getInstancia().altaPedido(misItems2, "String", BusinessDelegate.getInstancia().buscarClienteByCuit(23126864), "FormaDePago", "Calle", 123, "Localidad", 1838);
		} catch (ClienteException | ArticuloException | RemoteException | PedidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/****ALTA PEDIDO CON ITEMS QUE UNO SEA EL QUE SE PIDIO ANTES****/
		
		/*List<ItemPedidoDTO> misItems3 = new ArrayList<ItemPedidoDTO>();
		ItemPedidoDTO item3 = new ItemPedidoDTO ();
		try {
			item3.setArticulo(BusinessDelegate.getInstancia().buscarArticuloById(13)); //Hay 0 y ademas el anterior ya pidio uno
		} catch (RemoteException | ArticuloException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		item3.setCant(1);
		misItems3.add(item3);
		try {
			BusinessDelegate.getInstancia().altaPedido(misItems3, "String", BusinessDelegate.getInstancia().buscarClienteByCuit(23126864), "FormaDePago", "Calle", 123, "Localidad", 1838);
		} catch (ClienteException | ArticuloException | RemoteException | PedidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
		/****ALTA MOVIMIENTO****/
		
		//no esta implementado
		

	}

}
