package com.raghib.examples.stream.string;

/* REFERENCE
http://www.java2s.com/Tutorials/Java/Stream_How_to/List/Transform_List_string_to_upper_case.htm
 */

//Program to convert each word of array list into lowercase using stream.

/**
*
 * Input: 
List<String> listObject = Arrays.asList("Ross", "Chandler", "CSS", "Monica", "Joey", "Rachel");

 * Output: ross chandler css monica joey rachel 
*
*/ 

import java.util.Arrays;
import java.util.List;

public class ConvertEachWordToLowercase {
    public static void main(final String[] args) {
        List<String> listObject = Arrays.asList("Ross", "Chandler", "CSS",
                "Monica", "Joey", "Rachel");

        listObject.stream().map(eachStringOfList -> eachStringOfList.toLowerCase())
                .forEach(eachStringOfList -> System.out.print(eachStringOfList + " "));

    }
}
