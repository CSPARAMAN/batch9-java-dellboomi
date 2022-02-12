package com.abc.jpademo.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.abc.jpademo.entity.Employee;

public class SaveEmployee {

	public static void main(String[] args) {
		
		Employee emp = new Employee();
		emp.setEmpno(2001);
		emp.setName("nemp-1");
		emp.setSalary(66000);
		emp.setDeptno(20);
			
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		
		em.persist(emp);
		
		txn.commit();
		
		System.out.println("Employee Saved.");
		
		em.close();
		emf.close();		

	}

}
