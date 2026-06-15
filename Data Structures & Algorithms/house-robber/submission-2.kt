class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        return when(n){
            0 -> 0
            1 -> nums[0]
            2 -> max(nums[0], nums[1])
            3 -> max(nums[0] + nums[2], nums[1])
            else ->{
                val stolen = IntArray(n)
                stolen[0] = nums[0]
                stolen[1] = max(nums[1], nums[0])
                stolen[2] = max(nums[0] + nums[2], nums[1])
                for(i in 3 until n){
                    stolen[i] = max( stolen[i - 2] + nums[i], stolen[i - 1])
                }
                stolen[n - 1]
            }
        }
        
    }
}
