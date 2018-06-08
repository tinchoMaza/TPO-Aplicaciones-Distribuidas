package dao;

import hibernate.HibernateUtil;



import negocio.ItemFactura;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;


import excepciones.FacturaException;

public class ItemFacturaDao {

	private static ItemFacturaDao instancia;
	private static SessionFactory sf = null;

	public static ItemFacturaDao getInstancia(){
		if (instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new ItemFacturaDao();
		}	
		return instancia;
	}

	public void save(ItemFactura itemFactura) throws FacturaException{
		if (itemFactura != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.save(itemFactura.toEntity());
			s.getTransaction().commit();
			s.close();
		}else{
			throw new FacturaException("Error al guardar un item de factura en la BD");
		}
	}

	public void update(ItemFactura itemFactura) throws FacturaException {
		if (itemFactura != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.update(itemFactura.toEntity());
			s.getTransaction().commit();
			s.close();
		}else{
			throw new FacturaException("Error al actualizar un item de factura en la BD");
		}
	}


	public void delete(ItemFactura itemFactura) throws FacturaException {
		if (itemFactura != null){
			Session session = sf.openSession();
			session.beginTransaction();
			session.delete(itemFactura.toEntity());
			session.flush();
			session.getTransaction().commit();
			session.close();
		}else {
			throw new FacturaException("Error en el borrado de un item factura en la BD");
		}	
	}

}
