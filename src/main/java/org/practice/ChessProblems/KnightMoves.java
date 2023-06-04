package ChessProblems;

// Possible moves of knight: (https://www.geeksforgeeks.org/possible-moves-knight/)
// ------------------------
// Given a chess board of dimension m * n. Find number of possible moves where knight can be moved 
// on a chessboard from given position. If mat[i][j] = 1 then the block is filled by something else, 
// otherwise empty. Assume that board consist of all pieces of same color, i.e., there are no blocks 
// being attacked.

public class KnightMoves{

    public static void main(String[] args) {
        int arr[][]=new int[][] {{0,1,0,0},
                                {0,0,1,0},
                                {1,0,0,1},
                                {0,1,1,0}};

        
        int numberOfMoves=conutPossibleMoves(arr,1,0);
        System.out.println(numberOfMoves);
    }

    //#region Better way

    private static int conutPossibleMoves(int[][] arr,int i, int j){
        int X[]={2, 2, -2, -2,  1, -1,  1, -1};
        int Y[]={1,-1,  1, -1,  2,  2, -2, -2};
        int count=0;
        for(int p=0;p<8;p++){
            int x= i+X[p];
            int y= j+Y[p];

            if(x>=0 && y>=0 && x<arr.length && y<arr.length && arr[x][y]==0){
                count++;
            }
        }
        return count;
    }

    //#endregion

}