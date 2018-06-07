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


	public void save(Remito remito) throws RemitoException{
		if (remito != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.save(remito.toEntity());
			s.getTransaction().commit();
			s.close();
		}else{
			throw new RemitoException("Error al buscar pedido en la BD");
		}
	}

	public void update(Remito remito) throws RemitoException{
		if (remito != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.update(remito.toEntity());
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
			s.delete(remito.toEntity());
			s.getTransaction().commit();
			s.close();
		}else{
			throw new RemitoException("Error al buscar pedido en la BD");
		}
	}


}
