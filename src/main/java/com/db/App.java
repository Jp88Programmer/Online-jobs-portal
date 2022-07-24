package com.db;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.entity.Jobs;
import com.entity.User;

public class App {

	private User user;
	private Jobs job;

	public static void main(String args[]) {

		App app = new App();

//		 Jobs j = app.getJobById(2);

		// System.out.println(j.getId()+ " " + j.getTitle());
		
//		User u = app.validUser("parmar@1234", "1234");
//		
//		System.out.println(" data find sucessfully...");
//		System.out.println("Id : " + u.getId() + "Email : " + u.getEmail() + "Password : " + u.getPassword());
		
//		
//		List l = app.getJobsByStatus();
//		System.out.println(" data find sucessfully...");
//		
//		System.out.println(((Jobs)l.get(0)).getId());
//		
		
		
	}

	public void addUser(User user) {

		System.out.println("entering the program");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		System.out.println("config the hibernate file");

		SessionFactory factory = cfg.buildSessionFactory();

		System.out.println("built sesson factory");

		Session session = factory.openSession();

		System.out.println("open session");

		Transaction t = session.beginTransaction();

		System.out.println("transaction started...");

		System.out.println("object make ");

		session.persist(user);

		t.commit();
		System.out.println("successfully saved");
		factory.close();
		session.close();
	}

	public User validUser(String email, String password) {

		System.out.println("entering the program");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		System.out.println("config the hibernate file");

		SessionFactory factory = cfg.buildSessionFactory();

		System.out.println("built sesson factory");

		Session session = factory.openSession();

		System.out.println("open session");

		Transaction t = session.beginTransaction();

		System.out.println("transaction started...");

		System.out.println("object make ");

		User j = new User();
		
		String query = "FROM User u WHERE u.email =:email and u.password=:password";

		Query q = session.createQuery(query);
		q.setParameter("email", email);
		q.setParameter("password", password);

		List list = q.list();
		
		System.out.println("query resolve successfully...");
		
		User u = null;
			u = (User)list.get(0);
		
		if(u.equals(null)){
			System.out.println("email not found");
		}
		else{
			System.out.println("object assigning the value");
			
			t.commit();
			System.out.println("successfully data fetched or find");
		}
		
		factory.close();
		session.close();
		return u;
		
	}

	public void addJobs(Jobs job) {

		System.out.println("entering the program");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		System.out.println("config the hibernate file");

		SessionFactory factory = cfg.buildSessionFactory();

		System.out.println("built sesson factory");

		Session session = factory.openSession();

		System.out.println("open session");

		Transaction t = session.beginTransaction();

		System.out.println("transaction started...");

		/*
		 * User e1=new User(); e1.setId(7); e1.setName("Sarav");
		 * e1.setEmail("Sarfav@gamil.com"); e1.setQualifacation("IT");
		 * e1.setRole("user");
		 */

		System.out.println("object make ");

		session.persist(job);

		t.commit();

		System.out.println("successfully saved");
		factory.close();
		session.close();
	}

	public List getJobs() {

		System.out.println("entering the program");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		System.out.println("config the hibernate file");

		SessionFactory factory = cfg.buildSessionFactory();

		System.out.println("built sesson factory");

		Session session = factory.openSession();

		System.out.println("open session");

		Transaction t = session.beginTransaction();

		System.out.println("transaction started...");

		Query query = session.createQuery("from Jobs");

		List fetchedJobsData = query.list();

		System.out.println("Data Store in the List");

		t.commit();

		factory.close();
		session.close();

		return fetchedJobsData;

	}

	public Jobs getJobById(int id) {

		System.out.println("entering the program");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		System.out.println("config the hibernate file");

		SessionFactory factory = cfg.buildSessionFactory();

		System.out.println("built sesson factory");

		Session session = factory.openSession();

		System.out.println("open session");

		Transaction t = session.beginTransaction();

		System.out.println("transaction started...");

		Jobs j = (Jobs) session.get(Jobs.class, id);
		t.commit();

		factory.close();
		session.close();

		return j;
	}

	public List getJobsByStatus(){
		
		System.out.println("entering the program");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		System.out.println("config the hibernate file");

		SessionFactory factory = cfg.buildSessionFactory();

		System.out.println("built sesson factory");

		Session session = factory.openSession();

		System.out.println("open session");

		Transaction t = session.beginTransaction();

		System.out.println("transaction started...");

		Query query = session.createQuery("FROM Jobs j WHERE j.status='Active'");

		List fetchedJobsData = query.list();

		System.out.println("Data Store in the List");

		t.commit();

		factory.close();
		session.close();

		return fetchedJobsData;

		
	}
	public void editJobs(Jobs j) {

		System.out.println("entering the program");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		System.out.println("config the hibernate file");

		SessionFactory factory = cfg.buildSessionFactory();

		System.out.println("built sesson factory");

		Session session = factory.openSession();

		System.out.println("open session");

		Transaction t = session.beginTransaction();

		System.out.println("transaction started...");

		session.update(j);

		System.out.println("data edit successfully...");
		t.commit();

		factory.close();
		session.close();

	}

	public boolean deleteJobs(Jobs j) {

		System.out.println("entering the program");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		System.out.println("config the hibernate file");

		SessionFactory factory = cfg.buildSessionFactory();

		System.out.println("built sesson factory");

		Session session = factory.openSession();

		System.out.println("open session");

		Transaction t = session.beginTransaction();

		System.out.println("transaction started...");

		boolean f = false;

		if ((j = (Jobs) session.get(Jobs.class, j.getId())) != null) {

			session.delete(j);
			f = true;
			System.out.println("delete sucessfully...");
		} else {

			f = false;
			System.out.println("Any Error Occur...");
		}

		t.commit();

		factory.close();
		session.close();

		return f;

	}

	public boolean deleteJobs(int id) {

		System.out.println("entering the program");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		System.out.println("config the hibernate file");

		SessionFactory factory = cfg.buildSessionFactory();

		System.out.println("built sesson factory");

		Session session = factory.openSession();

		System.out.println("open session");

		Transaction t = session.beginTransaction();

		System.out.println("transaction started...");

		Jobs j = new Jobs();

		boolean f = false;
		if ((j = (Jobs) session.get(Jobs.class, id)) != null) {

			session.delete(j);
			f = true;
			System.out.println("delete sucessfully...");
		} else {

			f = false;
			System.out.println("Any Error Occur...");
		}

		t.commit();

		factory.close();
		session.close();

		return f;

	}
}
