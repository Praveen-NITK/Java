package Others;
//Kindle DP code 6.4
//Find the longest substring of given string of digits, such that sum of digits in the first half
//and second half in the substring are the same
public class MaxSubstring{
    public static void main(String[] args) {
        String input="904130";
        int result=getMaxLengthSubstring(input);
        //int result=getMaxLengthSubstringDP(input);
        //int result=maxLengthSustring(input);
        System.out.println(result);
    }

    private static int getMaxLengthSubstring(String input) {
        int n =input.length();
        int maxlength=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j+=2){
                int len=j-i+1;
                if(maxlength>len)
                    continue;
                int lsum=0, rSum=0;
                for(int k=0;k<len/2;k++){
                    lsum+=(input.charAt(i+k)-'0');
                    rSum+=(input.charAt(i+k+len/2)-'0');
                }
                if(lsum==rSum)
                    maxlength=len;
            }
        }
        return maxlength;
    }

    private static int getMaxLengthSubstringDP(String input){
        int n=input.length();
        int [][]sum= new int[n][n];
        int maxlength=0;
        
        for(int i=0;i<n;i++){
            sum[i][i]=input.charAt(i)-'0';
        }

        for(int len=2;len<=n;len++){
            for (int i = 0; i < n-len+1; i++) {
                int j=i+len-1;
                int k=len/2;

                sum[i][j]=sum[i][j-k]+sum[j-k+1][j];

                if(len%2==0 && sum[i][j-k] ==sum[(j-k+1)][j] && len>maxlength ){
                    maxlength=len;
                }
            }            
        }
        return maxlength;

    }

    private static int maxLengthSustring(String input){
        int n=input.length();
        int maxlen=0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j+=2) {
                int len=j-i+1;
                if(len<maxlen){
                    continue;
                }
                else{
                    int lsum=0;
                    int rSum=0;
                    for (int k = 0; k < len/2; k++) {
                        lsum+=input.charAt(i+k);
                        rSum+=input.charAt(i+k+len/2);
                    }
                    if(lsum==rSum){
                        maxlen=len;
                    }
                }
            }
        }
        return maxlen;
    }
}