/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {
    fun cloneGraph(node: Node?): Node? {
        if(node == null) return null
        val map = HashMap<Node?, Node?>()
        val deque = ArrayDeque<Node?>()
        deque.offer(node)
        while(deque.isNotEmpty()){
            val n = deque.poll()
            n?.let{
                map[it] = Node(it.`val`)
            }
            
            n?.neighbors?.forEach{
                if(it == null || map.containsKey(it)) return@forEach
                deque.offer(it)
            }
        }
        val visitedNodes = mutableSetOf(node)
        deque.offer(node)
        while(deque.isNotEmpty()){
            val n = deque.poll()
            n?.neighbors?.forEach{
                if(it == null) return@forEach
                if(!visitedNodes.contains(it)){
                    deque.offer(it)
                    visitedNodes.add(it)
                }
                map[n]?.neighbors?.add(map[it])
            }
        }
        return map[node]
    }
}
