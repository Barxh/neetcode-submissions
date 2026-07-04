class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        val nodes = Array(n){ mutableListOf<Int>() }
        for(edge in edges){
            nodes[edge[0]].add(edge[1])
            nodes[edge[1]].add(edge[0])
        }
        val isVisited = BooleanArray(n){false}
        
        fun findLoop(curNode: Int, prevNode: Int): Boolean{
            if(isVisited[curNode]) return true
            isVisited[curNode] = true
            for(neighbor in nodes[curNode]){
                if(neighbor == prevNode) continue
                if(findLoop(neighbor, curNode)) return true
            }
            return false
        }
        return !findLoop(0, -1) && isVisited.all{ it }
    }
}
