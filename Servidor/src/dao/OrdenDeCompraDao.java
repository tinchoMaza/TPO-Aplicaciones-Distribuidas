package dao;



import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import excepciones.OrdenDeCompraException;
import hibernate.HibernateUtil;
import negocio.OrdenDeCompra;

public class OrdenDeCompraDao {
	private static OrdenDeCompraDao instancia;
	private static SessionFactory sf = null;

	public static OrdenDeCompraDao getInstancia(){
		if (instancia == null)
			sf = HibernateUtil.getSessionFactory();
		instancia = new OrdenDeCompraDao();
		return instancia;
	}

	public void save(OrdenDeCompra oc) throws OrdenDeCompraException{
		if (oc != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.save(oc.toEntity());
			s.getTransaction().commit();
			s.close();
		}else{
			throw new OrdenDeCompraException("Error en el guardado de una orden de compra en la BD");
		}
	}

	public void update(OrdenDeCompra oc) throws OrdenDeCompraException{
		if (oc != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.update(oc.toEntity());
			s.getTransaction().commit();
			s.close();
		}else{
			throw new OrdenDeCompraException("Error al actualizar una orden de compra en la BD");
		}
	}

	public void delete(OrdenDeCompra oc) throws OrdenDeCompraException{
		if (oc != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.delete(oc.toEntity());
			s.getTransaction().commit();
			s.close();
		}else{
			throw new OrdenDeCompraException("Error al borrar una orden de compra en la BD");
		}
	}







}
