class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val maxHeap = PriorityQueue<Int>(reverseOrder())
        stones.forEach{ stone ->
            maxHeap.offer(stone)
        } 
        while(maxHeap.size > 1){
            val x = maxHeap.poll()
            val y = maxHeap.poll()
            val result = x - y
            if(result!=0) maxHeap.offer(result)
        }
        return maxHeap.poll() ?: 0
    }
}
