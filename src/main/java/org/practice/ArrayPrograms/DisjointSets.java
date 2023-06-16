package org.practice.ArrayPrograms;

/**
 * The three-way set disjointness
 * problem is to determine if the intersection of the three sets is empty, namely, that
 * there is no element x such that x ∈ A, x ∈ B, and x ∈ C.
 */
public class DisjointSets {
    public static void main(String[] args) {
        int[] a= {1,2,3,4,5};
        int[] b= {6,7,8,3,10};
        int[] c= {11,12,3,14};
//    boolean isDisjointSets= isDisjoint(a,b,c);
    boolean isDisjointSets= isDisjointOptimised(a,b,c);
        System.out.println("These are disjoints: "+isDisjointSets);
    }
//O(n^3)
    private static boolean isDisjoint(int[] a, int[] b, int[] c) {
        for (int i:a){
            for (int j:b){
                for (int k:c){
                    if((i==j)&& (i==k))
                        return false;
                }
            }
        }
        return true;
    }
    //O(n^2)
    private static boolean isDisjointOptimised(int[] a, int[] b, int[] c) {
        for (int i:a){
            for (int j:b){
                if(i==j) {
                    for (int k : c) {
                        if ((i == k))
                            return false;
                    }
                }
            }
        }
        return true;
    }

}
