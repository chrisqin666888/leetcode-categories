package Binary_Search.P1011_Capacity_to_Ship_Packages;

public class Solution {
    public int shipWithDays(int[] weights, int D) {
        int sum = 0;
        for(int w : weights) {
            sum += w;
        }

        int left = 1;
        int right = sum;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isValidWeight(weights, D, mid)){
                right = mid;
            } else {
                left = mid;
            }
        }
        return isValidWeight(weights, D, left) ? left : right;
    }

    private boolean isValidWeight(int[] weights, int D, int shipWeight) {
        int days = 0;
        int currentWeights = 0;

        for(int i = 0; i < weights.length; i++) {
            if (weights[i] > shipWeight)
                return false;
            if (currentWeights + weights[i] > shipWeight) {
                days++;
                currentWeights = weights[i];
            } else {
                currentWeights += weights[i];
            }
            if (days > D) {
                return false;
            }
        }

        days++;
        return days <=D;
    }
}
