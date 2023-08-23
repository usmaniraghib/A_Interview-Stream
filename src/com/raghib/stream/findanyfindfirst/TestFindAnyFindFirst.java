package com.raghib.stream.findanyfindfirst;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class TestFindAnyFindFirst {

	public static void main(String[] args) {
		List<String> str = Arrays.asList("One Apple", "One Mango", "Two Apple", "Two Mango", "More Grapes");
		List<String> emptyStr = Arrays.asList();
		
		Optional<String> result;
		
		//findAny()
		result = str.stream().map(a -> a.toLowerCase()).findAny();
		System.out.println("Result : "+result.get());
		try {
			result = emptyStr.stream().map(a -> a.toLowerCase()).findAny();
			System.out.println("Result : "+result.get());
		} catch(NoSuchElementException e) {
			e.printStackTrace();
		}		
		
		//findFirst()
		result = str.stream().map(a -> a.toLowerCase()).findFirst();
		System.out.println("Result : "+result.get());
		
		try {
			result = emptyStr.stream().map(a -> a.toLowerCase()).findFirst();
			System.out.println("Result : "+result.get());
		} catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
}
