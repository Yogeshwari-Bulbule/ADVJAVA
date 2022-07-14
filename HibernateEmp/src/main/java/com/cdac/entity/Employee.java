package com.cdac.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity   //Used for declaring any java class as an entity for a database
@Table(name = "tb1_emp1")  //The @Table annotation allows you to specify the details of the table
public class Employee {

	@Id //pk
	@Column(name = "empno")
	//The @Column annotation is used to specify the details of the column to which a field or property will be mapped.
	private int empno;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "salary")
	private double salary;
	
	@Column(name = "date_of_joining")
	private LocalDate dateOfJoining;

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
