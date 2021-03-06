package dao;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import excepciones.OrdenDeCompraException;
import hibernate.HibernateUtil;
import negocio.ItemOrdenDeCompra;

public class ItemOrdenDeCompraDao {

	private static ItemOrdenDeCompraDao instancia;
	private static SessionFactory sf = null;

	public static ItemOrdenDeCompraDao getInstancia(){
		if (instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ItemOrdenDeCompraDao();
		}	
		return instancia;
	}

	public int save(ItemOrdenDeCompra itemCompra) throws OrdenDeCompraException{
		if (itemCompra != null){
			Session s = sf.openSession();
			s.beginTransaction();
			int id = (Integer) s.save(itemCompra.toEntitySave());
			s.flush();
			s.getTransaction().commit();
			s.close();
			return id;
		}else{
			throw new OrdenDeCompraException("Error al guardar un item de orden de compra en la BD");
		}
	}

	public void update(ItemOrdenDeCompra itemCompra) throws OrdenDeCompraException {
		if (itemCompra != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.update(itemCompra.toEntityUpdate());
			s.getTransaction().commit();
			s.close();
		}else{
			throw new OrdenDeCompraException("Error al actualizar un item de orden de compra en la BD");
		}
	}


	public void delete(ItemOrdenDeCompra itemCompra) throws OrdenDeCompraException {
		if (itemCompra != null){
			Session session = sf.openSession();
			session.beginTransaction();
			session.delete(itemCompra.toEntityUpdate());
			session.flush();
			session.getTransaction().commit();
			session.close();
		} else {
			throw new OrdenDeCompraException("Error en el borrado de un item de orden de compra en la BD");
		}	
	}

}
