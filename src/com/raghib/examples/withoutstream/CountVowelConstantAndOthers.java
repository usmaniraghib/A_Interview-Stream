package com.raghib.examples.withoutstream;

/* REFERENCE
https://www.javaguides.net/2019/08/java-program-to-count-vowels-and-consonants-in-a-string-java8.html
 */

//Program to count Vowels, Consonants, and Others.

/**
*
 * Input: Provide your string value : ?raghi b*&
 * Output:
Vowels : 2
Consonants : 4
Digit Space And Special Characters : 4
*/ 

import java.util.Scanner;

public class CountVowelConstantAndOthers {
    public static int consonants,vowels,digitAndSpecialCharacters;
    public static String inputString = null;
    public static void main(String[] args) {
        System.out.print("Provide your string value : ");
        try (Scanner scannerObject = new Scanner(System.in)) {
			inputString = scannerObject.nextLine();
		}
        provideCount(inputString);
    }
    public static void provideCount(String str) {
        if (str == null) {
            // or throw IllegalArgumentException
            throw new IllegalArgumentException("Input String can't be null");
        }

        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else if ((ch >= 'a' && ch <= 'z')) {
                consonants++;
            } else {
                digitAndSpecialCharacters++;
            }
        }
        System.out.println("Vowels : "+vowels);
        System.out.println("Consonants : "+consonants);
        System.out.println("Digit Space And Special Characters : "+digitAndSpecialCharacters);
    }
}
