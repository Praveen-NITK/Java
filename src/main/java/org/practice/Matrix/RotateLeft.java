//Rotate Matrix by 90 degree left
//Extra Space: https://www.geeksforgeeks.org/turn-an-image-by-90-degree/
//Inplace: https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
//Inplace2: https://www.geeksforgeeks.org/rotate-matrix-90-degree-without-using-extra-space-set-2/
// Input
//  1  2  3
//  4  5  6
//  7  8  9

// Output:
//  3  6  9 
//  2  5  8 
//  1  4  7 

// Input:
//  1  2  3  4 
//  5  6  7  8 
//  9 10 11 12

// Output:
//  4  8 12 
//  3  7 11 
//  2  6 10 
//  1  5  9

// Input:
//  1  2  3  4 
//  5  6  7  8 
//  9 10 11 12 
// 13 14 15 16 

// Output:
//  4  8 12 16 
//  3  7 11 15 
//  2  6 10 14 
//  1  5  9 13
package org.practice.Matrix;
public class RotateLeft{
    public static void main(String[] args) {
        // int[][] input= {{1,2,3},
        //                 {4,5,6},
        //                 {7,8,9}};
        
        // int[][] input= {{1,2,3,4},
        //                 {5,6,7,8},
        //                 {9,10,11,12},
        //                 {13,14,15,16}};

        // int[][] input= {{1,2,3,4,5},
        //                 {6,7,8,9,10},
        //                 {11,12,13,14,15},
        //                 {16,17,18,19,20},
        //                 {21,22,23,24,25}};

        int[][] input= {{1,2,3,4,5,6},
                        {7,8,9,10,11,12},
                        {13,14,15,16,17,18},
                        {19,20,21,22,23,24},
                        {25,26,27,28,29,30},
                        {31,32,33,34,35,36}};
        int [][] output= rotateMatrix(input);
        inPlaceRotate(input);
        System.out.println();
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[0].length; j++) {
                System.out.print(output[i][j] + " ");                
            }
            System.out.println();            
        }
    }

    private static int[][] rotateMatrix(int[][] input) {        
        int rowLen=input.length;
        int colLen=input[0].length;
        int [][] output= new int[colLen][rowLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {                
                
                //Right Rotation
                output[j][rowLen-1-i]=input[i][j];  //1st row of input becoming last col of output                                                            

                //Left Rotation
                //output[j][i]=input[i][colLen-1-j];   //Last column of input becomes first row of outut
            }
        }       

        return output;
    }

    private static void inPlaceRotate(int[][] input){
        int N=input.length;
        // for (int i = 0; i < input.length-1; i++) {
        //     int temp=input[0][i];
        //     input[0][i]=input[i][N-1];
        //     input[i][N-1]=input[N-1][N-1-i];
        //     input[N-1][N-1-i]=input[N-1-i][0];
        //     input[N-1-i][0]=temp;
        // }
        // for (int i = 1; i < input.length-2; i++) {
        //     int temp=input[1][i];
        //     input[1][i]=input[i][N-2];
        //     input[i][N-2]=input[N-2][N-1-i];
        //     input[N-2][N-1-i]=input[N-1-i][1];
        //     input[N-1-i][1]=temp;
        // }

        for (int i = 0; i < input.length/2; i++) {
            for (int j = i; j < input.length-1-i; j++) {
                int temp=input[i][j];

                // move values from right to top 
                input[i][j]=input[j][N-1-i];

                // move values from bottom to right 
                input[j][N-1-i]=input[N-1-i][N-1-j];

                // move values from left to bottom
                input[N-1-i][N-1-j]=input[N-1-j][i];

                input[N-1-j][i]=temp;
            }
        }      
        

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.print(input[i][j] + " ");                
            }
            System.out.println();            
        }
    }
}
