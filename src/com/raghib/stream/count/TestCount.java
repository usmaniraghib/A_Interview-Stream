package com.raghib.stream.count;

import java.util.ArrayList;

public class TestCount {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Abhijeet");
		al.add("Dom");
		al.add("Adam");
		
		long count = al.stream().filter(s -> s.startsWith("A")).count();
		System.out.println("withStreamGetCount");
		System.out.println("Count : "+count);
	}
}
