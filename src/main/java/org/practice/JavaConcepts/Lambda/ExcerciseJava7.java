package org.practice.JavaConcepts.Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExcerciseJava7{
    public static void main(String[] args) {
        List<Person> personList= new ArrayList<>();
        personList.add(new Person(1, "praveen", "kumar"));
        personList.add(new Person(2, "palak", "agrawal"));
        personList.add(new Person(3, "mukul", "bhattacharya"));
        personList.add(new Person(4, "aditya", "chindo"));


        //Step 1: sort list by last name
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2){
                return p1.getLastName().compareTo(p2.getLastName());
            }
        });

        //Step2: create a method that prints all element in the list
        printAll(personList);

        //Step 3: create a method that prints last name beginning with C
        System.out.println("LastName With C");
        printConditionally(personList, new Condition(){        
            @Override
            public boolean test(Person p) {
                return p.getLastName().startsWith("c");
                
            }        
        });

        System.out.println("First Name With P");
        printConditionally(personList, new Condition(){        
            @Override
            public boolean test(Person p) {
                return p.getFirstName().startsWith("p");
                
            }        
        });

    }

    
    private static void printConditionally(List<Person> personList, Condition condition) {
        for (Person person : personList) {
            if(condition.test(person))
                System.out.println(person.toString());
        }
    }

    private static void printAll(List<Person> personList) {
        for (Person person : personList) {
            System.out.println(person.toString());
        }
    }

    public interface Condition{
        public boolean test(Person p);
    }
}
