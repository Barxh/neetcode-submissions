class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        if(cost.size < 3) return cost[0]
        val n = cost.size
        val costCount = IntArray(n)
        
        for(i in 2 until n){
            costCount[i] = min(cost[i-1] + costCount[i-1], cost[i-2] + costCount[i-2])
        }
        return min(cost[n-1] + costCount[n-1], cost[n-2] + costCount[n-2])
    }
}
