package com.raghib.examples.stream.string;

/* REFERENCE
https://www.benchresources.net/java-8-how-to-find-duplicate-in-a-stream-or-list/
 */

//Print words with count using stream.

/**
* 
 * Input and Output:
1. Original List with duplicates : 

Meta
Apple
Amazon
Netflix
Meta
Google
Apple

2. Map with Key and its duplicate count : 

{Netflix=1, Meta=2, Google=1, Apple=2, Amazon=1}

1. Original List with duplicates : 

Meta
Apple
Amazon
Netflix
Meta
Google
Apple

2. Map with Key and its duplicate count : 

{Netflix=1, Google=1, Meta=2, Apple=2, Amazon=1}

1. Original List with duplicates : 

Meta
Apple
Amazon
Netflix
Meta
Google
Apple

2. Map with Key and its duplicate count : 

{Netflix=1, Google=1, Meta=2, Apple=2, Amazon=1}

*/ 

import java.util.*;

public class PrintWordsWithCount {
    public static void main(String[] args) {        
        withCount1();
        /*
6. Using Map object and Collection.forEach() method :
    Create HashMap object to store String element as Key and their respective duplicate count as Value
    Note: HashMap doesn’t allow duplicate Key
6.1 Use Map.getOrDefault() method :
Iterate through original List and store/put element into newly created HashMap to get unique elements as Key and their respective duplicate count as Value
At the time of iterating original list,
    For Key, store unique element from List
    For Value, start with 1 as count and increment by 1 for each duplicate using Map’s getOrDefault() method
         */
        
        withCount2();
        /*
6.2 Use Map.merge() method and lambda for counting duplicates :
Use Map’s merge() method to store/put into newly created HashMap to get unique elements as Key and their respective duplicate count as Value
At the time of iterating original list,
    For Key, store unique element from List
    For Value, start with 1 as count and use lambda expression (a, b) -> a + b for counting duplicates by adding/summing
         */

        withCount3();
        /*
6.3 Use Map.merge() and Integer::sum for counting duplicates :
Use Map’s merge() method to store/put into newly created HashMap to get unique elements as Key and their respective duplicate count as Value
At the time of iterating original list,
    For Key, store unique element from List
    For Value, use method reference Integer::sum for counting duplicates
         */
    }

    public static void withCount3() {
        // 1. list of Strings
        List<String> companies = new ArrayList<String>();


        // 1.1 add string elements to List
        companies.add("Meta");
        companies.add("Apple");
        companies.add("Amazon");
        companies.add("Netflix");
        companies.add("Meta"); // duplicate
        companies.add("Google");
        companies.add("Apple"); // duplicate


        // 1.2 print original List to console
        System.out.println("1. Original List with duplicates : \n");
        companies.forEach(System.out::println);


        // 2. create HashMap object
        Map<String, Integer> duplicateCountMap = new HashMap<>();


        // 2.1 iterate and store duplicate count into Map object
        companies.forEach(company -> duplicateCountMap.merge(company, 1, Integer::sum));


        // 2.2 print to console
        System.out.println("\n2. Map with Key and its duplicate count : \n");
        System.out.println(duplicateCountMap);
    }

    public static void withCount2() {
        // 1. list of Strings
        List<String> companies = new ArrayList<String>();


        // 1.1 add string elements to List
        companies.add("Meta");
        companies.add("Apple");
        companies.add("Amazon");
        companies.add("Netflix");
        companies.add("Meta"); // duplicate
        companies.add("Google");
        companies.add("Apple"); // duplicate


        // 1.2 print original List to console
        System.out.println("1. Original List with duplicates : \n");
        companies.forEach(System.out::println);


        // 2. create HashMap object
        Map<String, Integer> duplicateCountMap = new HashMap<>();


        // 2.1 iterate and store duplicate count into Map object
        companies.forEach(company -> duplicateCountMap.merge(company, 1, (a, b) -> a + b));


        // 2.2 print to console
        System.out.println("\n2. Map with Key and its duplicate count : \n");
        System.out.println(duplicateCountMap);
    }

    public static void withCount1() {
        // 1. list of Strings
        List<String> companies = new ArrayList<String>();


        // 1.1 add string elements to List
        companies.add("Meta");
        companies.add("Apple");
        companies.add("Amazon");
        companies.add("Netflix");
        companies.add("Meta"); // duplicate
        companies.add("Google");
        companies.add("Apple"); // duplicate


        // 1.2 print original List to console
        System.out.println("1. Original List with duplicates : \n");
        companies.forEach(System.out::println);


        // 2. create HashMap object
        Map<String, Integer> duplicateCountMap = new HashMap<>();


        // 2.1 iterate and store duplicate count into Map object
        companies.forEach(company -> duplicateCountMap.put((String)company,
                duplicateCountMap.getOrDefault((String)company, 0) + 1));


        // 2.2 print to console
        System.out.println("\n2. Map with Key and its duplicate count : \n");
        System.out.println(duplicateCountMap);
    }

}
