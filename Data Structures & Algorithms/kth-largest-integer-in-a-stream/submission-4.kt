class KthLargest(k: Int, nums: IntArray) {
    val minHeap = PriorityQueue<Int>()
    val kn = k
    init{
        nums.forEach{ num ->
            minHeap.offer(num)
            if(minHeap.size > kn){
                minHeap.poll()
            }
            
        }
    }
    fun add(`val`: Int): Int {
        minHeap.offer(`val`)
        if(minHeap.size > kn){
            minHeap.poll()
        }
        return minHeap.peek()
        
    }
}
