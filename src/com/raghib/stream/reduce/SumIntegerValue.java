package com.raghib.stream.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SumIntegerValue {

	public static void main(String[] args) {
		List<Integer> listObject = Arrays.asList(1,2,3,4,5);
		
		//Before Java-8
		Integer sum = 0;
		for(Integer i : listObject) {
			sum = sum + i;
		}
		System.out.println("Sum : "+sum);
		
		//Using Java-8 reduce() - BinaryOperator
		Optional<Integer> opt1 = listObject.stream().reduce((a,b) -> a+b);
		System.out.println("Sum : "+opt1.get());
		
		//Using Java-8 reduce() - Method Reference
		Optional<Integer> opt2 = listObject.stream().reduce(Integer::sum);
		System.out.println("Sum : "+opt2.get());
		
		//Using Java-8 reduce() - identity
		Integer intObj = listObject.stream().reduce(0,(a,b) -> a+b);
		System.out.println("Sum : "+intObj);
	}
}
