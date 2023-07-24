package org.practice.BackTracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class NQueenOther {
    static int[] aux;
    static ArrayList<int[]> res;
    final static Integer BOARD_SIZE=4;
    public static void main(String[] args) {
        int [][]board=new int[BOARD_SIZE][BOARD_SIZE];
        aux=new int[board.length];
        res=new ArrayList<>();
        Arrays.fill(aux,-1);

        backTrack(board,0);

        //print the output
        for (int[] arr:res) {
            for (int i = 0; i < arr.length ; i++) {
                //9= to represent a queen in board
                board[i][arr[i]]=9;
            }
            Stream.of(board).map(Arrays::toString).forEach(System.out::println);
            System.out.println("Other possibility");
            board=new int[BOARD_SIZE][BOARD_SIZE];
        }

    }

    private static void backTrack(int[][] board, int row) {
        if (row == board.length) {
            res.add(aux.clone());
            return;
        }
        for (int col = 0; col < board[0].length; col++) {
            if(isSafePlace(row,col,board))
            {
                board[row][col]=1;
                aux[col]=row;

                backTrack(board,row+1);

                board[row][col]=0;
                aux[col]=-1;
            }
        }
    }

    private static boolean isSafePlace(int row, int col, int[][] board) {
        int n = board.length;
        // Check if share the same column
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 1)
                return false;
        }
        // Check if share the same right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1)
                return false;
        }
        // Check if share the same left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }
        return true;
    }
}
