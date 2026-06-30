class LRUCache(val capacity: Int) {
    
    val map = HashMap<Int, Node>()
    val linkedList = LinkedList()
    
    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        linkedList.moveToFirst(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        if(map.containsKey(key)){
            map[key]!!.value = value
            linkedList.moveToFirst(map[key]!!)
        }else{
            val newNode = Node(value, key)
            map[key] = newNode
            linkedList.addFirst(newNode)
            if(linkedList.size > capacity){
                val key = linkedList.removeLast()
                map.remove(key)
            }
        }
    }
}
class LinkedList(){
    var head : Node? = null
    var tail : Node? = null
    var size : Int = 0
    fun addFirst(node: Node){
        node.next = head
        head?.let{
            it.prev = node
        }
        head = node
        if(size == 0) tail = node
        size++
    }
    fun moveToFirst(node: Node){
        if(node == head) return
        if(node == tail){
            tail = node.prev ?: node
        }
        node.prev?.let{
            it.next = node.next
        }
        node.next?.let{
            it.prev = node.prev
        }
        node.next = head
        node.prev = null
        head?.let{
            it.prev = node
        }
        head = node
    }
    fun removeLast() : Int {
        if(size == 0) return -1
        if(size == 1) head = null
        val deletedKey = tail?.key ?: -1
        tail = tail?.prev
        tail?.let{
            it.next = null
        }
        size--
        return deletedKey
    }
}
class Node(var value: Int, val key: Int){
    var prev: Node? = null
    var next: Node? = null
}