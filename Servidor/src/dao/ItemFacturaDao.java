package dao;

import hibernate.HibernateUtil;
import negocio.ItemFactura;
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

	public int save(ItemFactura itemFactura) throws FacturaException{
		if (itemFactura != null){
			Session s = sf.openSession();
			s.beginTransaction();
			int id = (Integer) s.save(itemFactura.toEntitySave());
			s.flush();
			s.getTransaction().commit();
			s.close();
			return id;
		}else{
			throw new FacturaException("Error al guardar un item de factura en la BD");
		}
	}

	public void update(ItemFactura itemFactura) throws FacturaException {
		if (itemFactura != null){
			Session s = sf.openSession();
			s.beginTransaction();
			s.update(itemFactura.toEntityUpdate());
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
			session.delete(itemFactura.toEntityUpdate());
			session.flush();
			session.getTransaction().commit();
			session.close();
		}else {
			throw new FacturaException("Error en el borrado de un item factura en la BD");
		}	
	}

}
