class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val backStack = HashMap<Int, MutableList<List<Int>>>()
        backStack[0] = mutableListOf(emptyList())
        for(num in nums){
            for(i in 0 until target){
                if(num + i > target) break
                val lists = backStack[i] ?: continue
                backStack.getOrPut(i + num){mutableListOf()}.addAll(lists.map{ it + num })
            }
        }
        return backStack[target] ?: emptyList()
    }
}
