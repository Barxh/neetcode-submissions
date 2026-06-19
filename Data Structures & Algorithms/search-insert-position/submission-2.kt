class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex
        
        while(left < right){
            val nextIndex = right - (right - left)/2
            
            if(nums[nextIndex] > target){
                if(nextIndex != 0 && nums[nextIndex - 1] < target){
                    return nextIndex
                }else{
                    right = nextIndex - 1
                }
            }else{
                if(nums[nextIndex] == target) return nextIndex
                left = nextIndex
            }
        }

        return if(left == 0){
            if(nums[0] >= target) 0 else 1
        }else nums.size
    }
}
