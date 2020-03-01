package Binary_Search.P1351_Count_Negative_Numbers_in_A_Sorted_2D_Array;

public class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int result = 0, last_negative = n - 1;

        for(int row = 0; row < m; row++) {
            // if first element is < 0, all elements in the row are negative
            if (grid[row][0] < 0) {
                result += n;
                continue;
            }
            // if last element is > 0, all elements in the row are positive
            if (grid[row][n - 1] > 0) {
                continue;
            }
            // we don't know the boundaries, use binary search to find it
            int left = 0, right = last_negative;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if (grid[row][mid] < 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            result += n - left;
            last_negative = left;
        }
        return result;
    }
}
















