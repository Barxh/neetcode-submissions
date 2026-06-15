class Solution {
    fun maxProfit(prices: IntArray): Int {
        if(prices.size < 2) return 0
        var i = 0
        var j = 1
        var max = 0
        while(j < prices.size){
            if(prices[i] > prices[j]){
                i = j
                j++
                continue
            }
            max = max(max, prices[j] - prices[i])
            j++
        }
        return max
    }
}
