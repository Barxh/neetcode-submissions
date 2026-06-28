class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        nums.sort()
        fun findSums(list: List<Int>, listSum: Int, i: Int){
            for(j in i until nums.size){
                when{
                    listSum + nums[j] > target -> return
                    listSum + nums[j] < target -> findSums(list + nums[j], listSum + nums[j], j)
                    else -> res.add(list + nums[j])
                }
            }
        }
        findSums(emptyList(), 0, 0)
        return res
    }
}
