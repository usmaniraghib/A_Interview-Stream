package com.raghib.examples.stream;

import java.util.List;
import java.util.stream.Collectors;

//select *from employee where 2 in (select distinct(salary) *from employee where rownum=2 );

//max(salary)
	
//select name, avg(salary) as "AVERAGE SALARY" from employee

public class EmployeeOperation {
    public static void main(String[] args) {
        List<String> names = EmployeeDatabase.getEmployee()
                .stream()
                .filter(emp -> emp.getSalary() > 1000)
                .map(Employee::getName)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Names are : ");
        System.out.println(names);
    }
}
