package Array_General.P360_Sort_Transformed_Array;

public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {

        for(int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i] * a + nums[i] * b + c;
        }

        int[] res = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;

        if (a > 0) {
            // vally
            int index = res.length - 1;
            while(index >= 0) {
                res[index--] = nums[start] > nums[end] ? nums[start++] : nums[end--];
            }
        } else {
            // peak
            int index = 0;
            while(index < res.length) {
                res[index++] = nums[start] < nums[end] ? nums[start++] : nums[end--];
            }
        }


        return res;
    }
}
