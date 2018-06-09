package dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import entities.ClienteEntity;
import entities.MovimientoCtaCteEntity;
import excepciones.ClienteException;
import excepciones.CuentaCorrienteException;
import excepciones.MovimientoException;
import hibernate.HibernateUtil;
import negocio.Cliente;

public class ClienteDao {

	private static ClienteDao instancia = null;
	private static SessionFactory sf = null;
	//t

	public static ClienteDao getInstancia() {
		if(instancia==null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new ClienteDao();
		}
		return instancia;
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> loadAll() throws ClienteException {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Session session = sf.openSession();
		Query query = session.createQuery("select c from ClienteEntity c");
		List<ClienteEntity> clientesEntity = query.list();
		if (clientesEntity != null){
			for(ClienteEntity ce : clientesEntity)
				clientes.add(ce.toNegocio());
			return clientes;
		} else {
			throw new ClienteException("Error al cargar la lista de clientes de la BD");
		}	
	}

	public Cliente buscarClienteByDni(int dni) throws ClienteException  {
		ClienteEntity ce = null;
		Session session = sf.openSession();
		Query query = session.createQuery("select c from ClienteEntity c where c.dni=?");
		query.setParameter(0, dni);
		ce = (ClienteEntity) query.uniqueResult();
		if (ce == null) 
			throw new ClienteException("Error al buscar el Cliente en la BD");
		else
			return ce.toNegocio();		
	}

	public void save(Cliente c) throws ClienteException{
		if (c != null){
			Session session = sf.openSession();
			session.beginTransaction();
			session.save(c.toEntity());
			session.flush();
			session.getTransaction().commit();
			session.close();
		}else{
			throw new ClienteException("Error en el guardado del cliente en la BD");
		}
	}

	public void update(Cliente c) throws ClienteException {
		if (c != null){
			Session session = sf.openSession();
			session.beginTransaction();
			session.update(c.toEntity());
			session.flush();
			session.getTransaction().commit();
			session.close();
		}else{
			throw new ClienteException("Error en el update del cliente en la BD");
		}
	}

	public void delete(Cliente c) throws ClienteException {
		if (c != null){
			Session session = sf.openSession();
			session.beginTransaction();
			session.delete(c.toEntity());
			session.flush();
			session.getTransaction().commit();
			session.close();
		} else {
			throw new ClienteException("Error en el borrado del cliente en la BD");
		}	
	}


	@SuppressWarnings("unused")
	public void restarSaldo(int cuit, int numero, float total) throws ClienteException, MovimientoException, CuentaCorrienteException {
		Session session = sf.openSession();
		session.beginTransaction();
		MovimientoCtaCteEntity movimiento;
		movimiento = new MovimientoCtaCteEntity(CuentaCorrienteDao.getInstancia().getCuentaCorrienteByCuit(cuit), numero,(Date)Calendar.getInstance().getTime(),-total,"");
		if (movimiento == null)
			throw new MovimientoException("Error al buscar movimiento en la BD.");
		session.save(movimiento);
		session.getTransaction().commit();
		session.flush();
		ClienteEntity cliente = (ClienteEntity) session.get(ClienteEntity.class, numero);	
		if (cliente == null)
			throw new ClienteException("Error al buscar el cliente en la BD");
		cliente.getCuentaCorriente().getMovimientos().add(movimiento);
		float nuevoSaldo = cliente.getCuentaCorriente().getSaldo()-total;
		cliente.getCuentaCorriente().setSaldo(nuevoSaldo);
		session.beginTransaction();
		session.update(cliente);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}


}
