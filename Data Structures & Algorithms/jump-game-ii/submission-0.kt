class Solution {
    fun jump(nums: IntArray): Int {
        if(nums.size < 2) return 0
        var jumps = 0
        var startIndex = 1
        var maxIndex = nums[0]
        while(maxIndex < nums.lastIndex){
            val border = maxIndex + 1
            for(i in startIndex until border){
                maxIndex = max(maxIndex, i + nums[i])
            }
            startIndex = border
            jumps++
        }
        return jumps + 1
    }
}
