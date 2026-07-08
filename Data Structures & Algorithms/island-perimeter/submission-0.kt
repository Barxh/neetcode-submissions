val offsets = arrayOf(
    arrayOf(0, 1),
    arrayOf(1, 0),
    arrayOf(-1, 0),
    arrayOf(0, -1)
)
class Solution {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        fun calculatePerimeter(r: Int, c: Int): Int{
            if(r < 0 || r >= grid.size || c < 0 || 
            c >= grid[r].size || grid[r][c] == 0) return 1
            if(grid[r][c] == 2) return 0
            grid[r][c] = 2
            var count = 0
            for(offset in offsets){
                count += calculatePerimeter(r + offset[0], c + offset[1])
            }
            return count
        }
        for(r in grid.indices){
            for(c in grid[r].indices){
                if(grid[r][c] == 1) return calculatePerimeter(r, c)
            }
        }
        return 0
    }
}

