package org.practice.JavaConcepts;

public class SwapObjects {
    public static class Employee{
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Employee emp1= new Employee();
        emp1.setName("Ram");

        Employee emp2= new Employee();
        emp2.setName("Raj");

//        swapEmployeeName(emp1, emp2);
        System.out.println("emp1.name "+emp1.name);
        System.out.println("emp2.name "+emp2.name);

        swapEmployeeObjs(emp1, emp2);
        System.out.println("emp1.name "+emp1.name);
        System.out.println("emp2.name "+emp2.name);
    }

    private static void swapEmployeeObjs(Employee e1, Employee e2) {
        Employee temp=e1;
        e1=e2;
        e2=temp;
    }

    private static void swapEmployeeName(Employee e1, Employee e2) {
        String temp=e1.getName();
        e1.setName(e2.getName());
        e2.setName(temp);
    }

}
