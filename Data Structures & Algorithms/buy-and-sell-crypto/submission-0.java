class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int maxProfit = 0;
        int minPrice = 0;
        int i = 0;
        int j = 1;
        while(i < prices.length -1){
            if(prices[i] > prices[i+1]){
                i++;
                j = i+1;
                continue;
            }


            if(maxProfit < prices[j] - prices[i]){
                maxProfit = prices[j] - prices[i];
                minPrice = prices[i];
            }
            j++;
            if(j == prices.length){
                i++;
                j = i + 1; 
            }
        }


        return maxProfit;
    }
}
