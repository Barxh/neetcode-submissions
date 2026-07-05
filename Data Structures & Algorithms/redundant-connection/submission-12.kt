class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val nodes = Array(edges.size){mutableListOf<Int>()}
        for(edge in edges){
            nodes[edge[0] - 1].add(edge[1])
            nodes[edge[1] - 1].add(edge[0])
        }
        val nodesInLoop = HashSet<Int>()
        var loopBegin = -1
        val visitedNodes = BooleanArray(edges.size)
        fun getNodesInLoop(cur: Int, prev: Int){
            print("$cur, ")
            if(visitedNodes[cur - 1]){
                //print("$cur, ")
                loopBegin = cur
                nodesInLoop.add(cur)
                return
            }
            visitedNodes[cur - 1] = true
            for(neighbor in nodes[cur - 1]){
                if(neighbor == prev) continue
                getNodesInLoop(neighbor, cur)
                when{
                    loopBegin == -2 -> {
                        return
                    }
                    loopBegin != -1 ->{
                        //print("$cur, ")
                        if(loopBegin == cur) {
                            loopBegin = -2 
                        }
                        nodesInLoop.add(cur)
                        return
                    }
                }
            }
            visitedNodes[cur - 1] = false
        }
        getNodesInLoop(1, -1)
        println("")
        for(n in nodesInLoop) print("$n, ")
        for(i in edges.lastIndex downTo 0){
            if(edges[i][0] in nodesInLoop && edges[i][1] in nodesInLoop) return edges[i]
        }
        return intArrayOf()
    }
}
