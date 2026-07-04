val offsets = arrayOf(
    arrayOf(0, 1),
    arrayOf(0, -1),
    arrayOf(-1, 0),
    arrayOf(1, 0)
)
class Solution {
    fun islandsAndTreasure(grid: Array<IntArray>) {
        fun calculateDistances(r: Int, c: Int){
            val visited = mutableSetOf(Pair(r, c))
            val deque = ArrayDeque<Pair<Int, Int>>()
            deque.add(Pair(r, c))
            var distance = 0
            while(deque.isNotEmpty()){
                val size = deque.size
                repeat(size){
                    val cur = deque.removeFirst()
                    for(offset in offsets){
                        val nextR = cur.first + offset[0]
                        val nextC = cur.second + offset[1]
                        val pair = Pair(nextR, nextC)
                        if(nextR < 0 || nextR >= grid.size || nextC < 0 || 
                        nextC >= grid[nextR].size || grid[nextR][nextC] <= distance + 1 || visited.contains(pair)) continue
                        visited.add(pair)
                        deque.add(pair)
                    }
                    grid[cur.first][cur.second] = distance
                }
                distance++
            }
        }
        for(r in grid.indices){
            for(c in grid[r].indices){
                if(grid[r][c] == 0){
                    calculateDistances(r, c)
                }
            }
        }
    }
}
