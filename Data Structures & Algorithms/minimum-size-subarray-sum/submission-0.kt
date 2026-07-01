class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var res = Int.MAX_VALUE
        var l = 0
        var r = 0
        var curSum = 0
        while(r < nums.size){
            curSum += nums[r]
            while(curSum >= target){
                res = minOf(res, r - l + 1)
                curSum-=nums[l]
                l++
            }
            r++
        }
        return if(res == Int.MAX_VALUE) 0 else res
    }
}
