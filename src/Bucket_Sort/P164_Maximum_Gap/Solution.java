package Bucket_Sort.P164_Maximum_Gap;

import java.util.Arrays;

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        // get the max and min value of the array
        int min = nums[0];
        int max = nums[0];
        for(int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // the minimum possible gap, ceiling of the integer division
        int gap = (int)Math.ceil((double)(max - min) / (nums.length - 1));
        int[] bucketsMIN = new int[nums.length - 1];
        int[] bucketsMAX = new int[nums.length - 1];
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);

        // put numbers into buckets
        for(int num : nums) {
            if (num == min || num == max) continue;
            int index = (num - min) / gap;
            bucketsMIN[index] = Math.min(num, bucketsMIN[index]);
            bucketsMAX[index] = Math.max(num, bucketsMAX[index]);
        }

        // scan the buckets for max gap
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for(int i = 0; i < nums.length - 1; i++) {
            if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE) continue;
            maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
            previous = bucketsMAX[i];
        }
        maxGap = Math.max(maxGap, max - previous);

        return maxGap;
    }
}
