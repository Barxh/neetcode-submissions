class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        if(nums.size == 0) return 0
        var k = 1
        var i = 1
        var rep = 1
        while(i < nums.size){
            if(nums[i] == nums[i - 1]){
                if(rep < 2){
                    nums[k++] = nums[i]
                    rep++
                }
            }else{
                nums[k++] = nums[i]
                rep = 1
            }
            i++
        }
        return k
    }
}