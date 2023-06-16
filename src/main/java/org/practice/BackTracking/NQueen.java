package org.practice.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
//https://labuladong.gitbook.io/algo-en/iii.-algorithmic-thinking/detailsaboutbacktracking
//In Debug mode output can be visualized
public class NQueen {
    public static List<List<char[]>> res=new ArrayList<>();
    public static void main(String[] args) {
        List<char[]> board= new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            board.add(new char[4]);
        }
        for (char[] c :board){
            Arrays.fill(c,'.');
        }
        backtrack(board,0);
        System.out.println(res);

    }

    private static void backtrack(List<char[]> board, int row) {
        if (row == board.size()) {
            res.add(board);
            return;
        }
        int n = board.size();
        for (int col = 0; col < n; col++) {
            // exclude illegal seletions
            if (!isValid(board, row, col))
                continue;
            // select
            board.get(row)[col]='Q';
            // enter next row decision
            backtrack(board, row + 1);
            // deselect
            board.get(row)[col]='.';
        }
    }

    private static boolean isValid(List<char[]> board, int row, int col) {
        int n = board.size();
        // Check if share the same column
        for (int i = 0; i < n; i++) {
            if (board.get(i)[col] == 'Q')
                return false;
        }
        // Check if share the same right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (board.get(i)[j] == 'Q')
                return false;
        }
        // Check if share the same left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board.get(i)[j] == 'Q')
                return false;
        }
        return true;
    }
}
