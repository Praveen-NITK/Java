package org.practice.JavaConcepts;

import test.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomisedImmutable {
    private int id;
    private List<String> subjects;

    public CustomisedImmutable(){}

    public CustomisedImmutable(int id, List<String> subjectList){
        this.id=id;
        subjects= Collections.unmodifiableList(subjectList);
    }
    public int getId(){
        return id;
    }
    public List<String> getSubjects(){
        return subjects;
    }

    public static void main(String[] args) {
        List<String> subList= new ArrayList<>();
        subList.add("math");
        subList.add("physics");
        Student s1= new Student(1,subList);
        try{
            s1.getSubjects().add("english");
        }catch (UnsupportedOperationException e){
            System.out.println("Its not allowed to modify immutable");
        }
        System.out.println(s1.getSubjects().size());

    }
}
