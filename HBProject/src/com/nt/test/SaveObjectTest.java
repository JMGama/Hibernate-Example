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
		
		//Activa el Framework de hibernate.
		cfg = new Configuration();
		//Lee la configuracion que le dimos al Hibernate en el documento XML junto con el mapping.
		cfg = cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//Crea nuestro objeto de tipo session factory.
		factory = cfg.buildSessionFactory();
		//Abrer la sesion con la conexion a la BD.
		ses = factory.openSession();
		
		//Creamos el objeto para nuestra clase Domain de tipo Employee.
		
		emp = new Employee();
		emp.setEid(10001);
		emp.setFirstName("Jose");
		emp.setLastName("Gama");
		emp.setEmail("josegamaes@gmail.com");
		
		
		try {
			//Inicia una transaccion con Hibernate y hace nuestra Consulta a la BD.
			/*
			tx = ses.beginTransaction();
			emp = (Employee) ses.get(Employee.class, 10001);
			tx.commit();
			System.out.println(emp);
			*/
			
			//Inicia una transaccion con Hibernate y hace nuestro Insert a la BD.
			tx = ses.beginTransaction();
			ses.save(emp);
			tx.commit();
			System.out.println("Object is saved/record is inserted");
		}catch (Exception e) {
			tx.rollback();
		}
		
		//Cierra la session a la BD y el objeto tipo Session factory.
		ses.close();
		factory.close();
	}
}
