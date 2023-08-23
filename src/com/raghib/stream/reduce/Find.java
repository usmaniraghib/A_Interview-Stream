package com.raghib.stream.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class Employee {
	private int id;
	private String name;
	private String email;
	private int salary;
	private String department;
	public Employee(int id, String name, String email, int salary, String department) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.department = department;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}

public class Find {

	public static void main(String[] args) {
		
		Employee e1 = new Employee(1,"A","a@gmail.com",100,"HR");
		Employee e2 = new Employee(2,"B","b@gmail.com",200,"HR");
		
		Employee e3 = new Employee(3,"C","c@gmail.com",300,"Finance");
		Employee e4 = new Employee(4,"D","d@gmail.com",400,"Finance");
		
		Employee e5 = new Employee(5,"E","e@gmail.com",500,"IT");
		Employee e6 = new Employee(6,"F","f@gmail.com",600,"Marketing");
		
		List<Employee> listObject = Arrays.asList(e1,e2,e3,e4,e5,e6);
		
		Optional<Integer> res = listObject.stream()
		.filter(sal -> sal.getSalary() > 200)
		.map(colSal -> colSal.getSalary())
		//.reduce((a,b) -> a > b ? a : b)
		.reduce(Integer::max);
		
		System.out.println("Max Salary : "+res.get());
	}
}
