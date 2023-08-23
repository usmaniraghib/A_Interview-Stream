package com.raghib.stream.sorted;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortIntegerAndString {

	public static void main(String[] args) {
		List<Integer> listInteger = Arrays.asList(1,10,20,2,3,30,44,4,15,5);
		List<String> listString = Arrays.asList("A","BB","AA","BBB","CC");
		
		List<Integer> sortIntergerResult = 
				listInteger.stream()
				.sorted()
				.collect(Collectors.toList());
		System.out.println("Sorted Integer Value : "+sortIntergerResult);
		
		List<Integer> reverseSortIntergerResult = 
				listInteger.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println("Reverse Sorted Integer Value : "+reverseSortIntergerResult);
	
		List<String> sortStringResult = 
				listString.stream()
				.sorted()
				.collect(Collectors.toList());
		System.out.println("Sorted String Value : "+sortStringResult);
		
		List<String> reverseSortStringResult = 
				listString.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println("Reverse Sorted String Value : "+reverseSortStringResult);
	}
}
