package Sliding_Window.P1004_Maximum_Consecutive_Ones_III;

public class Solution {
    public int longestOnes(int[] A, int K) {
        int lo = 0, hi = 0;
        int preSum = 0;
        int n = A.length;

        int res = 0;
        for(hi = 0; hi < n; hi++) {
            preSum += (A[hi] == 0 ? 1 : 0);

            if (preSum > K) {
                while(lo < hi && A[lo] == 1) {
                    lo++;
                }
                preSum -= 1;
                lo++;
            }
            if (hi - lo + 1 > res) {
                res = hi - lo + 1;
            }
        }

        return res;
    }
}
