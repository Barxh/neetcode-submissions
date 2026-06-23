class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var gasCost = 0
        for(i in gas.indices){
            gasCost+= gas[i] - cost[i]
        }
        if(gasCost < 0) return -1
        var startIndex = 0
        gasCost = 0
        for(i in gas.indices){
            gasCost += gas[i] - cost[i]
            if(gasCost < 0){
                startIndex = i + 1
                gasCost = 0
            }
        }
        
        return startIndex
    }
}
