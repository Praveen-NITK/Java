package Others;
public class CountSetBits{
    public static void main(String[] args) {
        System.out.println(getCountOfSetBits(13));
    }

    private static int getCountOfSetBits(int n) {
        int count=0;
        while(n>0){
            count+=n&1;
            n>>=1;
        }
        return count;
    }
}