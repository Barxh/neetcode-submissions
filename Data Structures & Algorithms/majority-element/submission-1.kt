class Solution {
    fun majorityElement(nums: IntArray): Int {
        var candidate = nums[0]
        var freq = 1
        for(i in 1 until nums.size){
            val isCan = nums[i] == candidate
            freq += if(isCan) 1 else -1
            if(freq <= 0) candidate = nums[i]  
        }
        return candidate
    }
}
