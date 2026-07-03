class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val head = GraphNode()
        val map = HashMap<Int, GraphNode>().apply{ put(0, head) }
        for(i in 1 until numCourses){
            map.put(i, GraphNode())
        }
        for(pre in prerequisites){
            map[pre[0]]?.let{
                it.neighbors.add(map[pre[1]]!!)
            }
        }
        fun hasLoop(node : GraphNode, checked : HashSet<GraphNode>): Boolean{
            if(checked.contains(node)) return true
            checked.add(node)
            for(n in node.neighbors){
                if(hasLoop(n, checked)) return true
            }
            checked.remove(node)
            return false
        }
        val checked = HashSet<GraphNode>()
        for(n in map.values){
            if(hasLoop(n, checked)) return false
        }
        return true
    }
    class GraphNode{
        val neighbors = mutableListOf<GraphNode>()
    }
}
