package ZJio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TopStudent {
    public static void main(String[] args) {
        List<Student> students= new ArrayList<>();
        students.add(new Student(){{marks=4;name="raj";}});
        students.add(new Student(){{marks=5;name="ram";}});
        students.add(new Student(){{marks=2;name="kishore";}});

//        students.sort(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o2.marks-o1.marks;
//            }
//        });

        //System.out.println(students);

        Comparator studentComparator=new StudentComparator();
        Collections.sort(students,studentComparator);

        System.out.println(students);
    }
}
