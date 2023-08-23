package com.raghib.streamof;

import java.util.stream.Stream;

public class TestStreamOf {

	public static void main(String[] args) {
		System.out.println("\nStream of");
		Stream.of(1,2,3,4,5,6,7,8,9,10).forEach(System.out::println);
		
		System.out.println("\nStream of");
		Stream<Integer> s1 = Stream.of(6,7,8,9,10);
		Stream<Integer> s2 = Stream.of(1,2,3,4,5);
		Stream<Integer> s3 = Stream.concat(s1, s2);
		s3.forEach(System.out::print);
	}
}
