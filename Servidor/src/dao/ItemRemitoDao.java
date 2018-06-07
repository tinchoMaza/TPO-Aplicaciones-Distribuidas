package dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import excepciones.RemitoException;
import hibernate.HibernateUtil;
import negocio.ItemRemito;

public class ItemRemitoDao {

	private static ItemRemitoDao instancia;
	private static SessionFactory sf = null;

	public static ItemRemitoDao getInstancia(){
		if (instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ItemRemitoDao();
		}	
		return instancia;
	}

	public void save(ItemRemito itemRemito) throws RemitoException{
		if (itemRemito != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.save(itemRemito.toEntity());
			s.getTransaction().commit();
			s.close();
		}else{
			throw new RemitoException("Error al guardar un item de remito en la BD");
		}
	}

	public void update(ItemRemito itemRemito) throws RemitoException {
		if (itemRemito != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.update(itemRemito.toEntity());
			s.getTransaction().commit();
			s.close();
		}else{
			throw new RemitoException("Error al actualizar un item de remito en la BD");
		}
	}


	public void delete(ItemRemito itemRemito) throws RemitoException {
		if (itemRemito != null){
			Session session = sf.openSession();
			session.beginTransaction();
			session.delete(itemRemito.toEntity());
			session.flush();
			session.getTransaction().commit();
			session.close();
		} else {
			throw new RemitoException("Error en el borrado de un item de remito en la BD");
		}	
	}

}
