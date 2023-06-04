package LambdaBasics;

public class WhatIsLambda {
    public static void main(String[] args) {
        StringLengthLambda myLambda = s->s.length();
        System.out.println(myLambda.getLength("praveen"));
    }

    @FunctionalInterface
    interface StringLengthLambda {
        int getLength(String s);
//        void putLength(String s, int t);
    }
}
