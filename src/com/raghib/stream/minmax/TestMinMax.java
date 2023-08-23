package com.raghib.stream.minmax;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestMinMax {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		Optional<Integer> minResult = list.stream()
		.min((val1,val2) -> { return val1.compareTo(val2); } );
		System.out.println(minResult.get());
		
		Optional<Integer> maxResult = list.stream()
				.max((val1,val2) -> { return val1.compareTo(val2); } );
		System.out.println(maxResult.get());
	}
}
