package com.raghib.stream.limit;

import java.util.ArrayList;

public class TestLimit {

	public static void main(String[] args) {
		System.out.println("displayResultInLimit");
		ArrayList<String> al = new ArrayList<String>();
		al.add("Abhijeet");
		al.add("Dom");
		al.add("Adam");
		
		al.stream().
		filter(s -> s.startsWith(s))
		.limit(1)
		.forEach(s -> System.out.println(s));
	}
}
