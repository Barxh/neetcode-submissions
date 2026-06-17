class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        var l = 0
        var r = arr.size - 1
        while(r - l >= k){
            if(abs(x - arr[l]) > abs(arr[r] - x)){
                l++
            }else r--
        }
        return arr.slice(l..r)
    }
}
