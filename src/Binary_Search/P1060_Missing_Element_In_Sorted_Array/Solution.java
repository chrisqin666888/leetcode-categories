package Binary_Search.P1060_Missing_Element_In_Sorted_Array;

public class Solution {
    public int missingElement(int[] nums, int k) {
        int len = nums.length;
        int lo = 0, hi = len - 1;
        int countMissing = nums[len - 1] - nums[0] + 1 - len;

        if (countMissing < k) {
            return nums[len - 1] + k - countMissing;
        }

        while (lo < hi - 1) {
            int mid = lo + (hi - lo) / 2;
            int newCountMissing = nums[mid] - nums[lo] - (mid - lo);

            if (newCountMissing >= k) {
                hi = mid;
            } else {
                k -= newCountMissing;
                lo = mid;
            }
        }

        return nums[lo] + k;
    }
}
