package Array_General.P238_Product_of_Array_Except_Self;

// Time complexity O(n)
// loop the array twice from left to right and right to left
// Space complexity O(1)
// only use constants left and right to store left array and right array product values

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Calculate the left array and store in the result
        int left = 1;
        for(int i = 0; i < n; i++) {
            if (i > 0) {
                left = left * nums[i - 1];
            }
            result[i] = left;
        }

        // Then calculate the right and the product from the end of the array
        int right = 1;
        for(int i = n - 1; i >= 0; i--) {
            if (i < n - 1) {
                right = right * nums[i + 1];
            }
            result[i] = result[i] * right;
        }
        return result;
    }
}
