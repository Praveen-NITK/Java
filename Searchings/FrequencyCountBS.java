//Find frequency count of element in sorted array
package Searchings;
public class FrequencyCountBS{
    public static void main(String[] args) {
        int [] input= {1,1,2,2,3,4,4,4,4,4,4,5,6,6,6,7,7,7};
        int key=4;
        int frequency= getFrequencyOfElementRecursive(input,key,0,input.length-1);
        System.out.format("Frequency of %d is %d times: ",key, frequency);
    }
    static int frequencyCount=0;
	private static int getFrequencyOfElementRecursive(int[] input, int key, int start, int end) {
        if(start>end)
            return 0;        
        int mid=start+(end-start)/2;
        if(input[mid]==key){
            int s_index=mid;
            int e_index= mid;
            while(input[s_index-1]==key){
                s_index=s_index-1;                
            }
            while(input[e_index+1]==key){
                e_index=e_index+1;
            }
            return e_index-s_index+1;
        }
        if(input[mid]>key){
            return getFrequencyOfElementRecursive(input, key, start, mid-1);
        }
        return getFrequencyOfElementRecursive(input, key, mid+1, end);      
    }    
}