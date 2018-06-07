package dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import dto.ArticuloDTO;
import entities.ClienteEntity;
import entities.OrdenDePedidoEntity;

import java.util.*;

import excepciones.ClienteException;
import excepciones.OrdenDePedidoException;
import hibernate.HibernateUtil;
import negocio.Articulo;
import negocio.Cliente;
import negocio.ItemOrdenDePedido;
import negocio.OrdenDePedido;

public class OrdenDePedidoDao {

	private static OrdenDePedidoDao instancia;
	private static SessionFactory sf = null;

	public static OrdenDePedidoDao getInstancia(){
		if (instancia == null)
			sf = HibernateUtil.getSessionFactory();
		instancia = new OrdenDePedidoDao();
		return instancia;
	}

	public void save(OrdenDePedido op) throws OrdenDePedidoException{
		if (op != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.save(op.toEntity());
			s.getTransaction().commit();
			s.close();
		}else{
			throw new OrdenDePedidoException("Error en el guardado de una orden de compra en la BD");
		}
	}

	public void update(OrdenDePedido op) throws OrdenDePedidoException{
		if (op != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.update(op.toEntity());
			s.getTransaction().commit();
			s.close();
		}else{
			throw new OrdenDePedidoException("Error en el guardado de una orden de compra en la BD");
		}
	}


	public void delete(OrdenDePedido op) throws OrdenDePedidoException{
		if (op != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.delete(op.toEntity());
			s.getTransaction().commit();
			s.close();
		}else{
			throw new OrdenDePedidoException("Error en el guardado de una orden de compra en la BD");
		}
	}
	
	public List<OrdenDePedido> cargarTodasOrdenPedido() throws OrdenDePedidoException{
		List<OrdenDePedido> ordenes = new ArrayList<OrdenDePedido>();
		Session session = sf.openSession();
		Query query = session.createQuery("select o from OrdenDePedidoEntity o");
		List<OrdenDePedidoEntity> ordenesEntity = query.list();
		if (ordenesEntity != null){
			for(OrdenDePedidoEntity oe : ordenesEntity)
				ordenes.add(oe.toNegocio());
			return ordenes;
		} else {
			throw new OrdenDePedidoException("Error al cargar Ordenes de Pedido de la BD");
		}
	}

	public boolean existeOrdenPedido(Articulo articulo) throws OrdenDePedidoException {
		boolean b = false;
		List<OrdenDePedido> ords = this.cargarTodasOrdenPedido();
		for (OrdenDePedido op : ords)
			for (ItemOrdenDePedido item : op.getArticulos())
				if (item.getArticulo().getIdArticulo() == articulo.getIdArticulo())
					b = true;
		return b;
	}



}
