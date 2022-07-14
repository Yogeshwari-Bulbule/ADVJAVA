package com.cdac.app;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



import com.cdac.dao.EmployeeDao;
import com.cdac.entity.Employee;



public class InsertEmployee {
	public static void main(String args[]) {
		/*  Employee emp = new Employee();   //code of insert
		emp.setEmpno(1006); 
		emp.setName("Abhi");
		emp.setSalary(20000);
		emp.setDateOfJoining(LocalDate.of(2022, 10, 10));
		EmployeeDao dao = new EmployeeDao();
		dao.add(emp);   
		*/
		//select ka code 1)
		/* EmployeeDao dao = new EmployeeDao(); //1st call obj of this call to call fetch method
		Employee emp = dao.fetch(1006);
		System.out.println(emp.getName()+" "+emp.getSalary());   */
		 
		//2) fetch all record
		  EmployeeDao dao = new EmployeeDao();
		List<Employee> list = dao.fetchAll();
		for(Employee emp : list)
			System.out.println(emp.getEmpno() + " " + emp.getName() + " " + emp.getSalary() + " " + emp.getDateOfJoining());
		
		System.out.println("............."); //ithe varcha sarkhe dao che obj karun varcha code comment karn pan kele tari chalete
		List<String> names = dao.fetchAllNames();
		for(String name : names)
			System.out.println(name);
		
		System.out.println("..............");
		List<Object[]> namesAndSalaries = dao.fetchAllNamesAndSalaries();
		for(Object[] arr : namesAndSalaries)
			System.out.println(arr[0] + " " + arr[1]); //arr[0]= name and arr[1]= sal
		
		System.out.println("..............");
		List<Employee> list2 = dao.fetchAllBySalary(1000);
		for(Employee emp : list2)
			System.out.println(emp.getEmpno() + " " + emp.getName() + " " + emp.getSalary() + " " + emp.getDateOfJoining());
		
		
		/* above code we pass hardcoded value if u want to take user input then create form in html then write this code in doget method
		doGet(..){
		Employee emp = new Employee();
		emp.setEmpno(request.getParameter("empno"));
		emp.setName(request.getParameter("name"));
		emp.setSalary(request.getParameter("salary"));
		emp.setDateOfJoining(request.getParameter("doj"));
		EmployeeDao dao = new EmployeeDao();
		dao.add(emp);
		out.write("<h1> Record inserted sucessfully </h1>");
		
		
	} */

	/*public static void main(String[] args) {  //this code move to EmployeeDao.java ( db code)
		//During this step, the persistence.xml file will be read
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("learning-hibernate");
		EntityManager em = emf.createEntityManager();  //finds entities by the entity’s primary key, and allows queries to be run on entities.
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Employee emp = new Employee();
		emp.setEmpno(1001);
		emp.setName("Yogeshwari");
		emp.setSalary(100000);
		emp.setDateOfJoining(LocalDate.of(2019, 10, 10));
		em.persist(emp); //persist method will generate insert query
		//emp obj of employee class & in class employee we mapped  table tb1_emp 
		
		tx.commit();
		
		emf.close();
	} */
}
}
