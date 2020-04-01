package TreeMap.P846_Hand_of_Straights;

import java.util.TreeMap;

public class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int card : hand) map.put(card, map.getOrDefault(card, 0) + 1);

        while(map.size() > 0) {
            int start_val = map.firstKey();

            for(int card = start_val; card < start_val + W; card++) {
                if (!map.containsKey(card)) return false;

                int count = map.get(card);
                if (count == 1) map.remove(card);
                else {
                    map.replace(card, count - 1);
                }
            }
        }

        return true;
    }
}
