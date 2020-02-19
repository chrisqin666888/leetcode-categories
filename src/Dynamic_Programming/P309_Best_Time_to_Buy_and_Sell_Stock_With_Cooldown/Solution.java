package Dynamic_Programming.P309_Best_Time_to_Buy_and_Sell_Stock_With_Cooldown;

public class Solution {
    public int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE;
        int sold = 0;
        int rest = 0;

        for(int price : prices) {
            int prev_sold = sold;
            sold = hold + price;
            hold = Math.max(hold ,rest - price);
            rest = Math.max(rest, prev_sold);
        }

        return Math.max(rest, sold);
    }
}
