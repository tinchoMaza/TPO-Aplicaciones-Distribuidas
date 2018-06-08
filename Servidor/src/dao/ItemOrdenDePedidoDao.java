package dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import excepciones.PedidoException;
import hibernate.HibernateUtil;
import negocio.ItemOrdenDePedido;

public class ItemOrdenDePedidoDao {

	private static ItemOrdenDePedidoDao instancia;
	private static SessionFactory sf = null;

	public static ItemOrdenDePedidoDao getInstancia(){
		if (instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ItemOrdenDePedidoDao();
		}	
		return instancia;
	}

	public void save(ItemOrdenDePedido itemOP) throws PedidoException{
		if (itemOP != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.save(itemOP.toEntity());
			s.flush();
			s.getTransaction().commit();
			s.close();
		}else{
			throw new PedidoException("Error al guardar un item de pedido en la BD");
		}
	}
}