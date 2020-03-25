package Stack.P456_132_Pattern;

import java.util.Stack;

public class Solution {
    public boolean find132pattern(int[] nums) {
        int third = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for(int i = nums.length; i >= 0; i--) {
            if (nums[i] < third) return true;
            else {
                while(!stack.isEmpty() && nums[i] > stack.peek()) {
                    third = stack.peek();
                    stack.pop();
                }
            }
            stack.push(nums[i]);
        }

        return false;
    }
}
