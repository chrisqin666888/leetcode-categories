package Binary_Search.P74_Search_In_a_2D_Matrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0) return false;

        int m = matrix.length, n = matrix[0].length;

        int left = 0, right = m * n;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid / n][mid % n] == target) {
                return true;
            } else if (matrix[mid / n][mid % n] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return false;
    }
}
