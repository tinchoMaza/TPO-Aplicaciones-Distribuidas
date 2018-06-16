package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import excepciones.RemitoException;
import hibernate.HibernateUtil;
import negocio.Remito;

public class RemitoDao {

	private static RemitoDao instancia;
	private static SessionFactory sf = null;

	public static RemitoDao getInstancia(){
		if (instancia == null)
			instancia = new RemitoDao();
		sf = HibernateUtil.getSessionFactory();
		return instancia;
	}


	public int save(Remito remito) throws RemitoException{
		if (remito != null){
			Session s = sf.openSession();
			s.beginTransaction();
			Integer id = (Integer) s.save(remito.toEntitySave());
			s.flush();
			s.getTransaction().commit();
			s.close();
			return id;
		}else{
			throw new RemitoException("Error al buscar pedido en la BD");
		}
	}

	public void update(Remito remito) throws RemitoException{
		if (remito != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.update(remito.toEntityUpdate());
			s.flush();
			s.getTransaction().commit();
			s.close();
		}else{
			throw new RemitoException("Error al buscar pedido en la BD");
		}
	}

	public void delete(Remito remito) throws RemitoException{
		if (remito != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.delete(remito.toEntityUpdate());
			s.getTransaction().commit();
			s.close();
		}else{
			throw new RemitoException("Error al buscar pedido en la BD");
		}
	}


}
