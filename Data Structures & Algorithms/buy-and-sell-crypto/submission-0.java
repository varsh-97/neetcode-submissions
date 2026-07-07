class Solution {
    public int maxProfit(int[] prices) {
        // at each day, I need to decide if I want to buy/sell that stock
        // in order to max my profit, I need to pick the lowest buy date and the next highest sell
        // TC: O(n), SC: O(1)

        int maxProfit = 0;
        int buy = prices[0];

        for(int i=1; i<prices.length; i++)
        {
            if(buy > prices[i])
            {
                buy = prices[i];
            }
            else
            {
                int profit = prices[i] - buy;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
}
