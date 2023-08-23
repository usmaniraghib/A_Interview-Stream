package com.raghib.stream.arraystream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TestArrayStream {
	public static void main(String[] args) {
		System.out.println("\nArrays Stream");
		int a[] = {1,2,3,4,5};
		IntStream is = Arrays.stream(a);
		is.forEach(System.out::print);
	}
}
