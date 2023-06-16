package org.practice.Strings;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder();
        String str= new String();
        sb.append("I want to go home");
        sb.reverse();
        System.out.println(sb.toString());
    }
}
