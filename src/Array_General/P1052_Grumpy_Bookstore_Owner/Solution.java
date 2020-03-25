package Array_General.P1052_Grumpy_Bookstore_Owner;

public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int len = customers.length;
        int sum = 0;
        for(int i = 0; i < len; i++) {
            if (grumpy[i] == 0) sum += customers[i];
            else grumpy[i] = customers[i];
        }

        int save = 0;

        for(int i = 0; i < X; i++) {
            save += grumpy[i];
        }

        int max = save;
        for(int i = X; i < len; i++) {
            save -= grumpy[i - X];
            save += grumpy[i];
            if (save > max) max = save;
        }
        return sum + max;
    }
}
