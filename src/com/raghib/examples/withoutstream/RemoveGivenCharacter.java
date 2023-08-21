package com.raghib.examples.withoutstream;

/* REFERENCE
https://www.javaguides.net/2019/08/remove-character-from-string-in-java.html
 */

//Program to remove specific character from string.

/**
*
 * Input: 
JaAVaA GUIDES
Character to remove: a

 * Output:
StringBuilder based solution:
Result: 
JAVA GUIDES

Regular expression based solution:
Result: 
JAVA GUIDES

Java 8, functional-style solution:
Result: 
JAVA GUIDES

*/ 
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RemoveGivenCharacter {
    private static final String TEXT = "JaAVaA GUIDES";
    private static final char CHAR = 'a';

    public static void main(String[] args) {

        System.out.println("Input text: \n" + TEXT);
        System.out.println("Character to remove: " + CHAR + "\n");

        System.out.println("StringBuilder based solution:");
        String resultV1 = removeCharacterV1(TEXT, CHAR);
        System.out.println("Result: \n" + resultV1);

        System.out.println();
        System.out.println("Regular expression based solution:");
        String resultV2 = removeCharacterV2(TEXT, CHAR);
        System.out.println("Result: \n" + resultV2);

        System.out.println();
        System.out.println("Java 8, functional-style solution:");
        String resultV3 = removeCharacterV3(TEXT, CHAR);
        System.out.println("Result: \n" + resultV3);
    }

    public static String removeCharacterV1(String str, char ch) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            throw new IllegalArgumentException("Input String can't be null");
        }

        StringBuilder sb = new StringBuilder();
        char[] chArray = str.toCharArray();
        for (int i = 0; i < chArray.length; i++) {
            if (chArray[i] != ch) {
                sb.append(chArray[i]);
            }
        }

        return sb.toString();
    }

    public static String removeCharacterV2(String str, char ch) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            throw new IllegalArgumentException("Input String can't be null");
        }

        return str.replaceAll(Pattern.quote(String.valueOf(ch)), "");
    }

    public static String removeCharacterV3(String str, char ch) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            throw new IllegalArgumentException("Input String can't be null");
        }

        return str.chars().filter(c -> c != ch).mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
    }
}
