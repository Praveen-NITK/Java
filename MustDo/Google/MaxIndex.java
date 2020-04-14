//https://practice.geeksforgeeks.org/problems/maximum-index/0
//https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
//Amazon 
package MustDo.Google;
public class MaxIndex{
    public static void main(String[] args) {
        int []input={34,8,10,3,2,8,6,3,1};//{304,8,10,3,2,80,3,6,7};
        printMaxIndex(input);
        int diff= MaxDifference(input);
        System.out.println(diff);
    }
//Condition: for i<j ---> A[i]< A[j] and j-i sould be maximum
//sample: {34,8,10,3,2,80,30,33,1} --> ans 6(7-1) -->A[1] > A[7]
    //BruteForce
    private static void printMaxIndex(int[] input) {        
        int maxDiff = -1; 
        int i, j; 
  
        for (i = 0; i < input.length; ++i)  
        { 
            for (j = input.length - 1; j > i; --j)  
            { 
                if (input[j] > input[i] && maxDiff < (j - i)) 
                    maxDiff = j - i; 
            } 
        } 
  
        System.out.println(maxDiff);  
    }

    //Correct one
    private static int maxIndexDiff_(int[] arr) 
    {
		int size = arr.length;
		int[] lMin = new int[size];
		int[] rMax = new int[size];
		
		lMin[0]=arr[0];
		rMax[size-1]=arr[size-1];
		for(int i=1; i<size;i++){			
            lMin[i]=Math.min(arr[i], lMin[i-1]);
		}
		for(int j=size-2;j>=0;j--){			
            rMax[j]=Math.max(arr[j], rMax[j+1]);
		}
		int i=0,j=0;
        int maxDiff = -1;
        int index_i=-1;
        int index_j=-1;
		while(i<size && j<size){
			if(lMin[i]<rMax[j]){
                if(j-i>maxDiff){
                    maxDiff =j-i;//= Math.max(maxDiff, j-i);
                    index_i=i;
                    index_j=j;                    
                }
                j++;
			}
			else
				i++;
        }
        System.out.println(index_i+ " "+index_j);
		return maxDiff;
	}

    private static int MaxDifference(int []input){
        int n=input.length;
        int []leftMin=new int[n];
        int []rightMax= new int[n];
        leftMin[0]=input[0];
        rightMax[n-1]=input[n-1];

        for (int i = 1; i < n; i++) {
            leftMin[i]=Math.min(input[i], leftMin[i-1]);
        }

        for (int j = n-2; j >=0; j--) {
            rightMax[j]=Math.max(input[j], rightMax[j+1]);
        }

        int i=0,j=0;
        int maxDiff=-1;
        while(i<n && j<n){
            if(leftMin[i]<rightMax[j]){
                maxDiff=Math.max(maxDiff, j-i);
                j++;
            }
            else{
                i++;
            }
        }
        return maxDiff;

    }
}