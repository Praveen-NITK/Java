package BackTracking;
//https://www.geeksforgeeks.org/find-number-of-islands/
//Based on Conected Components in a graph
//Either Connected Horizontally Vertically or diagonally
public class CountIslands{
    final static int ROW=5;
    final static int COL=5;
    public static void main(String[] args) {
        int[][] input= {{1,0,0,0,1},
                        {0,1,0,0,1},
                        {1,1,0,0,1},
                        {0,0,0,0,0},
                        {0,0,1,0,1}};
        int count= countIslands(input);
        System.out.println("No of Islands are: "+count);
    }

    private static int countIslands(int[][] input) {
        int isLandCount=0;
        boolean[][] visited= new boolean[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if(!visited[i][j] && input[i][j]==1){
                    isLandCount++;
//                    DFSUtil(i, j, input, visited); // This will make all neighbours visited if 1 exist
                    BFSUtil(i, j, input); // This will make all neighbours visited if 1 exist
                }
            }
            
        }
        return isLandCount;
    }

    private static void DFSUtil(int i, int j, int[][] input, boolean[][] visited) {
        visited[i][j]=true;                      //Make all neighbors visited
        int[] neighbour_x={1,0,-1,0,1,-1,1,-1};
        int[] neighbour_y={0,1,0,-1,1,-1,-1,1};

        for (int k = 0; k < neighbour_y.length; k++) {
            if(isSafe(i+neighbour_x[k],j+neighbour_y[k],input,visited))
                DFSUtil(i+neighbour_x[k],j+neighbour_y[k],input,visited);
        }
    }

    private static boolean isSafe(int i, int j, int[][] input, boolean[][] visited) {
        return i>=0 && i<ROW && j>=0 && j<COL && input[i][j]==1 && !visited[i][j] ;
    }

    private static void BFSUtil(int i, int j, int[][] input) {
        input[i][j]=0;                      //Make all neighbors visited
        int[] neighbour_x={1,0,-1,0,1,-1,1,-1};
        int[] neighbour_y={0,1,0,-1,1,-1,-1,1};

        for (int k = 0; k < neighbour_y.length; k++) {
            if(isSafe2(i+neighbour_x[k],j+neighbour_y[k],input))
                BFSUtil(i+neighbour_x[k],j+neighbour_y[k],input);
        }
    }

    private static boolean isSafe2(int i, int j, int[][] input) {
        return i>=0 && i<ROW && j>=0 && j<COL && input[i][j]==1 ;
    }
}