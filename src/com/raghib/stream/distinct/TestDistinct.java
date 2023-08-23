package com.raghib.stream.distinct;

import java.util.Arrays;
import java.util.List;

public class TestDistinct {

	public static void main(String[] args) {
		
		List<Integer> al = Arrays.asList(3,2,2,7,5,1,9,7);
		al.stream()
		.distinct()
		.sorted()
		.forEach(s -> System.out.println(s));
	}
}
