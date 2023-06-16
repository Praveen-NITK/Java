package org.practice.Stacks;

public class MatchBrackets {
    public static void main(String[] args) {
        String input="()(()){([()])}";
        boolean isMatched=isMatchingBrackets(input);
        System.out.println(isMatched);
    }

    private static boolean isMatchingBrackets(String input) {
        Stack<Character> st= new LinkedListBasedStack<>();
        for (Character ch:input.toCharArray()) {
            String opening = "({[";
            String closing = ")}]";
            if (opening.indexOf(ch) != -1)
                st.push(ch);
            else if (closing.indexOf(ch) != -1) {
                if (st.isEmpty())
                    return false;
                if (opening.indexOf(st.pop()) != closing.indexOf(ch))
                    return false;
            }
        }
        return st.isEmpty();

    }
}
