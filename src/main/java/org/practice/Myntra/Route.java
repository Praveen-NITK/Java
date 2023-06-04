package Myntra;
public class Route{
    String routeName;
    int distance;
    int maxSpeed;
    int noOfSignals;

    public Route(String rn, int d, int maxS, int signals ){
        routeName=rn;
        distance=d;
        maxSpeed=maxS;
        noOfSignals=signals;
    }
}