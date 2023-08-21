package com.raghib.examples.stream.integer;

/* REFERENCE
https://www.geeksforgeeks.org/how-to-find-duplicate-elements-in-a-stream-in-java/
 */

// Print duplicate value of collection using stream.

/**
*
 * Input:
Stream<Integer> stream1 = Stream.of(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
List<Integer> list = Arrays.asList(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
Stream<Integer> stream2 = Stream.of(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);

 * Output:
[59, 13]
[59, 13]
[59, 13]

*/ 

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDuplicatesOfInteger {
    public static void main(String[] args) {
        // Initial stream
        Stream<Integer> stream1 = Stream.of(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
        // Print the found duplicate elements - Approach-1
        System.out.println(findDuplicateInStream1(stream1));
        /*
Using Set: Since Set has the property that it cannot contain any duplicate element. 
So if we add the elements in a Set, it automatically discards the duplicate elements 
while addition itself.

Approach:
    Get the stream of elements in which the duplicates are to be found.
    Traverse each element of the stream
    For each element in the stream, if it is not present in the set, add it. 
    This can be done using Set.add() method.
        Set.add()
    If the element is present in the Set already, then this Set.add() returns false.
    Hence we can print such elements or collect them for further process. 
    We will print these elements in this case.
         */

        // Initial stream
        List<Integer> list = Arrays.asList(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
        // Print the found duplicate elements - Approach-2
        System.out.println(findDuplicateInStream2(list));
        /*
Using Collections.frequency(): 
The frequency() method of Collections class in Java, 
counts the frequency of the specified element in the given list. 
So we will then find out the elements that have frequency more than 1, 
which are the duplicate elements.

Approach:
    Get the stream of elements in which the duplicates are to be found.
    Traverse each element of the stream
    For each element in the stream, count the frequency of each element, 
    using Collections.frequency() method.
        Collections.frequency(list, i)
    Then for each element in the collection list, if the frequency of any element is more than one, 
    then this element is a duplicate element.
    Hence we can print such elements or collect them for further process. 
    We will print these elements in this case.
         */

        // Initial stream
        Stream<Integer> stream2 = Stream.of(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);

        // Print the found duplicate elements - Approach-3
        System.out.println(findDuplicateInStream3(stream2));
        /*
Using Collectors.groupingBy(): 
The groupingBy() method of Collectors class in Java groups the objects by some property. 
So we will pass the property of redundancy and collect the result in a Set.

Approach:
    Get the stream of elements in which the duplicates are to be found.
    Traverse each element of the stream
    For each element in the stream, group them along with their frequency in a map, 
    using Collectors.groupingBy() method.
        stream.collect(
            Collectors.groupingBy(Function.identity(),
            Collectors.counting()));
    Then for each element in the collected map, if the frequency of any element is more than one, 
    then this element is a duplicate element.
    Hence we can print such elements or collect them for further process. 
    We will print these elements in this case.
         */
    }

    // Function to find the duplicates in a Stream
    public static <T> Set<T> findDuplicateInStream1(Stream<T> stream) {

        // Set to store the duplicate elements
        Set<T> items = new HashSet<>();

        // Return the set of duplicate elements
        return stream

                // Set.add() returns false
                // if the element was
                // already present in the set.
                // Hence filter such elements
                .filter(n -> !items.add(n))

                // Collect duplicate elements
                // in the set
                .collect(Collectors.toSet());
    }

    // Function to find the duplicates in a Stream
    public static <T> Set<T> findDuplicateInStream2(List<T> list)
    {
        // Return the set of duplicate elements
        return

                // Get the stream from the list
                list.stream()

                        // Count the frequency of each element
                        // and filter the elements
                        // with frequency > 1
                        .filter(i -> Collections.frequency(list, i) > 1)

                        // And Collect them in a Set
                        .collect(Collectors.toSet());
    }

    // Function to find the duplicates in a Stream
    public static <T> Set<T> findDuplicateInStream3(Stream<T> stream)
    {

        // Return the set of duplicate elements
        return stream

                // Group the elements along
                // with their frequency in a map
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()))

                // Convert this map into a stream
                .entrySet()
                .stream()

                // Check if frequency > 1
                // for duplicate elements
                .filter(m -> m.getValue() > 1)

                // Find such elements
                .map(Map.Entry::getKey)

                // And Collect them in a Set
                .collect(Collectors.toSet());
    }
}
