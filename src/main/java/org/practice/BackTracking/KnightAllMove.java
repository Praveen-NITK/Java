//https://www.geeksforgeeks.org/the-knights-tour-problem-backtracking-1/
package BackTracking;

public class KnightAllMove{
    static int N=8;
    static boolean isSafeMove(int x, int y, int sol[][]){
        return (x>=0 && x<N && y>=0 && y<N && sol[x][y]==-1);
    }

    static void printSolution(int sol[][]){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void solveKnightTour()
    {
        int sol[][]= new int[N][N];
        //Arrays.fill(sol, -1);
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sol[i][j]=-1;
            }
        }

        sol[0][0]=0;

        if(!solveKTUtil(0,0,1,sol)){
            System.out.println("Solution does not exist");
        }else
            printSolution(sol);
    }

    private static boolean solveKTUtil(int x, int y, int moveId, int[][] sol) {
        int x_move[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int y_move[] = {1, 2, 2, 1, -1, -2, -2, -1};

        int next_x, next_y;
        //System.out.print(moveId+" ");
        if(moveId==N*N)
            return true;
        
        for(int k=0;k<N;k++){
            next_x=x+x_move[k];
            next_y=y+y_move[k];

            if(isSafeMove(next_x, next_y, sol)){
                sol[next_x][next_y]=moveId;
                if(solveKTUtil(next_x, next_y, moveId+1, sol)){
                    return true;
                }
                else{
                    sol[next_x][next_y]=-1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        solveKnightTour();
    }
}