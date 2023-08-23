package com.raghib.stream.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
	private int eno;
	private String ename;
	private double esalary;
	public Employee(int eno, String ename, double esalary) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.esalary = esalary;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getEsalary() {
		return esalary;
	}
	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}
}

public class TestMap {
	
	public static void main(String[] args) {
		
		List<String> listObject = Arrays.asList("raghib","usmani");
		List<String> resultString = new ArrayList<>();
		
		//Without Stream
		for(String name : listObject) {
			resultString.add(name.toUpperCase());
		}		
		System.out.println(resultString);
		
		//With Stream
		resultString = listObject.stream().map(name -> name.toUpperCase()).collect(Collectors.toList());
		resultString.forEach(System.out::println);
		
		resultString.forEach(name -> System.out.println(name));
		
		listObject.stream().map(name -> name.toUpperCase()).forEach(System.out::println);
	
		listObject.stream().map(name -> name.length()).forEach(System.out::println);
	
		List<Employee> listObject1 = Arrays.asList(
				new Employee(1,"A",1000.00),
				new Employee(2,"B",2000.00),
				new Employee(3,"C",3000.00),
				new Employee(4,"D",4000.00),
				new Employee(5,"E",5000.00)
				);
		
		listObject1.stream().filter(e -> e.getEsalary() > 2000.00)
		.map(e -> e.getEname())
		.forEach(e1 -> System.out.println(e1));		
	}
}
