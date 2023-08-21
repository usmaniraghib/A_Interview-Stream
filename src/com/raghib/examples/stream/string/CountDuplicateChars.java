package com.raghib.examples.stream.string;

/* REFERENCE
https://www.javaguides.net/2020/06/java-8-count-duplicate-characters-in-string.html
 */

//Program to count duplicate character of string using stream.

/**
*
 * Input: String input = "My name is Usmani. What is your Name?";
 
 * Output:

NOTE - In the output special character count is missing. 
Because "." and "?" operator coming only one time.
Even if any character coming only one time it should not display.
Because this program only count duplicate character.

  : 7	//Space Count
A : 4
E : 2
I : 3
M : 4
N : 3
S : 3
U : 2
Y : 2

*/

import java.util.Map;
import java.util.stream.Collectors;

public class CountDuplicateChars {
    public static void main(String[] args) {
        // given input string
        String input = "My name is Usmani. What is your Name?";

        // convert string into stream
        Map< Character, Long > result = input
                .chars().mapToObj(c -> (char) Character.toUpperCase(c))
                //.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        result.forEach((k, v) -> {
            if (v > 1) {
                System.out.println(k + " : " + v);
            }
        });
    }
}
