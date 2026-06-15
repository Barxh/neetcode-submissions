class Solution {
    fun getConcatenation(nums: IntArray): IntArray {
        val ans = IntArray(2 * nums.size)
        for(i in 0 until nums.size){
            ans[i] = nums[i]
            ans[i + nums.size] = nums[i]
        }
        return ans
    }
}
