package Anagrams;
public class CheckIfAnagram{
    public static void main(String[] args) {
        String s1="LISTEN";
        String s2="SILENT";
        boolean isAnagram=checkIfAnagram(s1,s2);
        System.out.println("Both words are anagram: "+isAnagram);
    }

    private static boolean checkIfAnagram(String s1, String s2) {
        if(s1.length()!=s2.length())
            return false;
        int []arr= new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i)-'A']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            if(--arr[s2.charAt(i)-'A']!=0)
                return false;
        }
        return true;
    }
}