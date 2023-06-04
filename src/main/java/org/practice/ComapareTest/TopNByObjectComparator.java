package ComapareTest;

import java.util.*;

public class TopNByObjectComparator {
    static class Student {
        String name;
        Integer marks;
        public Student(String n, int m){
            name=n;
            marks=m;
        }

    }
    static class StudentComparator implements Comparator<Student>{
        @Override
        public int compare(Student s1, Student s2) {
            return s2.marks-s1.marks;
        }

    }

    public static void main(String[] args) {
        List<Student> studentList= new ArrayList<>();
        studentList.add(new Student("ram",4));
        studentList.add(new Student("raj",5));
        studentList.add(new Student("kishore",2));

//        Collections.sort(studentList, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o2.marks-o1.marks;
//            }
//        });

        Comparator<? super Student> StudentComparator= new StudentComparator();
        Collections.sort(studentList, StudentComparator);
        for (int i = 0; i < 2; i++) {
            System.out.println(studentList.get(i).name+" "+studentList.get(i).marks);
        }
    }
}
