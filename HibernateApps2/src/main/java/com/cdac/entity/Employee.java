package com.cdac.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity   // annotation used to map class with db
//generic way we call table as a "entity".. this annotation is compulsory to used here 
@Table(name = "tb1_emp") //our table in db emp table ko mapped kiya class employee se
public class Employee {
	
	@Id // for primary key(id- unique identifier)
	@Column(name = "empno") //column ko java code se mapped kar diya
	private int empno;
	
	@Column(name = "name") 
	private String name;             
	
	@Column(name = "salary")
	private double salary;
	
	@Column(name = "date_of_joining") //note column ke nam mai underscore use kar sakte hai but variable ka nam hum nahi we use camel case use hota hai
	private LocalDate dateOfJoining;
	
	//how to add getter and setter in code( rightclick+ source+generate getter and setter jitne banae hai select karo)

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	
	

}
//note - project mai jitne table utane class bankar mapped karo db se
