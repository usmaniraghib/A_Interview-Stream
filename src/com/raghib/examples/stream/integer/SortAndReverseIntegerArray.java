package com.raghib.examples.stream.integer;

/* REFERENCE
http://www.java2s.com/Tutorials/Java/Stream_How_to/Stream_Sort/Sort_int_list_in_reversed_order.htm
 */

//Sort and print integer array in reverse order using stream.

/**
*
 * Input: Integer[] intArray = {9, 2, 3, 14, 5, 6, 7, 8 };
 * Output: 14 9 8 7 6 5 3 2
*
*/ 

import java.util.*;

public class SortAndReverseIntegerArray {
    public static void main(String[] args) {
        //Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8 };
        Integer[] intArray = {9, 2, 3, 14, 5, 6, 7, 8 };
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));

        Comparator<Integer> normal = Integer::compare;
        Comparator<Integer> reversed = normal.reversed();
        Collections.sort(listOfIntegers, reversed);

        listOfIntegers
                .stream()
                .forEach(e -> System.out.print(e + " "));
        System.out.println("");


    }
}
