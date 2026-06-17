class Solution {
    fun rotate(nums: IntArray, k: Int) {
        val step = k % nums.size
        if(step == 0) return
        var startIndex = step
        var i = step
        var value = nums[0]
        var rotatedNumsCount = 0
        while(rotatedNumsCount < nums.size){
            val pom = nums[i]
            nums[i] = value
            value = pom
            rotatedNumsCount++
            i = (i + step) % nums.size
            if(i == startIndex){
                i++
                startIndex = i
                value = nums[(i-step+nums.size)%nums.size]
            } 
        }
        
    }
}
