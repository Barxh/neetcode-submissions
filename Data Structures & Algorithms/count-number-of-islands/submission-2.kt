class Solution {
    val offsets = arrayOf(
        arrayOf(0, 1),
        arrayOf(1, 0),
        arrayOf(0, -1),
        arrayOf(-1, 0),
    )
    fun numIslands(grid: Array<CharArray>): Int {
        var islandCount = 0
        var i = 0
        var j = 0
        fun deleteIsland( row: Int, col: Int){
            if(row >= grid.size || row < 0 || col < 0 || col >= grid[row].size || grid[row][col] == '0') return
            grid[row][col] = '0'
            println("row: $row, col: $col")
            for(arr in offsets){
                deleteIsland(row + arr[0], col + arr[1])
            }

        }
        while(i < grid.size){
            while(j < grid[i].size){
                if(grid[i][j] == '1'){
                    deleteIsland(i, j)
                    islandCount++
                }
                println("i: $i, j: $j")
                j++
            }
            j = 0
            i++
        }
        return islandCount
    }
}
