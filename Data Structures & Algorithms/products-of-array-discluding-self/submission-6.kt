class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size){1}
        
        for(i in 1 until nums.size){
            result[i] = result[i - 1] * nums[i - 1]
        }
        var acc = nums[nums.lastIndex]
        for(i in nums.lastIndex - 1 downTo 0){
            result[i] *= acc
            acc*= nums[i]
        }
        return result
    }
}
