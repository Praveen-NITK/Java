package org.practice.org.practice.streamDemo;

import java.util.*;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/
 * https://javaconceptoftheday.com/differences-between-java-8-map-and-flatmap/nnnnnnnnnnnnnnnnnnnnnnnnnnnnmmmmmmmmmmmmnn mnnn aA+AAqQ
 * \`1=` U786U786 1
 */


public class MainDemo {
    public static void main(String[] args) {
//        Stream<String> stringStream= Stream.generate("asa","sa","sdfa");
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee("praveen",34000,"A"));
        empList.add(new Employee("swati",24000,"B"));
        empList.add(new Employee("darsh",14000,"A"));
        empList.add(new Employee("janani",4000,"B"));

//        groupByDepartment(empList);
//        getHighestSalariedEmployee(empList);
//        getLowestSalariedEmployee(empList);
//        countEmployeeByDept(empList);
//        groupByDeptWithCondition(empList);
//        getNameWithCondition(empList);
//        getAverageSalary(empList);
        getTotalAndAverageSalary(empList);

    }

    private static void groupByDepartment(List<Employee> empList) {
        Map<String,List<Employee>> grpByDept=empList.stream().collect(Collectors.groupingBy(Employee::getDept));

        grpByDept.forEach((dept,emp)->{
            System.out.println(dept);
            emp.forEach(employee -> System.out.printf("%s%n",employee));
        });

    }

    private static void getHighestSalariedEmployee(List<Employee> empList) {
        Employee emax= empList.stream().collect(Collectors.maxBy(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.getSalary()-o2.getSalary());
            }
        })).get();
        System.out.println("Max Salary");
        System.out.println(emax);
    }
    private static void getLowestSalariedEmployee(List<Employee> employees){
//        Employee emin= employees.stream().min(new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return (int) (o1.getSalary()-o2.getSalary());
//            }
//        }).get();

        Employee emin= employees.stream().min(Comparator.comparingDouble(Employee::getSalary)).get();
        System.out.println("Min Salary");
        System.out.println(emin);
    }
    private static void countEmployeeByDept(List<Employee> employeeList){
        Map<String, Long> empCountByDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDept, TreeMap::new,Collectors.counting()));
        empCountByDept.forEach((dept,count)->{
            System.out.println(dept+" has "+count);
        });
    }

    private static void groupByDeptWithCondition(List<Employee> employeeList){
        Map<String, List<Employee>> empCountByDept = employeeList.stream().filter(emp->emp.getSalary()>5000).collect(Collectors.groupingBy(Employee::getDept));
        empCountByDept.forEach((dept,employees)->{
            employees.forEach(e-> System.out.println(e));
        });
    }

    private static void getNameWithCondition(List<Employee> employeeList){
        List<String> nameOfEmp=employeeList.stream().filter(e->e.getSalary()>5000)
                .map(p->p.getName()).collect(Collectors.toList());
        nameOfEmp.forEach(name-> System.out.println(name));
    }

    private static void getAverageSalary(List<Employee> empList) {
        Double avgSal= empList.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));

        System.out.println(avgSal);
    }

    private static void getTotalAndAverageSalary(List<Employee> employees){
        DoubleSummaryStatistics doubleSummaryStatistics = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Total Salary"+doubleSummaryStatistics.getSum());
        System.out.println("Avg Salary"+doubleSummaryStatistics.getAverage());
    }

}

