package Numbers;

public class DivisibleByFour {
    public static void main(String[] args) {
//        String input="5810438124";
        String input="224";
        //1,12,24, 124
        int result= checkDivisibilityCountByFour(input);
        System.out.println("result is "+result);
    }
    private static int checkDivisibilityCountByFour(String num){
        int divisibilityCount=0;
        int n= num.length();
        if(n==0)
            return 0;
        else if(n==1 && num.charAt(0)%4==0)
            return 1;
        else if(n==2 ) {
            if (num.charAt(1) * 10 + num.charAt(0) % 4 == 0 )
                divisibilityCount += 1;
            if(num.charAt(0) % 4 == 0)
                divisibilityCount += 1;
            if(num.charAt(1) % 4 == 0)
                divisibilityCount += 1;
        }
        for (int i = n-1; i >0 ; i--) {
            int number=num.charAt(i-1)*10+num.charAt(i);
            if(number%4==0){
                divisibilityCount=divisibilityCount+i;
            }
        }
        return divisibilityCount;
    }
}
