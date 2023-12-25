package org.practice.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    static List<List<Integer>> res= new ArrayList<>();
    public static void main(String[] args) {
        int []input={1,2,3};
        ArrayList<Integer> path= new ArrayList<>();
        permute(input,path);
        System.out.println(res); //[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
    }

    /**
     * O (N!)
     * Because exhaustion of the entire decision tree is unavoidable. This is also a feature of backtracking.
     * Unlike dynamic programming having overlapping subproblems which can be optimized,
     * backtracking is purely violent exhaustion, and time complexity is generally high.
     */
    private static void permute(int[] input, ArrayList<Integer> path) {
        if(path.size()==input.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < input.length; i++) {
            if(path.contains(input[i]))
                continue;
            path.add(input[i]);
            permute(input,path);
            path.remove(path.size()-1); // backtracking
        }
    }
}
