package Array_General.P390_Eliminate_Game;

public class Solution {
    public int lastRemaining(int n) {
        boolean left = true;
        int rem = n;
        int step = 1;
        int head = 1;

        while(rem > 1) {
            if (left || rem % 2 == 1) {
                head = head + step;
            }
            rem = rem / 2;
            step = step * 2;
        }

        return head;
    }
}
