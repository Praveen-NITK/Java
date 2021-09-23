//https://www.geeksforgeeks.org/rat-in-a-maze-problem-when-movement-in-all-possible-directions-is-allowed/
//#region Question
// Input : N = 4
// 1 0 0 0 
// 1 1 0 1 
// 0 1 0 0 
// 0 1 1 1
// Output :
// DRDDRR
// On following the path DRDDRR ,the rat can reach the bottom right of the maze.



// Input :N = 4
// 1 0 0 0 
// 1 1 0 1 
// 1 1 0 0 
// 0 1 1 1
// Output :
// DDRDRR DRDDRR
//#endregion

package BackTracking;

public class RatInMaze{
    static String moves="";

    public static void main(String[] args) {
        int[][] input = {{1,0,0,0},
                        {1,1,0,1},
                        {0,1,0,0},
                        {0,1,1,1}};
        // String output="DRDDRR DDRDRR ";
        // if(output.equals(getMazeMovement(input))){
        //     System.out.println("Correct!!");
        // }
        // else
        //     System.out.println("Incorrect!!");
        System.out.println(getMazeMovement(input));
    }

    private static boolean isSafeMove(int i, int j, int N, boolean [][]visited, int[][]input){
        return i>=0 && i<N && j>=0 && j<N && !visited[i][j] && input[i][j]==1;
    }

    private static String getMazeMovement(int[][] input) {

        boolean visited[][]= new boolean[input.length][input.length];
        //Arrays.fill(visited, false);

        int []Move_X={0,1,0, -1};
        int []Move_Y={1,0,-1,0};
        String [] direction={"R","D","L","U"};

        

        // for (int i = 0; i < input.length; i++) {
        //     for (int j = 0; j < input.length; j++) {
        //         if(input[i][j]==1 && !visited[i][j]){
        //             DFSUtil(i,j,Move_X, Move_Y,direction, visited,input, input.length,"");
        //         }
        //     }            
        // }

        //As given that Rat is at location (0,0)
        DFSUtil(0,0,Move_X, Move_Y,direction, visited,input, input.length,"");
        return moves;
    }    
    private static void DFSUtil(int i, int j, int[] move_X, int[] move_Y, String [] direction, boolean[][] visited, int[][] input,int N, String mov) {
        visited[i][j]=true;
        if(i==N-1 && j==N-1){
            moves+=mov+" ";
        }            
        
        for (int k = 0; k < move_X.length; k++) {
            if(isSafeMove(i+move_X[k], j+move_Y[k], N, visited, input)){
                DFSUtil(i+move_X[k], j+move_Y[k], move_X,move_Y,direction, visited, input,N, mov+direction[k]);                
            }            
        }
        visited[i][j]=false;              
    }
}