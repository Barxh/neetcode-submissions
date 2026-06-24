class Solution {
    fun canJump(nums: IntArray): Boolean {
        var maxPosition = 0
        for(i in nums.indices){
            if(i > maxPosition || maxPosition >= nums.lastIndex) break
            maxPosition = max(maxPosition, i + nums[i])
        }
        return maxPosition >= nums.lastIndex
    }
}
