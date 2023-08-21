package com.raghib.examples.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeDatabase {
    public static List<Employee> getEmployee(){
        return Stream.of(
                new Employee(101,"Raghib",10000),
                new Employee(102,"Usmani",10000),
                new Employee(103,"Aizah",20000),
                new Employee(102,"Usmani",10000),
                new Employee(102,"Usmani",1000)
        ).collect(Collectors.toList());
    }
}
