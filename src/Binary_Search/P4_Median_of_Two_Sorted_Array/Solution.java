package Binary_Search.P4_Median_of_Two_Sorted_Array;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length, y = nums2.length;

        int low = 0, high = x;
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            // if partitionX is 0 means nothing is on the left side. SO use -INF for maxLeftX
            // if partitionX is the length of the nums1 then there is nothing on the right, so use +INF
            // for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // we have the correct partition place
                // now get max of left and min right
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,3,8,9,15};
        int[] nums2 = {7,11,19,21,24,25};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}
