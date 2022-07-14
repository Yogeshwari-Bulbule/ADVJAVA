package com.cdac.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cdac.entity.Employee;

//Data Access Object
//classes which contain database related code
//are commonly referred to as Dao classes
public class EmployeeDao {

	public void add(Employee emp) {
		//During this step, the persistence.xml file will be read
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager(); ////finds entities by the entity’s primary key, and allows queries to be run on entities.
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(emp); //persist method will generate insert query
		
		tx.commit();
		emf.close();
	}
	
	public Employee fetch(int empno) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();

		//find method generates select query where pk = ?
		Employee emp = em.find(Employee.class, empno);  //2 parameter find method ..to fetch data from pk
		
		emf.close();

		return emp;
		
	}
	
	public List<Employee> fetchAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("select e from Employee e"); //HQL/JPQL (pass own query as parameter)
		//hql = hibernate query lang - not write table name we writ class name
		//jpql - java persistance query lang
		List<Employee> list = q.getResultList();
		
		emf.close();

		return list;
	}
	
	public List<Employee> fetchAllBySalary(double salary) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("select e from Employee e where e.salary >= :sal"); //:placeholder 
		q.setParameter("sal", salary); //replace this :sal placeholder to actual value of salary
		List<Employee> list = q.getResultList();
		
		emf.close();

		return list;
	}
	

	public List<String> fetchAllNames() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("select e.name from Employee e"); //HQL/JPQL
		List<String> list = q.getResultList();
		
		emf.close();

		return list;
	}

	public List<Object[]> fetchAllNamesAndSalaries() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("select e.name,e.salary from Employee e"); //HQL/JPQL
		List<Object[]> list = q.getResultList();
		
		emf.close();

		return list;
	}
}
