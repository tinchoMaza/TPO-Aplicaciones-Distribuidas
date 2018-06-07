package dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import entities.CuentaCorrienteEntity;
import excepciones.CuentaCorrienteException;
import hibernate.HibernateUtil;

import negocio.CuentaCorriente;

public class CuentaCorrienteDao {

	private static CuentaCorrienteDao instancia = null;
	private static SessionFactory sf = null;

	public static CuentaCorrienteDao getInstancia() {
		if(instancia==null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new CuentaCorrienteDao();
		}
		return instancia;
	}

	public void save(CuentaCorriente cuentaCorriente) throws CuentaCorrienteException{
		if (cuentaCorriente!=null){
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(cuentaCorriente);
			session.flush();
			session.getTransaction().commit();
			session.close();
		}
		else{
			throw new CuentaCorrienteException("Error en el guardado de la cuenta corriente");
		}
	}

	public void update(CuentaCorriente cuentaCorriente) throws CuentaCorrienteException {
		if (cuentaCorriente!=null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.update(cuentaCorriente.toEntity());
			s.getTransaction().commit();
			s.close();
		}
		else{
			throw new CuentaCorrienteException("Error al actualizar la cuenta corriente");
		}
	}


	public CuentaCorrienteEntity getCuentaCorrienteByCuit(int cuit) throws CuentaCorrienteException   {
		CuentaCorrienteEntity cc = null;
		Session session = sf.openSession();
		Query query = session.createQuery("select t from ClienteEntity c inner join CuentaCorrienteEntity t on c.cuentaCorriente = t.idCuentaCorriente where c.cuit=?");
		query.setParameter(0, cuit);
		cc = (CuentaCorrienteEntity) query.uniqueResult();
		if (cc!=null)
			throw new CuentaCorrienteException("Error al obtener la cuenta corriente en la BD");
		else
			return cc;
	}

}
