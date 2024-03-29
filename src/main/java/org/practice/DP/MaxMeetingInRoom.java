package org.practice.DP;
//https://www.geeksforgeeks.org/find-maximum-meetings-in-one-room/
import java.util.*;
//Greedy Approach
class mycomparator implements Comparator<meeting>
{
    @Override
    public int compare(meeting o1, meeting o2)
    {
        if (o1.end < o2.end)
        {

            // Return -1 if second object is
            // bigger then first
            return -1;
        }
        else if (o1.end > o2.end)

            // Return 1 if second object is
            // smaller then first
            return 1;

        return 0;
    }
}

// Custom class for storing starting time,
// finishing time and position of meeting.
class meeting
{
    int start;
    int end;
    int pos;

    meeting(int start, int end, int pos)
    {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

public class MaxMeetingInRoom{

    public static void maxMeeting(ArrayList<meeting> al, int s)
    {

        ArrayList<Integer> m = new ArrayList<>();
        int time_limit = 0;

        mycomparator mc = new mycomparator();
        Collections.sort(al, mc);

        m.add(al.get(0).pos);

        time_limit = al.get(0).end;

        for(int i = 1; i < al.size(); i++)
        {
            if (al.get(i).start > time_limit)
            {
                m.add(al.get(i).pos);
                time_limit = al.get(i).end;
            }
        }

        // Print final selected meetings.
        for(int i = 0; i < m.size(); i++)
            System.out.print(m.get(i) + 1 + " ");
    }

    // Driver Code
    public static void main (String[] args)
    {

        // Starting time
        int s[] = { 1, 3, 0, 5, 8, 5 };

        // Finish time
        int f[] = { 2, 4, 6, 7, 9, 9 };

        ArrayList<meeting> meet = new ArrayList<>();
        for(int i = 0; i < s.length; i++)
            meet.add(new meeting(s[i], f[i], i));

        maxMeeting(meet, meet.size());
    }
}

// This code is contributed by Sarthak Sethi
