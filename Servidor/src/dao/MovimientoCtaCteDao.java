package dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;


import entities.MovimientoCtaCteEntity;
import excepciones.CuentaCorrienteException;
import hibernate.HibernateUtil;
import negocio.MovimientoCtaCte;

public class MovimientoCtaCteDao {

	private static MovimientoCtaCteDao instancia = null;
	private static SessionFactory sf = null;

	public static MovimientoCtaCteDao getInstancia() {
		if(instancia==null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new MovimientoCtaCteDao();
		}
		return instancia;
	}

	public void save(MovimientoCtaCte m) throws CuentaCorrienteException{
		if (m != null){
			MovimientoCtaCteEntity mov = m.toEntity();
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(mov);
			session.flush();
			session.getTransaction().commit();
			session.close();
		}else{
			throw new CuentaCorrienteException("Error en el guardado de un movimiento de cuenta corriente");
		}

	}


	public void update(MovimientoCtaCte m) throws CuentaCorrienteException{
		if (m != null){
			MovimientoCtaCteEntity mov = m.toEntity();
			Session session = sf.openSession();
			session.beginTransaction();
			session.update(mov);
			session.flush();
			session.getTransaction().commit();
			session.close();
		}else{
			throw new CuentaCorrienteException("Error al actualizar un movimiento de cuenta corriente");
		}
	}

	public void delete(MovimientoCtaCte m) throws CuentaCorrienteException{
		if (m != null){
			MovimientoCtaCteEntity mov = m.toEntity();
			Session session = sf.openSession();
			session.beginTransaction();
			session.delete(mov);
			session.flush();
			session.getTransaction().commit();
			session.close();
		}else{
			throw new CuentaCorrienteException("Error al borrar un movimiento de cuenta corriente");
		}
	}

}
