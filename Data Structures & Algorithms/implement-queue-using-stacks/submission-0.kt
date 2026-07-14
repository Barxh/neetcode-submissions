class MyQueue() {
    val list = LinkedList<Int>()
    fun push(x: Int) {
        list.addFirst(x)
    }

    fun pop(): Int {
        return list.removeLastOrNull() ?: -1
    }

    fun peek(): Int {
        return list.lastOrNull() ?: -1
    }

    fun empty(): Boolean {
        return list.size == 0
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * val obj = MyQueue()
 * obj.push(x)
 * val param_2 = obj.pop()
 * val param_3 = obj.peek()
 * val param_4 = obj.empty()
 */
