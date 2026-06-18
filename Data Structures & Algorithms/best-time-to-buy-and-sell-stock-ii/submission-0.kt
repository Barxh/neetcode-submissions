class Solution {
    fun maxProfit(prices: IntArray): Int {
        if(prices.size < 2) return 0
        var totalProfit = 0
        var i = 0
        var j = 1
        var curProfit = if(prices[i] < prices[j]) prices[j] - prices[i] else 0  
        while(j < prices.size){
            if(prices[j] < prices[j - 1]){
                totalProfit += curProfit
                i = j++
                curProfit = 0
                continue
            }
            if(prices[i] < prices[j]){
                curProfit = max(curProfit, prices[j] - prices[i]) 
            }else{
               totalProfit += curProfit
               curProfit = 0
               i = j 
            }
            j++

        }

        return totalProfit + curProfit
    }
}
