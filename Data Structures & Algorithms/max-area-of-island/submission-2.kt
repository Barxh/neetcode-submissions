class Solution {
    val offsets = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
        intArrayOf(0, 1),
        intArrayOf(0, -1),
    )
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var maxArea = 0
        var islandSize = 0
        fun deleteIsland(row: Int, col: Int){
            if(row < 0 || row >= grid.size || col < 0 || col >= grid[row].size || grid[row][col] == 0) return
            grid[row][col] = 0
            islandSize++
            offsets.forEach{
                deleteIsland(row + it[0], col + it[1])
            }
        }
        for(i in grid.indices){
            for(j in grid[i].indices){
                if(grid[i][j] == 1){
                    deleteIsland(i, j)
                    if(islandSize > maxArea){
                        maxArea = islandSize
                    }
                    islandSize = 0
                }
            }
        }

        return maxArea
    }
}
