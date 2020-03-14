package Array_General.P334_Increasing_Triplet_Subsequence;

public class Solution {
	public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= min) min = num;
            else if(num < secondMin) secondMin = num;
            else if(num > secondMin) return true;
        }
        return false;
    }
	
	public static void main(String[] args) {
		int[] input = {1,2,4,8};
		Solution solution = new Solution();
		System.out.println(solution.increasingTriplet(input));
	}
}
