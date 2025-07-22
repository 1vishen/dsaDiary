class Solution {
    public int maxProfit(int[] prices) {
        // int maxDiff = 0, tempDiff = 0;
        // for(int i = 0; i < prices.length; i++){
        //     for(int j = i + 1; j < prices.length; j++){
        //         if(prices[j] - prices[i] > 0){
        //             tempDiff = prices[j] - prices[i];
        //             if(tempDiff > maxDiff) maxDiff = tempDiff;
        //         }
        //     }
        // }
        // if(maxDiff == 0) return 0;
        // else return maxDiff;
        int maxDiff = 0, minPrice = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minPrice) minPrice = prices[i];
            else{
                maxDiff = Math.max(prices[i] - minPrice, maxDiff);
            }
        }
        return maxDiff;
    }
}