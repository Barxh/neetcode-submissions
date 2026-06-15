class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        if(cost.size < 3) return if(cost.size == 1) 0 else cost[0]
        val n = cost.size
        val costCount = IntArray(n + 1)
        
        for(i in 2 until n + 1){
            costCount[i] = min(cost[i-1] + costCount[i-1], cost[i-2] + costCount[i-2])
        }
        return costCount[n]
    }
}
