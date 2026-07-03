class MyCircularQueue(k: Int) {
    private var capacity = 0
    private var head: Node? = null
    private var size = 0
    init {
        capacity = k
    }
    fun enQueue(value: Int): Boolean {
        if(size == capacity) return false
        if(size == 0){
            head = Node(value)
            head!!.next = head
        }else{
            val newNode = Node(value, head?.next, head)
            head?.let{
                it.next = newNode
            }
            if(size == 1){
                head?.let{
                    it.prev = newNode
                }
            }
            
        }
        size++
        return true
    }

    fun deQueue(): Boolean {
        if(size == 0) return false
        if(size == 1){
            head = null
        }else{
            head?.let{ h ->
                h.prev?.let{ p ->
                    p.next = h.next
                }
                h.next?.let{ n ->
                    n.prev = h.prev
                }
            }
            head = head?.prev
        }
        size--
        return true
    }

    fun Front(): Int {
        return head?.value ?: -1
    }

    fun Rear(): Int {
        return head?.next?.value ?: -1
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun isFull(): Boolean {
        return size == capacity
    }
}
class Node(val value: Int, var next: Node? = null, var prev: Node? = null)

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */
