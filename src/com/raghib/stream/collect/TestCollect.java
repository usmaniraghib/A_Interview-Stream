package com.raghib.stream.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestCollect {

	public static void main(String[] args) {
		
		List<Integer> listObject1 = Arrays.asList(10, 05, 2, 1, 8);
		List<Integer> evenNumberlistObject = new ArrayList<>();
		evenNumberlistObject = 
				listObject1.stream()
				.filter(n -> n % 2 == 0)
				.collect(Collectors.toList());
		System.out.println(evenNumberlistObject);
	}
}
