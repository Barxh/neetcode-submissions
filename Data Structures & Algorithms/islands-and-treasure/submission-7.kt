val offsets = arrayOf(
    arrayOf(1, 0),
    arrayOf(-1, 0),
    arrayOf(0, 1),
    arrayOf(0, -1)
)
class Solution {
    fun islandsAndTreasure(grid: Array<IntArray>) {
        val deque = ArrayDeque<IntArray>()
        for(r in grid.indices){
            for(c in grid[r].indices){
                if(grid[r][c] == 0) deque.add(intArrayOf(r, c))
            }
        }
        var distance = 0
        while(deque.isNotEmpty()){
            val size = deque.size
            repeat(size){
                val cur = deque.removeFirst()
                for(offset in offsets){
                    val next = intArrayOf(cur[0] + offset[0], cur[1] + offset[1])
                    if(next[0] < 0 || next[0] >= grid.size || next[1] < 0 
                    || next[1] >= grid[next[0]].size || distance + 1 >= grid[next[0]][next[1]]) continue
                    deque.add(next)
                    grid[next[0]][next[1]] = distance + 1
                }
            }
            distance++
        }
    }
}
