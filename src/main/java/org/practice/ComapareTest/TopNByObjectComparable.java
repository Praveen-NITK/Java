package org.practice.ComapareTest;

import java.util.*;

public class TopNByObjectComparable {
    static class Student implements Comparable<Student>{
        String name;
        Integer marks;
        public Student(String n, int m){
            name=n;
            marks=m;
        }


        @Override
        public int compareTo(Student s1) {
            return s1.marks-this.marks;
        }
    }


    public static void main(String[] args) {
        Student []studentList= {new Student("ram",4),new Student("raj",5),new Student("kishore",2)};
        Arrays.sort(studentList);


        for (int i = 0; i < 2; i++) {
            System.out.println(studentList[i].name+" "+studentList[i].marks);
        }
    }
}
