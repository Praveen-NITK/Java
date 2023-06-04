package MustDo.Google;

import java.util.Stack;

public class LongestValidParanthesis{
    public static void main(String[] args) {
        char []input={'(',')','(','(',')',')',')',')',')'};//{')','(',')','(',')',')'};//{'(','(',')','(',')',')',')',')',')',')'};
        int longestValidLength= getLongestValid(input);
        System.out.println(longestValidLength);
    }

    private static int getLongestValid(char[] input) {
        Stack<Character> st= new Stack<>();
        int count=0;
        for (int i = 0; i < input.length; i++) {
            if(input[i]=='('){
                st.push(input[i]);
            }
            else{
                if(st.isEmpty())
                    continue;
                count+=2;
                st.pop();
            }
        }
        return count;
    }
}