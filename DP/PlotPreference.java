package DP;
//https://www.youtube.com/watch?v=rw4s4M3hFfs
import java.util.Arrays;

/**
 * Suppose you have given a json of plots:
 * plot[
 * {
 *     "gym":false,
 *     "school":true,
 *     "mart":false
 * },
 * {
 *      "gym":true,
 *      "school":false,
 *      "mart":false
 *  },
 *  {
 *      "gym":true,
 *      "school":true,
 *      "mart":false
 *  },
 *  {
 *     "gym":false,
 *     "school":true,      ==> in this case this plot should be the answer as its at most 1 distance from all these choices
 *     "mart":false
 * },
 * {
 *     "gym":false,
 *     "school":true,
 *     "mart":true
 * }
 * ]
 * and choices ["gym","school","mart"]
 * you need to find most suitable plot so that its nearer to these choices
 */
//Draw a solution matrix plot_distances of 5*4 then run it
public class PlotPreference {
    public static void main(String[] args) {
        int [][]plot={
                {0,1,0},
                {1,0,0},
                {1,1,0},
                {0,1,0},
                {0,1,1}
        };
        int []choices={0,1,2};

        int preferredPlot=selectPreferredPlot(plot,choices);
        System.out.println("preferred plot is "+preferredPlot);
    }

    private static int selectPreferredPlot(int[][] plot, int[] choices) {
        //int result= Integer.MAX_VALUE;
        int no_of_plots = plot.length;
        int no_of_choices = choices.length;
        int [][]plot_distances=new int[no_of_plots][no_of_choices+1]; //5*4

        for (int j = 0; j <no_of_plots ; j++) {
            Arrays.fill(plot_distances[j], Integer.MAX_VALUE);
        }


        for (int i = 0; i <no_of_choices ; i++) {
            if(plot[0][i]==1)
                plot_distances[0][i]=0;
        }

        //Forward direction
        for (int i = 1; i <no_of_plots ; i++) {
            plot_distances[i][no_of_choices]=0;
            for (int j = 0; j <no_of_choices ; j++) {
                if(plot[i][j]==1)
                    plot_distances[i][j]=0;
                else {
                    if(plot_distances[i-1][j]!=Integer.MAX_VALUE)
                        plot_distances[i][j]=Math.min(plot_distances[i-1][j]+1,plot_distances[i][j]);
                }
                plot_distances[i][no_of_choices]=Math.max(plot_distances[i][no_of_choices],plot_distances[i][j]);
            }
        }

        //Backward direction
        for (int i = no_of_plots-2; i >=0 ; i--) {
            plot_distances[i][no_of_choices]=0;
            for (int j = 0; j <no_of_choices ; j++) {
                if(plot[i][j]==1)
                    plot_distances[i][j]=0;
                else {
                    if(plot_distances[i+1][j]!=Integer.MAX_VALUE)
                        plot_distances[i][j]=Math.min(plot_distances[i+1][j]+1,plot_distances[i][j]);
                }
                plot_distances[i][no_of_choices]=Math.max(plot_distances[i][no_of_choices],plot_distances[i][j]);
                //result=Math.min(result,plot_distances[i][no_of_choices]);
            }
        }


        //Now to get the plot index for minimum distance
        int index = 0;
        int min = plot_distances[index][no_of_choices];

        for (int i = 1; i < no_of_plots; i++){
            if (plot_distances[i][no_of_choices] < min){
                min = plot_distances[i][no_of_choices];
                index = i;
            }
        }
        return index;
    }
}
