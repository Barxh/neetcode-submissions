class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        val result = LinkedList<Int>()
        var r = 0
        while(r < arr.size && arr[r] < x) r++
        var l = r-1
        while(result.size < k){
            if(l < 0){
                result.addLast(arr[r++])
                continue
            }
            if(r >= arr.size){
                result.addFirst(arr[l--])
                continue
            }
            if(abs(arr[r] - x) < abs(x - arr[l])){
                result.addLast(arr[r++])
            }else{
                result.addFirst(arr[l--])
            }
        }
        return result

    }
}
