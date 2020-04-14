package Others;
//can take 1 or 2 steps at a time
public class StepMove
{
    public static void main(String[] args) {
        //int []steps={1,2};
        int ways= countNoOfWays(5);
        System.out.println(ways);
    }

    private static int countNoOfWays(int n) {
        if(n==0)
            return 1;
        if(n==1)
            return 1;
        if(n==2)
            return 2;      
        return countNoOfWays(n-1)+countNoOfWays(n-2);
    }
}