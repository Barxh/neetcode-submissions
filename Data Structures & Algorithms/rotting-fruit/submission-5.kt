import kotlin.collections.ArrayDeque
class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size
        var queue = ArrayDeque<Pair<Int, Int>>()

        for(i in grid.indices){
            for(j in grid[i].indices){
                if(grid[i][j] == 2){
                    queue.addLast(Pair(i, j))
                }
            }
        }
        
        val offsets = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1),
        )
        var minutes = 0
        while(queue.isNotEmpty()){
            val pomQueue = ArrayDeque<Pair<Int, Int>>()
            println("hello")
            while(queue.isNotEmpty()){
                val (row, col) = queue.removeFirstOrNull() ?: break
                for(offset in offsets){
                    val r = row + offset[0]
                    val c = col + offset[1]
                    if(r !in 0 until n || c !in 0 until m || grid[r][c] != 1) continue
                    pomQueue.addLast(Pair(r, c))
                    grid[r][c] = 2
                }
            }
            queue = pomQueue
            minutes++
        }
        minutes--
        for(i in grid.indices){
            for(j in grid[i].indices){
                if(grid[i][j] == 1){
                    return -1
                }
            }
        }
        return if(minutes == -1) 0 else minutes
    }
}
