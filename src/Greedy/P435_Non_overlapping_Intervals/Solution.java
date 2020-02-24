package Greedy.P435_Non_overlapping_Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int end = intervals[0][1];
        int count = 0;
        for(int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
            } else {
                count++;
            }
        }
        return count;
    }
}
