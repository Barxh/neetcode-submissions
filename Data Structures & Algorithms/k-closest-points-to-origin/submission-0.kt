class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val maxHeap = PriorityQueue<IntArray>(compareByDescending{ arr ->
             (arr[0] * arr[0]) + (arr[1] * arr[1])
        }) 
        points.forEach{
            maxHeap.offer(it)
            if(maxHeap.size > k) maxHeap.poll()
        }
        val array = Array(maxHeap.size) { intArrayOf() }
        for(i in 0 until maxHeap.size){
            array[i] = maxHeap.poll()
        }
        return array
    }
}
