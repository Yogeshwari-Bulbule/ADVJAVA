package com.cdac.app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cdac.entity.Employee;

public class Main {
	public static void main(String[] args) {
		Employee emp = new Employee(1003 ,"Sonam", 20000, LocalDate.of(2022, 1, 1));
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(emp);
		tx.commit();
		emf.close();
	}
}
