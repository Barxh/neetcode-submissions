class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var fast = 0
        var slow = 0
        do{
            fast = nums[nums[fast]]
            slow = nums[slow]
        }while(fast != slow)
        
        var begin = 0
        while(begin != slow){
            begin = nums[begin]
            slow = nums[slow]
        }
        return begin
    }
}
