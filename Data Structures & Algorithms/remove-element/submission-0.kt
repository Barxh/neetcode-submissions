class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var k = 0;

        for(i in nums.indices){
            nums[i - k] = nums[i]
            if(nums[i] == `val`){
                k++
            }
        }
        return nums.size - k
    }
}
