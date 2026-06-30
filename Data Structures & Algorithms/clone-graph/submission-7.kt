/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {
    fun cloneGraph(node: Node?): Node? {
        if(node == null) return null
        val map = HashMap<Node, Node>()
        
        fun mapGraph(node: Node){
            map[node] = Node(node.`val`)
            for(n in node.neighbors){
                if(n != null && !map.containsKey(n)) mapGraph(n)
            }
        }
        mapGraph(node)
        for((key, value) in map){
            for(n in key.neighbors){
                if(n == null) value.neighbors.add(null)
                else value.neighbors.add(map[n])
            }
        }
        return map[node]
    }
}
