package dao;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
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

	public int save(ItemRemito itemRemito) throws RemitoException{
		if (itemRemito != null){
			Session s = sf.openSession();
			s.beginTransaction();
			int id = (Integer) s.save(itemRemito.toEntitySave());
			s.flush();
			s.getTransaction().commit();
			s.close();
			return id;
		}else{
			throw new RemitoException("Error al guardar un item de remito en la BD");
		}
	}

	public void update(ItemRemito itemRemito) throws RemitoException {
		if (itemRemito != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.update(itemRemito.toEntityUpdate());
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
			session.delete(itemRemito.toEntityUpdate());
			session.flush();
			session.getTransaction().commit();
			session.close();
		} else {
			throw new RemitoException("Error en el borrado de un item de remito en la BD");
		}	
	}

}
