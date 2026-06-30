class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        val res = mutableListOf<List<Int>>()
        fun findSums(idx: Int, path: MutableList<Int>, curSum: Int){
            for(i in idx until nums.size){
                when{
                    curSum + nums[i] < target -> {
                        path.add(nums[i])
                        findSums(i, path, curSum + nums[i])
                        path.remove(nums[i])
                    }
                    curSum + nums[i] > target -> break
                    else -> {
                        res.add(ArrayList(path).apply{ add(nums[i]) })
                        break
                    }
                }
            }
        }
        findSums(0, mutableListOf(), 0)
        return res
    }
}
