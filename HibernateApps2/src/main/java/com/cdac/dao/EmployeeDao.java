package com.cdac.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cdac.entity.Employee;
//Data Access Object(DAO)  
//classes which contain database related code
//are commonly referred to as Dao classes
public class EmployeeDao {
////public void add(List<Employee> emp) { // multiple employee record(collection used)	
	public void add(Employee emp) { //one record//here we create add method which take one employee obj as a parameter
	
	//During this step, the persistence.xml file will be read
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(emp); //persist method will generate insert query
		
		tx.commit();      
		emf.close();
	}
	public Employee fetch(int empno) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		 Employee emp = em.find(Employee.class,empno);
		 emf.close();
			return emp;
		//find method genarate select query where primary key =? here our pk=empno
//here we are not write table name . we specify class name(Employee class se data fetch) and class ko db se mapped kiya hai in employee.java file mai
 		// 2 parameter pass in find method 1) class name 2) primary key
 		//note find method is used to fetch data based on pk
	}
	public List<Employee>fetchAll(){  //fetch/select all data
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();
		
		Query q =em.createQuery("select e from Employee e"); //hql(Hibernate query lang) /JPQL(java persistance query lang)
        List<Employee> list = q.getResultList(); //here u will get result as obj of employee class.. i have 3 recored in tabel then iwill get list of
        //4 obj of employee class
		emf.close();
		return list;
		//in hibernate (in select  query u write only  class name after from. not "table name" 
  //in above select query 1)from employee e = here "e" is a alias 2) select e = same as ..select * 
	}
	
	public List<String> fetchAllNames() {  //name hai isliye string
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("select e.name from Employee e"); //HQL/JPQL
		List<String> list = q.getResultList();
		
		emf.close();

		return list;
	}		
	public List<Object[]> fetchAllNamesAndSalary() {  //name and salary (2 value) hai isliye ( obj array) object[]
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("select e.name,e.salary from Employee e"); //HQL/JPQL(we can write our own select query)
		List<Object[]> list = q.getResultList(); //get result i nthe form of list
		
		emf.close();

		return list;
	}	
	
	public List<Employee> fetchAllBySalary(double salary) { //5000 ithe pass hoanr
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("select e from Employee e where e.salary >= :sal"); //to get dynamic value in hibernate use ":"symbol in jdbc "?"
		//for dyanamic value of sal here we write :sal(placeholder) then we resplace this placehoder with actual value (salary)
		q.setParameter("sal", salary);
		List<Employee> list = q.getResultList();
		
		emf.close();

		return list;
	}
		
	
}
