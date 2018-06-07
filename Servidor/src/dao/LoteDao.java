package dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import excepciones.LoteException;
import hibernate.HibernateUtil;
import negocio.Lote;

public class LoteDao {

	private static LoteDao instancia;
	private static SessionFactory sf = null;

	public static LoteDao getInstancia(){
		if (instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new LoteDao();
		}	
		return instancia;
	}

	public void save(Lote lote) throws LoteException{
		if (lote != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.save(lote.toEntity());
			s.getTransaction().commit();
			s.close();
		}else{
			throw new LoteException("Error al guardar un lote en la BD");
		}
	}

	public void update(Lote lote) throws LoteException  {
		if (lote != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.update(lote.toEntity());
			s.getTransaction().commit();
			s.close();
		}else{
			throw new LoteException("Error al actualizar un lote en la BD");
		}
	}


	public void delete(Lote lote) throws LoteException  {
		if (lote != null){
			Session session = sf.openSession();
			session.beginTransaction();
			session.delete(lote.toEntity());
			session.flush();
			session.getTransaction().commit();
			session.close();
		} else {
			throw new LoteException("Error en el borrado de un lote en la BD");
		}	
	}

}
