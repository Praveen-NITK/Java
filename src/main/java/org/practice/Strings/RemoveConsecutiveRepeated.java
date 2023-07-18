package org.practice.Strings;
/**
 * skip if consecutive repeated
 * i/p:aaabbcdygmmmgyebaxx
 * o/p:cdyggyeba
 * final o/p: cdeba
 *
 * b-2
 */
public class RemoveConsecutiveRepeated {
    public static void main(String[] args) {
        String input= "aaabbcdygmmmgyebaxx";
        StringBuilder output=new StringBuilder();

        char last='a';
        int currentCounter=1;
        for (int i = 1; i < input.length() ; i++) {
            char currentChar = input.charAt(i);
            if(last== currentChar){
                currentCounter++;
                last= currentChar;
            }
            else if(currentCounter==1 ){
                appendToOutput(output, last);
                //output.append(last);
                last= currentChar;
            }
            else {
                last = currentChar;
                currentCounter=1;
            }
        }
        System.out.println(output);
    }

    private static void appendToOutput(StringBuilder output, char last) {
        if(output.length()>0 && output.charAt(output.length()-1)== last){
            output.deleteCharAt(output.length()-1);
        }
        else
            output.append(last);
    }
}

