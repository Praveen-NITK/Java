package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
    private int id;
    private List<String> subjects;

    public Student(){}

    public Student(int id, List<String> subjectList){
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
        s1.getSubjects().add("english");
        System.out.println(s1.getSubjects().size());

    }
}
