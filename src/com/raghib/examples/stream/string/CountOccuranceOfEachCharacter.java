package com.raghib.examples.stream.string;

/* REFERENCE
https://www.javaguides.net/2020/06/java-8-count-duplicate-characters-in-string.html
 */

//Program to count each character of string using stream.

/**
*
 * Input: String input = "My name is Usmani. What is your Name?";
 
 * Output:
  : 7
a : 4
e : 2
h : 1
i : 3
m : 3
M : 1
N : 1
. : 1
n : 2
o : 1
r : 1
s : 3
t : 1
u : 1
U : 1
W : 1
y : 2
? : 1

*/ 

import java.util.Map;
import java.util.stream.Collectors;

public class CountOccuranceOfEachCharacter {
    public static void main(String[] args) {
        // given input string
        String input = "My name is Usmani. What is your Name?";

        // convert string into stream
        Map< Character, Long > result = input
                .chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        result.forEach((k, v) -> {
            if (v >= 1) {
                System.out.println(k + " : " + v);
            }
        });
    }
}
