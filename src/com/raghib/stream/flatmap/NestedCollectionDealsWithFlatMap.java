package com.raghib.stream.flatmap;

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

public class NestedCollectionDealsWithFlatMap {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1,2);
		List<Integer> list2 = Arrays.asList(3,4);
		List<Integer> list3 = Arrays.asList(5,6);
		
		List<List<Integer>> nestedList = Arrays.asList(list1,list2,list3);
		
		List<Integer> resultList = nestedList.stream()
				.flatMap(x -> x.stream()).collect(Collectors.toList());
		
		resultList.forEach(System.out::println);
		
		List<Integer> resultList1 = nestedList.stream()
				.flatMap(x -> x.stream().map(n -> n + 10)).collect(Collectors.toList());
		
		System.out.println(resultList1);
		
		List<String> listString1 = Arrays.asList("A","B","C");
		List<String> listString2 = Arrays.asList("p","q","r");
		List<String> listString3 = Arrays.asList("X","Y","Z");
		
		List<List<String>> processingStringList = Arrays.asList(listString1,listString2,listString3);
		
		List<String> resultStringList = processingStringList.stream()
				.flatMap(x -> x.stream().map(s -> s.toUpperCase()))
				.collect(Collectors.toList());
		
		System.out.println(resultStringList);
		
		List<Employee> listObject1 = Arrays.asList(
				new Employee(1,"A",1000.00),
				new Employee(2,"B",2000.00),
				new Employee(3,"C",3000.00),
				new Employee(4,"D",4000.00),
				new Employee(5,"E",5000.00)
				);
		
		List<Employee> listObject2 = Arrays.asList(
				new Employee(11,"AA",1000.00),
				new Employee(22,"BB",2000.00),
				new Employee(33,"CC",3000.00),
				new Employee(44,"DD",4000.00),
				new Employee(55,"EE",5000.00)
				);
		
		List<List<Employee>> nestedListEmp = Arrays.asList(listObject1,listObject2);
		
		List<String> resultEmp = nestedListEmp.stream()
				.flatMap(x -> x.stream())
				.filter(y -> y.getEsalary() > 2000.00)
				.map(z -> z.getEname())
				.collect(Collectors.toList());
		
		System.out.println(resultEmp);
		
		List<Employee> resultEmp1 = nestedListEmp.stream()
				.flatMap(x -> x.stream())
				.filter(y -> y.getEsalary() > 2000.00)
				.map(z -> z)
				.collect(Collectors.toList());
		
		// Print the filtered employee records
        System.out.println("Filtered Employee Records:");
        for (Employee employee : resultEmp1) {
            System.out.println("Name: " + employee.getEname());
            System.out.println("Salary: " + employee.getEsalary());
            // Print other attributes
            System.out.println("----------------------");
        }
	}
}
