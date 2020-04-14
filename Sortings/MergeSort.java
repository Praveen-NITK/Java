package Sortings;
import java.util.*;

public class MergeSort{
    public static void main(String[] args) {
        Integer arr[]=new Integer[] {7,8,4,6,8,2,1,4,6,9};
        List<Integer> listToSort= new ArrayList<Integer>();
        listToSort.addAll(Arrays.asList(arr));

        for(Integer data:mergeSort(listToSort)){
            System.out.println(data);
        }
    }

    private static List<Integer> mergeSort(List<Integer> listToSort) {
        if(listToSort.size()<2){
            return listToSort;
        }
        int mid=listToSort.size()/2;
        List<Integer> leftList;
        List<Integer> rightList;

        leftList=mergeSort(listToSort.subList(0, mid));
        rightList=mergeSort(listToSort.subList(mid, listToSort.size()));

        return merge(leftList,rightList);
    }

    private static List<Integer> merge(List<Integer> leftList, List<Integer> rightList) {
        int leftPointer=0;
        int rightPointer=0;
        List<Integer> toReturn= new ArrayList<>();
        while(leftPointer<leftList.size() && rightPointer<rightList.size()){
           if(leftList.get(leftPointer)<rightList.get(rightPointer)){
                toReturn.add(leftList.get(leftPointer));
                leftPointer++;
           }
           else{
               toReturn.add(rightList.get(rightPointer));
               rightPointer++;
           }
       }

       while(leftPointer<leftList.size()){
           toReturn.add(leftList.get(leftPointer));
           leftPointer++;
       }

       while(rightPointer<rightList.size()){
           toReturn.add(rightList.get(rightPointer));
           rightPointer++;
       }

       return toReturn;
    }
}
