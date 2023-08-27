package org.practice.Strings;

public class RegexSplit {
    public static void main(String[] args) {
        String input= "  Darsh is a. good boy, isn't it?";
        String []splitted= input.split("[ !,.'?@]");
        System.out.println(splitted.length);
        for (String data:splitted) {
            if(!data.isEmpty())
                System.out.println(data);
        }
    }
}
