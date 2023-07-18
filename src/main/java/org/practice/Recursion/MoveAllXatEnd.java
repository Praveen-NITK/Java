package org.practice.Recursion;

public class MoveAllXatEnd {
    public static void main(String[] args) {
        String s= "axbcxdxx";
        moveX(s,0,0,"");

    }

    private static void moveX(String s, int index, int xCount, String newString) {
        if(index==s.length()){
            for (int i = 0; i < xCount; i++) {
                newString+='x';
            }
            System.out.println(newString);
            return;
        }
        if(s.charAt(index)=='x')
            xCount++;
        else
            newString+=s.charAt(index);
        moveX(s,index+1,xCount,newString);
    }
}
