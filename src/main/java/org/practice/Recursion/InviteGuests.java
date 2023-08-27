package org.practice.Recursion;
//No of ways to invite guests in single or in pair
public class InviteGuests {
    public static void main(String[] args) {
        int no_of_guests=4;
        int ways= inviteWays(no_of_guests);
        System.out.println(ways);
    }

    private static int inviteWays(int noOfGuests) {
        if(noOfGuests<=0)
            return 0;
        if(noOfGuests==1)
            return 1;
        if (noOfGuests==2)
            return 2;

        //Single - after calling one guest left over guest are n-1
        int single=inviteWays(noOfGuests-1);

        //couple =for one guest no of options to choose couple is n-1
        int couple= (noOfGuests-1)*inviteWays(noOfGuests-2);

        return single+couple;
    }
}
