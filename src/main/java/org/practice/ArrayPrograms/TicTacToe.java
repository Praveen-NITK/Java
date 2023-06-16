package org.practice.ArrayPrograms;

import java.util.Arrays;

public class TicTacToe {
    static int[][] board= new int[3][3];
    public static void main(String[] args) {
        Arrays.fill(board,0);
        int sum=0;
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                sum+=board[i][j];
                if(sum==3 || sum==-3){

                }
            }
        }
        System.out.println();
    }
    public boolean isWin(int mark) {
         return ((board[0][0] + board[0][1] + board[0][2] == mark*3) // row 0
         || (board[1][0] + board[1][1] + board[1][2] == mark*3) // row 1
         || (board[2][0] + board[2][1] + board[2][2] == mark*3) // row 2
         || (board[0][0] + board[1][0] + board[2][0] == mark*3) // column 0
         || (board[0][1] + board[1][1] + board[2][1] == mark*3) // column 1
         || (board[0][2] + board[1][2] + board[2][2] == mark*3) // column 2
         || (board[0][0] + board[1][1] + board[2][2] == mark*3) // diagonal
         || (board[2][0] + board[1][1] + board[0][2] == mark*3)); // rev diag
    }
}
