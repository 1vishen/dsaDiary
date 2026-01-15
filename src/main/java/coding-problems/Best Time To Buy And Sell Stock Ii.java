class Solution {
    public int maxProfit(int[] prices) {
        /* no need to track a min, if we have next element greater than current add the diff to profit and move on */

        int profit = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            if(prices[i + 1] > prices[i]) profit += prices[i + 1] - prices[i];
        }
        return profit;
    }
}
