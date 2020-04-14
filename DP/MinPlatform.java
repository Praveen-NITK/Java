//https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
package DP;
public class MinPlatform{
    public static void main(String[] args) {
        double []arrival={9,9.4,9.5,11,15,18};
        double []departure={9.1,12,11.3,19,20};

        int noOfPlatforms=getNoOfPlatformsNeeded(arrival, departure);
        System.out.println(noOfPlatforms);
    }

    private static int getNoOfPlatformsNeeded(double[] arrival, double[] departure) {
        int platforms=0;
        int i=0;
        int j=0;
        int result=1;
        while(i<arrival.length && j<departure.length){
            if(arrival[i]<departure[j]){
                platforms=platforms+1;
                if(platforms>result)
                    result=platforms;
                i++;
            }
            else{
                platforms=platforms-1;
                j++;
            }
        }
        
        return result;
    }
}