package DP;
public class WordEditDistance{
    static String first="abb";
    static String second="bbc";
    public static void main(String[] args) {


        System.out.println(getWordsEditDistanceDP(first,second));
        System.out.println(getMinEditDistance(first.length()-1,second.length()-1));
    }

    /**
     * For each pair
     * if s1[i] == s2[j]:
     *     skip
     *     i, j move forward
     * else:
     *     chose：
     *         enqueue
     *         dequeue
     *         replace
     * @param i
     * @param j
     * @return
     */

    private static int getMinEditDistance(int i, int j){
        if(i==-1) return j+1;
        if(j==-1) return i+1;
        if(first.charAt(i)==second.charAt(j))
            return getMinEditDistance(i-1,j-1); //Skip case
        else {
            return Math.min(Math.min(
                    getMinEditDistance(i,j-1)+1, //Inset
                    getMinEditDistance(i-1,j)+1), //Delete
                    getMinEditDistance(i-1,j-1)+1 //Replace
            );
        }
    }

    private static int getWordsEditDistanceDP(String first, String second){
        int [][]editD=new int[first.length()+1][second.length()+1];

        for (int i = 0; i <= first.length(); i++) {
            editD[i][0]=i;
        }
        for (int j = 0; j <= second.length(); j++) {
            editD[0][j]=j;
        }        
        for (int i = 1; i <= first.length(); i++) {
            for(int j=1;j<=second.length();j++){
                if(first.charAt(i-1)==second.charAt(j-1))
                    editD[i][j]=editD[i-1][j-1];
                else{
                    editD[i][j]=Math.min(Math.min(editD[i-1][j-1],editD[i-1][j]),editD[i][j-1])+1;
                }
            }
        }
        return editD[first.length()][second.length()];
    }
}