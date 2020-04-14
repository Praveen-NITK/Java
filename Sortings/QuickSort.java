package Sortings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort{
    public static void main(String[] args) {
        List<Integer> inputs= new ArrayList<>();
        Integer[] arr=new Integer[]{7,56,32,76,12,56,78,23,978};
        inputs.addAll(Arrays.asList(arr));
        for(Integer data:quiksort(inputs)){
            System.out.println(data);
        }
    }

    private static List<Integer> quiksort(List<Integer> input){
        if(input.size()<2)
            return input;

        Integer pivot=input.get(0);
        List<Integer> lesser=new ArrayList<>();
        List<Integer> larger=new ArrayList<>();

        for(int i=1; i<input.size();i++){
            if(input.get(i)<pivot){
                lesser.add(input.get(i));
            }
            else{
                larger.add(input.get(i));
            }
        }
        List<Integer> sorted= quiksort(lesser);
        sorted.add(pivot);
        sorted.addAll(quiksort(larger));

        return sorted;

    }
}