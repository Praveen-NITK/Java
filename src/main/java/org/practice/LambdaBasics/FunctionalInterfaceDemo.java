package org.practice.LambdaBasics;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * https://javaconceptoftheday.com/java-8-functional-interfaces/
 * //https://javaconceptoftheday.com/java-8-interview-questions-and-answers/
 *
 * 36) What is the difference between map() and flatMap()?
 *
 * Java 8 map() and flatMap() are two important methods of java.util.stream.Stream interface used for transformation or
 * mapping operations. Both are intermediate operations. The only difference is that map() takes Stream<T> as input and
 * return Stream<R> where as flatMap() takes Stream<Stream<T> as input and return Stream<R> i.e flatmap()
 * removes extra layer of nesting around input values.
 */
public class FunctionalInterfaceDemo {
    static class Student {
        int id;
        String name;
        double percentage;
        String specialization;
        public Student(int id, String name, double percentage, String specialization) {
            this.id = id;
            this.name = name;
            this.percentage = percentage;
            this.specialization = specialization;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getPercentage() {
            return percentage;
        }

        public String getSpecialization() {
            return specialization;
        }

        @Override
        public String toString()
        {
            return id+"-"+name+"-"+percentage+"-"+specialization;
        }
    }
    static List<Student> listOfStudents = new ArrayList<Student>();

    public static void main(String[] args) {
        initializeStudent();

//        getMathStudentsWithPredicate();
//        displayPercentageWithConsumer();
//        extractNameFromStudentsWithFunction();
        addStudentWithSupplier();
    }

    private static void addStudentWithSupplier() {
        System.out.println(listOfStudents.size());

        Supplier<Student> studentSupplier = ()->new Student(999,"test",87.98,"computer");
        listOfStudents.add(studentSupplier.get());

        System.out.println(listOfStudents.size());
    }

    private static void extractNameFromStudentsWithFunction() {
        Function<Student, String> nameFunction=(Student student)->student.getName();
        for (Student s:listOfStudents){
            System.out.println(nameFunction.apply(s));
        }
    }

    private static void displayPercentageWithConsumer() {
        Consumer<Student> studentConsumer= (Student student)-> System.out.println(student.getPercentage());
        for(Student s : listOfStudents){
            studentConsumer.accept(s);
        }
    }

    private static void getMathStudentsWithPredicate() {
        Predicate<Student> MathStudent = (Student student)-> student.specialization.equals("Mathematics");
        for (Student s:listOfStudents){
            if(MathStudent.test(s))
                System.out.println(s.getName());
        }
    }

    private static void initializeStudent() {

        listOfStudents.add(new Student(111, "John", 81.0, "Mathematics"));
        listOfStudents.add(new Student(222, "Harsha", 79.5, "History"));
        listOfStudents.add(new Student(333, "Ruth", 87.2, "Computers"));
        listOfStudents.add(new Student(444, "Aroma", 63.2, "Mathematics"));
        listOfStudents.add(new Student(555, "Zade", 83.5, "Computers"));
        listOfStudents.add(new Student(666, "Xing", 58.5, "Geography"));
        listOfStudents.add(new Student(777, "Richards", 72.6, "Banking"));
        listOfStudents.add(new Student(888, "Sunil", 86.7, "History"));
        listOfStudents.add(new Student(999, "Jordan", 58.6, "Finance"));
        listOfStudents.add(new Student(101010, "Chris", 89.8, "Computers"));
    }
}
