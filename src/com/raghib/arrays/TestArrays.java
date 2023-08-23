package com.raghib.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestArrays {

	public static void main(String[] args) {
		System.out.println("Arrays List");
		List<Integer> listInteger = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Integer> result;
		
		result = listInteger.stream().collect(Collectors.toList());
		result.forEach(System.out::print);
		
		System.out.println("\nArrays Stream");
		int a[] = {1,2,3,4,5};
		IntStream is = Arrays.stream(a);
		is.forEach(System.out::print);
		
		System.out.println("\nStream of");
		Stream<Integer> s1 = Stream.of(6,7,8,9,10);
		Stream<Integer> s2 = Stream.of(1,2,3,4,5);
		Stream<Integer> s3 = Stream.concat(s1, s2);
		s3.forEach(System.out::print);
	}
}
