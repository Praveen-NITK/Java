package org.practice.JavaConcepts.Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class ExcerciseJava8{
    public static void main(String[] args) {
        List<Person> personList= Arrays.asList(
        new Person(1, "praveen", "kumar"),
        new Person(2, "palak", "agrawal"),
        new Person(3, "mukul", "bhattacharya"),
        new Person(4, "aditya", "chindo"));


        //Step 1: sort list by last name
        Collections.sort(personList, (p1,p2)->p1.getLastName().compareTo(p2.getLastName()));

        //Step2: create a method that prints all element in the list
        //printConditionally(personList, p->true);
        performConditionally(personList,p->true, p->System.out.println(p));

        //Step 3: create a method that prints last name beginning with C
        System.out.println("LastName With C");
        printConditionally(personList, p->p.getLastName().startsWith("c"));

        System.out.println("First Name With P");
        printConditionally(personList, p->p.getFirstName().startsWith("p"));

    }
    
    // private static void printConditionally(List<Person> personList, Condition condition) {
    //     for (Person person : personList) {
    //         if(condition.test(person))
    //             System.out.println(person.toString());
    //     }
    // }

    private static void printConditionally(List<Person> personList, Predicate<Person> predicate) {
        for (Person person : personList) {
            if(predicate.test(person))
                System.out.println(person.toString());
        }
    }

    private static void performConditionally(List<Person> personList, Predicate<Person> predicate, Consumer<Person> c) {
        for (Person person : personList) {
            if(predicate.test(person))
                c.accept(person);
        }
    }
}
