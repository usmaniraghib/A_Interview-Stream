package com.raghib.stream.toarray;
import java.util.Arrays;
import java.util.List;

public class TestToArray {

	public static void main(String[] args) {
		String[] stringArray = {"apple", "banana", "cherry", "date"};

        // Reverse the string array using streams
        String[] reversedArray = Arrays.stream(stringArray)
            .map(str -> new StringBuilder(str).reverse().toString())
            .toArray(String[]::new);

        // Print the reversed array
        System.out.println("Reversed String Array:");
        Arrays.stream(reversedArray).forEach(System.out::println);
        
        List<String> listObject = Arrays.asList("A","B","C","1","2","3");
        
        Object[] arr = listObject.stream().toArray();
        
        System.out.println("Array Length : "+arr.length);
        
        for(Object o : arr) {
        	System.out.println(o);
        }
	}	
}