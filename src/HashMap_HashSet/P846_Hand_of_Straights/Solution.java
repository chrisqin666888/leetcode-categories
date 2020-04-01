package HashMap_HashSet.P846_Hand_of_Straights;
import java.util.*;

public class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        Map<Integer, Integer> c = new TreeMap<>();
        for (int i : hand) c.put(i, c.getOrDefault(i, 0)+1);
        Queue<Integer> start = new LinkedList<>();
        int last_checked = -1, opened = 0;
        for (int i : c.keySet()) {
            if (opened > 0 && i > last_checked + 1 || opened > c.get(i)) return false;
            start.offer(c.get(i) - opened);
            last_checked = i; opened = c.get(i);
            if (start.size() == W) opened -= start.poll();
        }
        return opened == 0;
    }
}
