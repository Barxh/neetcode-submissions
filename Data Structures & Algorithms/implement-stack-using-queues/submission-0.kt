class MyStack() {
    var head: ListNode? = null
    fun push(x: Int) {
        val newNode = ListNode(x)
        newNode.next = head
        head = newNode
    }

    fun pop(): Int {
        val value = head?.let{ it.value }?: -1 
        head?.let{
            head = it.next
        }
        return value
    }

    fun top(): Int {
        return head?.let{ it.value } ?: -1
    }

    fun empty(): Boolean {
        return head == null
    }
}
class ListNode(val value: Int){
    var next : ListNode? = null
}
/**
 * Your MyStack object will be instantiated and called as such:
 * val obj = MyStack()
 * obj.push(x)
 * val param_2 = obj.pop()
 * val param_3 = obj.top()
 * val param_4 = obj.empty()
 */
