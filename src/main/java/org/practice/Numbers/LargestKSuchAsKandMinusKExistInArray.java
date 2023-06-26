package org.practice.Numbers;

import java.util.HashSet;
import java.util.Set;

public class LargestKSuchAsKandMinusKExistInArray {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,-2,3,2,-3}));
    }
    static int solution(int []input){
        int ans= 0;
        Set<Integer> intSet= new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            if(intSet.contains(-input[i])){
                ans=Math.max(ans,Math.abs(input[i]));
            }
            intSet.add(input[i]);
        }
        return ans;
    }
}
