package daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import pojos.Customer;

public class CustomerDAO {
	SessionFactory sessionFactory = null;
	Configuration cf = null;

	public CustomerDAO(String configuartionFile) {
		cf = new Configuration();
		cf = cf.configure(configuartionFile);
		sessionFactory = cf.buildSessionFactory();
	}

	public void save(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(customer);
			t.commit();
			System.out.println("Save customer successfully !");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			t.rollback();
		} finally {
			session.close();
		}
	}

	public void update(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.clear();
			session.update(customer);
			t.commit();
			System.out.println("Update customer successfully !");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			t.rollback();
		} finally {
			session.close();
		}
	}

	public void delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			Customer customer = session.get(Customer.class, id);
			session.delete(customer);
			t.commit();
			System.out.println("Delete customer successfully !");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			t.rollback();
		} finally {
			session.close();
		}
	}

	public List<Customer> getAll() {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			List<Customer> ds = session.createQuery("Select c from Customer c", Customer.class).list();
			return ds;
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			t.rollback();
			return null;
		} finally {
			session.close();
		}
	}
	
	public Customer findByID(int id) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			Customer customer = session.get(Customer.class, id);
			return customer;
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			t.rollback();
			return null;
		} finally {
			session.close();
		}
	}

}
