package Binary_Search.P1238_Find_the_Smallest_Divisor_Given_a_Threshold;

public class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = (int) 1e6, m, sum;
        while (left < right) {
            m = left + (right - left) / 2;
            sum = 0;

            for (int i : nums) {
                sum += (i + m - 1) / m;
            }

            if (sum > threshold)
                left = m + 1;
            else {
                right = m;
            }
        }

        return left;
    }
}
