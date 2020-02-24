package Recursion_General.P247_Strobogrammatic_Number_II;
import java.util.*;

public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    public List<String> helper(int n, int m) {
        if (n == 0) return new ArrayList<>(Arrays.asList(""));
        if (n == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));

        List<String> temp = helper(n - 2, m);

        List<String> result = new ArrayList<>();

        for(int i = 0; i < temp.size(); i++) {
            String s = temp.get(i);

            if (n != m) result.add("0" + s + "0");

            result.add("1" + s + "1");
            result.add("6" + s + "9");
            result.add("8" + s + "8");
            result.add("9" + s + "6");
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findStrobogrammatic(3));
    }
}
