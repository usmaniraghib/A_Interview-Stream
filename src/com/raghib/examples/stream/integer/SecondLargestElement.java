package com.raghib.examples.stream.integer;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecondLargestElement {
	
	public static void main(String[] args) {
		way1();
		way2();
	}
	
    public static void way1() {
        Stream<Integer> integerStream = Stream.of(10, 20, 5, 15, 30, 25);
        //Stream<Integer> integerStream = Stream.of(10, 20);
        
        /*Error will occur*/
        //Stream<Integer> integerStream = Stream.of(10, 10);
        //Stream<Integer> integerStream = Stream.of(10);

        // Find the second largest element using a custom collector
        int secondLargest = integerStream.collect(Collectors.collectingAndThen(
                Collectors.toSet(),
                set -> {
                    if (set.size() < 2) {
                        throw new IllegalArgumentException("Stream has fewer than 2 elements");
                    }

                    Integer max1 = set.stream().max(Integer::compareTo).get();
                    set.remove(max1); // Remove the largest element
                    Integer max2 = set.stream().max(Integer::compareTo).get();
                    return max2;
                }
        ));

        System.out.println("Second largest element: " + secondLargest);
    }

    public static void way2() {
        int[] arr = {10, 20, 5, 15, 30, 25};

        int largest = Integer.MIN_VALUE; // Initialize with the smallest possible integer value
        int secondLargest = Integer.MIN_VALUE; // Initialize with the smallest possible integer value
        
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest; // Update second largest
                largest = num; // Update largest
            } else if (num > secondLargest && num != largest) {
                secondLargest = num; // Update second largest
            }
        }

        if (secondLargest != Integer.MIN_VALUE) {
            System.out.println("Second largest element: " + secondLargest);
        } else {
            System.out.println("There is no second largest element.");
        }
    }
}

