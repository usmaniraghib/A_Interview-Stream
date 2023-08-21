package com.raghib.examples.stream.string;

/* REFERENCE
https://www.benchresources.net/java-8-how-to-find-duplicate-in-a-stream-or-list/
 */

//Print Unique and Duplicate element of list using stream.

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

2. Unique elements : 
Meta
Apple
Amazon
Netflix
Google

3. Duplicate elements : 
Meta
Apple

1. Original List with duplicates : 
Meta
Apple
Amazon
Netflix
Meta
Google
Apple

2. Unique elements : 
Netflix
Meta
Google
Apple
Amazon

3. Duplicate elements : 
Meta
Apple

1. Original List with duplicates : 
Meta
Apple
Amazon
Netflix
Meta
Google
Apple

2. Unique elements : 
Netflix
Meta
Google
Apple
Amazon

3. Duplicate elements : 
Meta
Apple

*/ 

import java.util.*;
import java.util.stream.Collectors;

public class PrintUniqueAndDuplicatesInList {
    public static void main(String[] args) {
        // using Stream.distinct() method
        usingDistinct();
        /*
1) Stream.distinct() method eliminates duplicate from Original List and store into new List using collect(Collectors.toList()) method which results into unique list
2) For finding duplicates, iterate through original List and remove elements by comparing elements in unique list and store into new Set using collect(Collectors.toSet()) method which results into duplicate list
         */

        // using Stream.filter() and Collections.frequency() methods
        usingFilterAndFrequency();
        /*
1) Convert Original list into Set using collect(Collectors.toSet()) method which results into new Set with unique elements
2) For finding duplicates, use Stream.filter() method by checking whether Collections.frequency() method returns value greater than 1 or not
    If it is greater than 1, then it means that there are duplicates present in the Original List
    Finally, store those elements into another new Set using collect(Collectors.toSet()) method
         */

        // using Stream.filter() and Set.add() methods
        usingFilterAndAdd();
        /*
1) Create HashSet object to store/add unique elements
2) For finding duplicates,
    use Stream.filter() method by adding elements into newly created HashSet object
    if it returns false then it means that there are duplicates present in the Original List
    finally, store those elements into another new Set using collect(Collectors.toSet()) method
3) By doing this,
    newly created HashSet object will contain only unique elements
    filtered stream contains duplicate elements in another Set
         */
    }

    public static void usingFilterAndAdd() {
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


        // 2. create Set object to store unique elements
        Set<String> distinctCompanies = new HashSet<>();


        // 3. get duplicate elements
        Set<String> duplicateCompanies = companies
                .stream()
                .filter(company -> !distinctCompanies.add(company))
                .collect(Collectors.toSet());


        // 2.1 print unique elements
        System.out.println("\n2. Unique elements : \n");
        distinctCompanies.forEach(System.out::println);


        // 3.1 print duplicate elements
        System.out.println("\n3. Duplicate elements : \n");
        duplicateCompanies.forEach(System.out::println);
    }

    public static void usingFilterAndFrequency() {
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


        // 2. get unique elements after removing duplicates
        Set<String> distinctCompanies = companies
                .stream()
                .collect(Collectors.toSet());


        // 2.1 print unique elements
        System.out.println("\n2. Unique elements : \n");
        distinctCompanies.forEach(System.out::println);


        // 3. get duplicate elements
        Set<String> duplicateCompanies = companies
                .stream()
                .filter(company -> Collections.frequency(companies, company) > 1)
                .collect(Collectors.toSet());


        // 3.1 print duplicate elements
        System.out.println("\n3. Duplicate elements : \n");
        duplicateCompanies.forEach(System.out::println);
    }

    public static void usingDistinct(){
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


        // 2. get unique elements after removing duplicates
        List<String> distinctCompanies = companies
                .stream()
                .distinct()
                .collect(Collectors.toList());


        // 2.1 print unique elements
        System.out.println("\n2. Unique elements : \n");
        distinctCompanies.forEach(System.out::println);


        // 3. get duplicate elements
        for (String distinctCompany : distinctCompanies) {
            companies.remove(distinctCompany);
        }


        // 3.1 print duplicate elements
        System.out.println("\n3. Duplicate elements : \n");
        companies.forEach(System.out::println);
    }
}
