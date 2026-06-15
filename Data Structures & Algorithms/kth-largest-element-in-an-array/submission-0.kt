class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val minHeap = PriorityQueue<Int>()
        nums.forEach{
            minHeap.offer(it)
            if(minHeap.size > k) minHeap.poll()
        }
        return minHeap.poll()
    }
}
