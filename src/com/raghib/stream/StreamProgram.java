package com.raghib.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamProgram {
	
	public static void withoutStream() {
		System.out.println("withoutStream");
		ArrayList<String> al = new ArrayList<String>();
		al.add("Abhijeet");
		al.add("Dom");
		al.add("Adam");
		
		for(int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
	}
	
	public static void withStream() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Abhijeet");
		al.add("Dom");
		al.add("Adam");
		
		System.out.println("withStream");
		al.stream().filter(s -> s.startsWith("A")).forEach(s -> System.out.println(s));
	}

	public static void withStreamGetCount() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Abhijeet");
		al.add("Dom");
		al.add("Adam");
		
		long count = al.stream().filter(s -> s.startsWith("A")).count();
		System.out.println("withStreamGetCount");
		System.out.println("Count : "+count);
	}
	
	public static void characterGreaterThenFour() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Abhijeet");
		al.add("Dom");
		al.add("Adam");
		
		System.out.println("characterGreaterThenFour");
		al.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));		
	}
	
	public static void displayResultInLimit() {
		System.out.println("displayResultInLimit");
		ArrayList<String> al = new ArrayList<String>();
		al.add("Abhijeet");
		al.add("Dom");
		al.add("Adam");
		
		al.stream().filter(s -> s.startsWith(s)).limit(1).forEach(s -> System.out.println(s));		
	}
	
	public static void FindWordWithLastLetterAndConvertToUppercase() {
		System.out.println("FindWordWithLastLetterAndConvertToUppercase");
		
		Stream.of("Abhijeet","Don","Alekhya","Adam","Rama")
		.filter(s -> s.endsWith("a"))
		.map(s -> s.toUpperCase())
		.forEach(s -> System.out.println(s));	
	}
	
	public static List<String> convertArrayToArrayList() {
		System.out.println("convertArrayToArrayList");
		
		String[] myArray = {"Abhijeet","Don","Alekhya","Adam","Rama"};
		
		List<String> myList = Arrays.asList(myArray);
		
		return myList;
	}
	
	public static void findAndSort() {
		System.out.println("findAndSort");
		List<String> ListResult = convertArrayToArrayList();
		ListResult.stream()
		.filter(s -> s.startsWith("A"))
		.sorted()
		.map(s -> s.toLowerCase())
		.forEach(s -> System.out.println(s));
	}
	
	public static void concatenateTwoStream() {
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
	
	public static void findspecificWord() {
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
		//concatStream.sorted().forEach(s -> System.out.println(s));
		boolean result = concatStream.anyMatch(s -> s.equalsIgnoreCase("Mi"));
		System.out.println("Result : "+result);
	}
	
	public static void removeDuplicateNumber() {
		System.out.println("removeDuplicateNumber");
		List<Integer> al = Arrays.asList(3,2,2,7,5,1,9,7);
		al.stream()
		.distinct()
		.sorted()
		.forEach(s -> System.out.println(s));
		
	}
	
	public static void printThirdIndexNumber() {
		System.out.println("printThirdIndexNumber");
		List<Integer> al = Arrays.asList(3,2,2,7,5,1,9,7);
		List<Integer> res = 
		al.stream()
		.sorted()
		.collect(Collectors.toList());
		
		System.out.println(res.get(4));
		
	}

	public static void main(String[] args) {
		//withoutStream();
		//withStream();
		//withStreamGetCount();
		//characterGreaterThenFour();
		//displayResultInLimit();
		//FindWordWithLastLetterAndConvertToUppercase();
		//findAndSort();
		//concatenateTwoStream();
		//findspecificWord();
		//removeDuplicateNumber();
		printThirdIndexNumber();
	}
}
