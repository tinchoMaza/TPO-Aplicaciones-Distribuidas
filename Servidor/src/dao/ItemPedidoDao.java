package dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import excepciones.PedidoException;
import hibernate.HibernateUtil;
import negocio.ItemPedido;

public class ItemPedidoDao {

	private static ItemPedidoDao instancia;
	private static SessionFactory sf = null;

	public static ItemPedidoDao getInstancia(){
		if (instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ItemPedidoDao();
		}	
		return instancia;
	}

	public void save(ItemPedido itemPedido) throws PedidoException{
		if (itemPedido != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.save(itemPedido.toEntity());
			s.getTransaction().commit();
			s.close();
		}else{
			throw new PedidoException("Error al guardar un item de pedido en la BD");
		}
	}

	public void update(ItemPedido itemPedido) throws PedidoException {
		if (itemPedido != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.update(itemPedido.toEntity());
			s.getTransaction().commit();
			s.close();
		}else{
			throw new PedidoException("Error al actualizar un item de pedido en la BD");
		}
	}


	public void delete(ItemPedido itemPedido) throws PedidoException {
		if (itemPedido != null){
			Session session = sf.openSession();
			session.beginTransaction();
			session.delete(itemPedido.toEntity());
			session.flush();
			session.getTransaction().commit();
			session.close();
		} else{
			throw new PedidoException("Error en el borrado de un item de pedido en la BD");
		}	
	}

}
