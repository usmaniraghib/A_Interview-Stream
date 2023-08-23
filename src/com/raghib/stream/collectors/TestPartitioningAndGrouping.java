package com.raghib.stream.collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student {
	private int grade;
	private String car;
	private String name;

	public Student(int grade, String car, String name) {
		super();
		this.grade = grade;
		this.car = car;
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [grade=" + grade + ", car=" + car + ", name=" + name + "]";
	}
}

public class TestPartitioningAndGrouping {

	public static void main(String[] args) {

		Student s1 = new Student(10, "Maruti", "Raghib");
		Student s2 = new Student(20, "Honda", "Saghib");
		Student s3 = new Student(30, "BMW", "Taghib");
		Student s4 = new Student(40, "Honda", "Uaghib");
		Student s5 = new Student(50, "Maruti", "Vaghib");

		List<Student> listStudent = new ArrayList<>();
		listStudent.add(s1);
		listStudent.add(s2);
		listStudent.add(s3);
		listStudent.add(s4);
		listStudent.add(s5);

		// Partitioning Operation
		System.out.println("\nCollectors.partitioningBy");
		Map<Boolean, List<Student>> partitioningByResult = listStudent.stream()
				.collect(Collectors.partitioningBy(a -> a.getGrade() > 10));
		partitioningByResult.forEach((k, v) -> System.out.println("Result : " + k + " , " + "Value : " + v));

		// Grouping Operation
		System.out.println("\nCollectors.groupingBy");
		Map<Object, List<Student>> groupingByResult = listStudent.stream()
				.collect(Collectors.groupingBy(a -> a.getCar()));
		groupingByResult.forEach((k, v) -> System.out.println("Result : " + k + " , " + "Value : " + v));
	}
}