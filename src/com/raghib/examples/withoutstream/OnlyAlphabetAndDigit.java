package com.raghib.examples.withoutstream;

/* REFERENCE
https://www.javaguides.net/2018/08/how-to-check-if-string-contains-only-letters-or-digits.html
 */

//Program to print true if string is having character or digit only, otherwise false.

/**
*
Input and Output:

Result of null value [null] : false
Result of empty string value [""] : false
Result of empty string with space value [" "] : false
Result of single character in string ["a"] : true
Result of single character in string ["A"] : true
Result of only character in string ["kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl"] : true
Result of sentence in string ["ham kso"] : false
Result of single digit in string ["1"] : true
Result of alphanumeric in string ["hkHKHik6iUGHKJgU7tUJgKJGI87GIkug"] : true
Result of special character in string ["hkHKHik*khbkuh"] : false
Result of underscore character in string ["_"] : false

*/ 

public class OnlyAlphabetAndDigit {
    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isAlphanumeric(final CharSequence cs) {
        //System.out.println("cs : "+cs);
        if (isEmpty(cs)) {
            return false;
        }

        final int sz = cs.length();

        for (int i = 0; i < sz; i++) {
            //System.out.println("!Character.isLetterOrDigit(cs.charAt(i)) : "+!Character.isLetterOrDigit(cs.charAt(i)));
            if (!Character.isLetterOrDigit(cs.charAt(i))) {
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean resultOfNull = isAlphanumeric(null);
        System.out.println("Result of null value [null] : "+resultOfNull);

        boolean resultOfEmptyString = isAlphanumeric("");
        System.out.println("Result of empty string value [\"\"] : "+resultOfEmptyString);

        boolean resultOfEmptyStringWithSpace = isAlphanumeric(" ");
        System.out.println("Result of empty string with space value [\" \"] : "+resultOfEmptyStringWithSpace);

        boolean resultOfSingleCharacterInStringSmall = isAlphanumeric("a");
        System.out.println("Result of single character in string [\"a\"] : "+resultOfSingleCharacterInStringSmall);

        boolean resultOfSingleCharacterInStringCap = isAlphanumeric("A");
        System.out.println("Result of single character in string [\"A\"] : "+resultOfSingleCharacterInStringCap);

        boolean resultOfOnlyCharacterInString = isAlphanumeric("kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl");
        System.out.println("Result of only character in string [\"kgKgKgKgkgkGkjkjlJlOKLgHdGdHgl\"] : "+resultOfOnlyCharacterInString);

        boolean resultOfSentenceInString = isAlphanumeric("ham kso");
        System.out.println("Result of sentence in string [\"ham kso\"] : "+resultOfSentenceInString);

        boolean resultOfSingleDigitInString = isAlphanumeric("1");
        System.out.println("Result of single digit in string [\"1\"] : "+resultOfSingleDigitInString);

        boolean resultOfAlphanumericInString = isAlphanumeric("hkHKHik6iUGHKJgU7tUJgKJGI87GIkug");
        System.out.println("Result of alphanumeric in string [\"hkHKHik6iUGHKJgU7tUJgKJGI87GIkug\"] : "+resultOfAlphanumericInString);

        boolean resultOfSpecialCharacterInString = isAlphanumeric("hkHKHik*khbkuh");
        System.out.println("Result of special character in string [\"hkHKHik*khbkuh\"] : "+resultOfSpecialCharacterInString);

        boolean resultOfUnderscoreInString = isAlphanumeric("_");
        System.out.println("Result of underscore character in string [\"_\"] : "+resultOfUnderscoreInString);
    }
}
