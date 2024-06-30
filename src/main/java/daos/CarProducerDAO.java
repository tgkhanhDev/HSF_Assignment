package daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class CarProducerDAO {
	SessionFactory sessionFactory = null;
	Configuration cf = null;
	public CarProducerDAO(String configuartionFile) {
		cf = new Configuration();
		cf = cf.configure(configuartionFile);
		sessionFactory = cf.buildSessionFactory();
	}
	
	public void save(pojos.CarProducer CarProducer) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(CarProducer);
			t.commit();
			System.out.println("Save CarProducer successfully !");
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
			t.rollback();
		}finally {
			session.close();
		}
	}
	
	public void update(CarProducerDAO CarProducer) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.clear();
			session.update(CarProducer);
			t.commit();
			System.out.println("Update CarProducer successfully !");
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error: " + e.getMessage());
		} finally {
			session.close();
		}
	}

	public void delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			CarProducerDAO CarProducer = session.get(CarProducerDAO.class, id);
			session.delete(CarProducer);
			t.commit();
			System.out.println("Delete CarProducer successfully !");
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error: " + e.getMessage());
		} finally {
			session.close();
		}
	}
	
	public List<CarProducerDAO> getAll() {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			List<CarProducerDAO> ds = session.createQuery("Select a From CarProducer a", CarProducerDAO.class).list();
			return ds;
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error: " + e.getMessage());
			return null;
		} finally {
			session.close();
		}
	}

	public CarProducerDAO findByID(int id) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			CarProducerDAO CarProducer = session.get(CarProducerDAO.class, id);
			return CarProducer;
		} catch (Exception e) {
			t.rollback();
			System.out.println("Error: " + e.getMessage());
			return null;
		} finally {
			session.close();
		}
	}
}
