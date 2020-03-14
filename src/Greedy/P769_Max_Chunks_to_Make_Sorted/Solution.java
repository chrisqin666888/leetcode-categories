package Greedy.P769_Max_Chunks_to_Make_Sorted;

public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = 0;
        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) ans++;
        }

        return ans;
    }
}
