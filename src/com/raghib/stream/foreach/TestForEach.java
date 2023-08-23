package com.raghib.stream.foreach;

import java.util.ArrayList;

public class TestForEach {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Abhijeet");
		al.add("Dom");
		al.add("Adam");
		
		System.out.println("withStream");
		al.stream().forEach(s -> System.out.println(s));
	}
}
