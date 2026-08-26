class Solution {
    public int maxProfit(int[] prices) {
        int min_p = prices[0];
        int max_p = 0;
        for(int i = 1; i < prices.length;i++){
            max_p = Math.max(max_p, prices[i] - min_p);
            min_p = Math.min(min_p,prices[i]);
        }
        return max_p;
    }
}