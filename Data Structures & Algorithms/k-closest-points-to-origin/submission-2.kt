class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val maxHeap = PriorityQueue<IntArray>(compareByDescending{ arr ->
             (arr[0] * arr[0]) + (arr[1] * arr[1])
        }) 
        points.forEach{
            maxHeap.offer(it)
            if(maxHeap.size > k) maxHeap.poll()
        }
        // val array = Array(maxHeap.size) { intArrayOf() }
        // var i = 0
        // while(maxHeap.isNotEmpty()){
        //     array[i++] = maxHeap.poll()
        // }
        return maxHeap.toTypedArray()
    }
}
