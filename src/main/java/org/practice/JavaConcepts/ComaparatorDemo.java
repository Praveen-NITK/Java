package org.practice.JavaConcepts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComaparatorDemo {
    static class Employee {
        public int inTime;
        public int outTime;

        @Override
        public String toString() {
            return "Employee{" +
                    "inTime=" + inTime +
                    ", outTime=" + outTime +
                    '}';
        }

        public Employee(int in, int out){
            inTime=in;
            outTime=out;
        }

        public int getInTime() {
            return inTime;
        }

        public void setInTime(int inTime) {
            this.inTime = inTime;
        }

        public int getOutTime() {
            return outTime;
        }

        public void setOutTime(int outTime) {
            this.outTime = outTime;
        }

    }

    public static void main(String[] args) {
        Employee e1= new Employee(2,3);
        Employee e2= new Employee(1,4);
        List<Employee> emps=new ArrayList<>();
        emps.add(e1);
        emps.add(e2);
//        emps.sort(Comparator.comparingInt(o -> o.inTime));
//        emps.sort(new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.inTime-o2.inTime;
//            }
//        });
        emps.sort((o1, o2) -> o1.inTime-o2.inTime);
        System.out.println(emps.toString());
    }
}
