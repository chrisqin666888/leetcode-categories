package Deque.P239_Sliding_Window_Maximum;

import java.util.*;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) return nums;

        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();

        for(int i = 0; i < nums.length; i++) {
            while (queue.size() > 0 && nums[i] >= nums[queue.getLast()]) {
                queue.removeLast();
            }

            queue.addLast(i);
            if (i - k + 1 >= 0) ans[i - k + 1] = nums[queue.getFirst()];
            if (i - k + 1 >= queue.getFirst()) queue.removeFirst();
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(input, 3)));
    }
}
