class Solution {
    fun mySqrt(x: Int): Int {
        var r = x
        var l = 0
        while(r > l){
            val curr = r - (r - l)/2
            val res = x/curr
            when{
                res > curr -> l = curr
                res < curr -> r = curr - 1
                else -> return curr
            }
        }
        return l
    }
}
