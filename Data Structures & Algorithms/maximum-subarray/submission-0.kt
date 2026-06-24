class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = nums[0]
        var sum = 0
        for(num in nums){
            sum += num
            maxSum = max(maxSum, sum)
            if(sum < 0){
                sum = 0
            }
        }
        return maxSum
    }
}
