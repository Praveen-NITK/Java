package DP;
public class WordEditDistance{
    public static void main(String[] args) {
        String first="abb";
        String second="bbc";

        System.out.println(getWordsEditDistance(first,second));
        System.out.println(getWordsEditDistanceDP(first,second));
    }

    private static int getWordsEditDistance(String first, String second) {
        if(first.isEmpty() && !second.isEmpty())
            return second.length();
        if(!first.isEmpty() && second.isEmpty())
            return first.length();
        if(first.isEmpty() && second.isEmpty())
            return 0;
        if(first.charAt(0)==second.charAt(0))
            return getWordsEditDistance(first.substring(1), second.substring(1));
        else{
            int d=getWordsEditDistance(first.substring(1), second); //delete from first
            int i=getWordsEditDistance(first, second.substring(1)); //insert in second
            int u=getWordsEditDistance(first.substring(1), second.substring(1)); //update in second
            return Math.min(Math.min(d, i),u)+1;
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