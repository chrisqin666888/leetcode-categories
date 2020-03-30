package Greedy.P1167_Minimum_Cost_to_Connect_To_Sticks;

import java.util.PriorityQueue;

public class Solution {
    public int connectSticks(int[] sticks) {
        int res = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int stick : sticks) heap.offer(stick);

        while(heap.size() > 1) {
            int first = heap.poll();
            int second = heap.poll();
            int cost = first + second;

            heap.offer(cost);
            res += cost;
        }

        return res;
    }
}
