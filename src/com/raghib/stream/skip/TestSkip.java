package com.raghib.stream.skip;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestSkip {

	public static void main(String[] args) {
		List<Integer> listInteger = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Integer> result;
		
		result = listInteger.stream().skip(4).collect(Collectors.toList());
		result.forEach(System.out::println);
	}
}
