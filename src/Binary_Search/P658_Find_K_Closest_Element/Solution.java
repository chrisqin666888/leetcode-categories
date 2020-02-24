package Binary_Search.P658_Find_K_Closest_Element;
import java.util.*;

public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x > arr[mid]) {
                if (x - arr[mid] > arr[mid + k] - x) {
                    left++;
                } else {
                    right = mid;
                }
            } else {
                right = mid;
            }
        }
        int idx = left;
        while(k != 0) {
            result.add(arr[idx++]);
            k--;
        }
        return result;
    }
}
