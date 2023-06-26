package org.practice.Numbers;

public class MinimumNoOfGlasses {
    static int solution(int no_of_glass, int litres) {
        int ans = 0;
        for (int i = no_of_glass; litres > 0 && i > 0; i--) {
            if (i <= litres) {
                ans++;
                litres -= i;
            }
        }
        return litres == 0 ? ans : -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 8)); // 2
        System.out.println(solution(4, 10)); // 4
        System.out.println(solution(1, 8)); // -1
        System.out.println(solution(10, 5)); // 1
        // N 1..1,000,000
    }

}
