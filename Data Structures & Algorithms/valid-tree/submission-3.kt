class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        if(edges.size != n - 1) return false
        val nodes = Array(n){ mutableListOf<Int>() }
        for(edge in edges){
            nodes[edge[0]].add(edge[1])
            nodes[edge[1]].add(edge[0])
        }
        val isVisited = BooleanArray(n){false}
        var visitedNodesCount = 0
        fun findLoop(curNode: Int, prevNode: Int): Boolean{
            if(isVisited[curNode]) return true
            isVisited[curNode] = true
            visitedNodesCount++
            for(neighbor in nodes[curNode]){
                if(neighbor == prevNode) continue
                if(findLoop(neighbor, curNode)) return true
            }
            return false
        }
        return !findLoop(0, -1) && visitedNodesCount == n
    }
}
