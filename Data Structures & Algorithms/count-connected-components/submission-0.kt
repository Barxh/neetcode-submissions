class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val nodes = Array(n){mutableListOf<Int>()}
        for(edge in edges){
            nodes[edge[0]].add(edge[1])
            nodes[edge[1]].add(edge[0])
        }
        fun visitAllNodesInComponent(node: Int, visitedNodes: HashSet<Int>){
            visitedNodes.add(node)
            for(neighbor in nodes[node]){
                if(neighbor !in visitedNodes)
                visitAllNodesInComponent(neighbor, visitedNodes)
            }
        }

        val visitedNodes = HashSet<Int>()
        var componentCount = 0
        for(i in nodes.indices){
            if(i in visitedNodes) continue
            componentCount++
            visitAllNodesInComponent(i, visitedNodes)
        }
        return componentCount
    }
}
