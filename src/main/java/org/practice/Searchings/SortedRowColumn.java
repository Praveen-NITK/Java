//https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
package org.practice.Searchings;

import javax.lang.model.util.ElementScanner6;

public class SortedRowColumn{
    public static void main(String[] args) {
        int [][] input={ { 10, 20, 30, 40 }, 
                        { 15, 25, 35, 45 }, 
                        { 27, 29, 37, 48 }, 
                        { 32, 33, 39, 50 } };
        search(input,29);
    }

    private static void search(int[][] input, int key) {
        int i=0; 
        int j=input.length-1;
        while(i<input.length && j>=0)
        {
            if(input[i][j]==key){
                System.out.println(i+" "+j);
                break;
            }
            else if(input[i][j]>key){
                j--;
            }
            else
                i++;
            // else not found
            
        }
    }
}