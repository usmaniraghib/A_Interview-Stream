package com.raghib.stream.primitivestream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TestPrimitiveStream {

	public static void main(String[] args) {
		System.out.println("\nArrays Stream");
		int a[] = {1,2,3,4,5};
		IntStream is = Arrays.stream(a);
		is.forEach(System.out::print);
		
		System.out.println("\nPrimitive Stream - Range");
		int b[] = {1,2,3,4,5,6,7,8,9,10};
		Arrays.stream(b);
		IntStream is1 = IntStream.range(5, 11);
		is1.forEach(System.out::print);
		
		System.out.println("\nPrimitive Stream - Range Closed");
		int c[] = {1,2,3,4,5,6,7,8,9,10};
		Arrays.stream(c);
		IntStream is2 = IntStream.rangeClosed(1, 10);
		is2.forEach(s -> System.out.print(" "+s));
	}
}
