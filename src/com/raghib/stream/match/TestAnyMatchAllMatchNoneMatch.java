package com.raghib.stream.match;

import java.util.Arrays;
import java.util.List;

public class TestAnyMatchAllMatchNoneMatch {

	public static void main(String[] args) {
		List<String> str = Arrays.asList("One Apple", "One Mango", "Two Apple", "Two Mango", "More Grapes");

		boolean result;

		// anyMatch()
		result = str.stream().map(listValue -> listValue.toLowerCase()).anyMatch(a -> a.startsWith("one"));
		System.out.println("Result of anyMatch() method : " + result);

		// allMatch()
		result = str.stream().map(listValue -> listValue.toLowerCase()).allMatch(a -> a.startsWith("one"));
		System.out.println("Result of allMatch() method : " + result);

		// noneMatch()
		result = str.stream().map(listValue -> listValue.toLowerCase()).noneMatch(a -> a.startsWith("one"));
		System.out.println("Result of noneMatch() method : " + result);
	}

}
