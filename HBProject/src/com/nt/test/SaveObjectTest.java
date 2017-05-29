package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Employee;

public class SaveObjectTest {
	public static void main(String[] args) {
		Configuration cfg = null;
		SessionFactory factory = null;
		Session ses = null;
		Employee emp = null;
		Transaction tx = null;
		
		//Activate HB framework (Bootstrao Hibernate)
		cfg = new Configuration();
		//Read both mappig, cfg file data
		cfg = cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//Build session factory object
		factory = cfg.buildSessionFactory();
		//Open Session with DB Software
		ses = factory.openSession();
		
		//Create object for Domain class
		/*emp = new Employee();
		emp.setEid(10001);
		emp.setFirstName("Jose");
		emp.setLastName("Gama");
		emp.setEmail("josegamaes@gmail.com");*/
		
		try {
			//Consult from the DB
			/*
			tx = ses.beginTransaction();
			emp = (Employee) ses.get(Employee.class, 10001);
			tx.commit();
			System.out.println(emp);
			*/
			
			//Insert in the DB
			/*tx = ses.beginTransaction();
			ses.save(emp);
			tx.commit();
			System.out.println("Object is saved/record is inserted");*/
		}catch (Exception e) {
			tx.rollback();
		}
		
		//Close Object and DB Software
		ses.close();
		factory.close();
	}
}
