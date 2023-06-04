package Numbers;

import java.util.Hashtable;
//a^2+b^2=c^2 
public class SquareSumTriplets{
    public static void main(String[] args) {
        int arr[]= new int[]{0,2,2,3,4,5,-3,-4};

        Hashtable<Integer, Integer> ht= new Hashtable<>();
        for (int i = 0; i < arr.length; i++) {
            ht.putIfAbsent(arr[i]*arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int sumOfsquareOfIJ=arr[i]*arr[i]+arr[j]*arr[j];
                if(ht.containsKey(sumOfsquareOfIJ) 
                    && i!=ht.get(sumOfsquareOfIJ) 
                    && j!=ht.get(sumOfsquareOfIJ))
                    {
                    System.out.println(arr[i]+" "+arr[j]+ " "+arr[ht.get(sumOfsquareOfIJ)]);
                }                
            }
        }

    }
}