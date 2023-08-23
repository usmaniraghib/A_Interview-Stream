package com.raghib.stream.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindLargestString {

	public static void main(String[] args) {
		List<String> listObject = Arrays.asList("A","BB","AA","BBB","CC");
		
		Optional<String> res =
				listObject.stream()
				.reduce((a,b) -> a.length() > b.length() ? a:b);
		
		System.out.println("Largets String : "+res.get());
	}
}
