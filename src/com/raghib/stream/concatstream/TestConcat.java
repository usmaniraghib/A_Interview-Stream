package com.raghib.stream.concatstream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class TestConcat {

	public static void main(String[] args) {
		System.out.println("concatenateTwoStream");

		ArrayList<String> al1 = new ArrayList<String>();
		al1.add("Wipro");
		al1.add("Infosys");
		al1.add("HCL");
		ArrayList<String> al2 = new ArrayList<String>();
		al1.add("Apple");
		al1.add("MI");
		al1.add("Mindtree");

		Stream<String> concatStream = Stream.concat(al1.stream(), al2.stream());
		concatStream.sorted().forEach(s -> System.out.println(s));
	}
}
