package org.practice.ExceptionHandling;

public class ExceptionTest {
    public static void main(String[] args) {
        int n=10;
        try{
            int t= n/0;
            System.out.println(t);
        }
        catch (Exception ex){
            System.out.println("Exception ");
        }

//        catch (ArithmeticException ex){
//            System.out.println(" Arithmatic");
//        }
    }
}
