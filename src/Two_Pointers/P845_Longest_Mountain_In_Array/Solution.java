package Two_Pointers.P845_Longest_Mountain_In_Array;

public class Solution {
    public int longestMountain(int[] A) {
        int len = A.length;
        if (len < 3) return 0;

        int left = 0;
        int right;
        int maxLen = 0;

        while(left < len - 2) {
            while (left + 1 < len && A[left] >= A[left + 1]) {
                left++;
            }

            right = left + 1;
            while (right + 1 < len && A[right] < A[right + 1]) {
                right++;
            }

            while (right + 1 < len && A[right] > A[right + 1]) {
                right++;
                maxLen = Math.max(maxLen, right - left + 1);
            }

            left = right;
        }

        return maxLen;
    }
}
