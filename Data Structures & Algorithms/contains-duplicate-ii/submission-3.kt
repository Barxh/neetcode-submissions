class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = HashMap<Int, Int>()
        for(i in nums.indices){
            if(map.containsKey(nums[i]) && abs(map.getOrDefault(nums[i], 0) - i) <= k){
                return true
            }else{
                map.put(nums[i], i)
            }
        }
        return false
    }
}
