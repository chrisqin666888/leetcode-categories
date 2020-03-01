package Greedy.P1353_Maximum_Number_Of_Events_That_can_be_Attented;
import java.util.*;

public class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int count = 0;
        boolean[] attended = new boolean[100001];

        for (int[] event : events)
            for (int i = event[0]; i <= event[1]; i++)
                if (attended[i] == false) {
                    attended[i] = true;
                    count++;
                    break;
                }


        return count;
    }
}
