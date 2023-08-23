package com.raghib.stream.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestFilter {

	public static void main(String[] args) {
		// Store the data - Way-1
		List<Integer> listObject = new ArrayList<>();
		listObject.add(10);
		listObject.add(05);
		listObject.add(2);
		listObject.add(1);
		listObject.add(8);

		List<Integer> evenNumberlistObject = new ArrayList<>();

		// Retrieve the data - Without Stream
		for (int n : listObject) {
			if (n % 2 == 0)
				evenNumberlistObject.add(n);
		}
		System.out.print(evenNumberlistObject + "\t");

		// Store the data - Way-2
		List<Integer> listObject1 = Arrays.asList(10, 05, 2, 1, 8);
		evenNumberlistObject = listObject1.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		// Retrieve the data - With Stream - Way-1		
		System.out.println(evenNumberlistObject);
		
		// Retrieve the data - With Stream - Way-2
		listObject1.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.println(n));

		// Retrieve the data - With Stream - Way-3
		listObject1.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
		
		List<String> stringList = Arrays.asList("A","BB","ZZZ","RRRRR","YYYY");
		List<String> resultString = new ArrayList<>();
		
		resultString = 
				stringList
				.stream()
				.filter(n -> n.length()>2 && n.length()<4)
				.collect(Collectors.toList());
		System.out.println(resultString);
		
		stringList
		.stream()
		.filter(n -> n.length()>2 && n.length()<4)
		.forEach(i -> System.out.println(i));
		
		stringList
		.stream()
		.filter(n -> n.length()>2 && n.length()<4)
		.forEach(System.out::println);
		
	}

}
