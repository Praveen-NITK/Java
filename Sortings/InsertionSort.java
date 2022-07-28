package Sortings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class InsertionSort {		

	public static void main(String[] args) {		
		List<Integer> input= new ArrayList<Integer>();		
		Integer[] inputs= new Integer[]{5,78,3,29,87,36,45,13,24,9};
		input.addAll(Arrays.asList(inputs));

		insertionSort(inputs);
		//insertionSortWithLinkedList(input);
	}

	private static void insertionSort(Integer[] input) {
		//Stable sort  -- order of elements doesn't get changed
		for(int i=1;i<input.length;i++){
			int key=input[i];
			int j=i;
											// Finding proper place to insert key by moving j one place next
			while(j>0 && input[j-1]>key){
				input[j]=input[j-1];
				j--;
			}
			input[j]=key;
		}

		// Instable sort logic -- order of elements get changed
		// for (int i = 1; i < input.length; i++) {
		// 	for (int j = 0; j < i; j++) {
		// 		if(input[i]<input[j]){
		// 			int temp=input[i];
		// 			input[i]=input[j];
		// 			input[j]=temp;
		// 		}
		// 	}
		// }

		for (int k=0;k<input.length;k++) {
			System.out.print(input[k]+" ");
		}
	}	

	private static void insertionSortWithLinkedList(List<Integer> input) {
		List<Integer> sortedList=new LinkedList<>();
		OriginalList:for (Integer number:input){
			for(int i=0;i<sortedList.size();i++){
				if(number<sortedList.get(i)){
					sortedList.add(i, number);
					continue OriginalList;
				}
			}
			sortedList.add(number);
		}
		
		for(Integer data:sortedList){
			System.out.println(data);
		}
		
	}	
}
