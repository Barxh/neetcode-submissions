class Solution {
    fun maxArea(heights: IntArray): Int {
        var l = 0
        var r = heights.size - 1
        var max = 0
        while(l < r){
            val water = (r-l) * min(heights[l], heights[r])
            if(max < water) max = water
            if(heights[l] > heights[r]) r--
            else l++
        }
        return max
    }
}
