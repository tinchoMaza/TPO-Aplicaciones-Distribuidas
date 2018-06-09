package dao;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
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

	public int save(ItemOrdenDePedido itemOP) throws PedidoException{
		if (itemOP != null){
			Session s = sf.openSession();
			s.beginTransaction();
			int id = (Integer) s.save(itemOP.toEntitySave());
			s.flush();
			s.getTransaction().commit();
			s.close();
			return id;
		}else{
			throw new PedidoException("Error al guardar un item de pedido en la BD");
		}
	}
}