package org.practice.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextExists {
    public static void main(String[] args) {
        String s= "NAANAAXNABABYNNBZ";
        String word= "BANANA";
        char []input=s.toCharArray();
        Arrays.sort(input);
        List<Character> inpu= Arrays.toString(input).chars().mapToObj(c->(char)c).collect(Collectors.toList());
//        if( inpu.contains('B') && inpu.contains('A') && inpu.contains('N') && inpu.contains('A') && inpu.contains('N') && inpu.contains('A')) {
//            count++;
//            inpu.remove('B');
//        }

//        Binpu.stream().forEach(c-> inpu.contains());
        System.out.println(Arrays.toString(input));
//        int result= 0;
//        if(isText(s))
//            result++;
//        System.out.println(result);result
    }
}
