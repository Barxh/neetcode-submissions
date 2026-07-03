class Solution {
    val offsets = arrayOf(
        arrayOf(1, 0),
        arrayOf(-1, 0),
        arrayOf(0, 1),
        arrayOf(0, -1)
    )
    fun islandsAndTreasure(grid: Array<IntArray>) {

       fun change(value: Int, r: Int, c: Int){
           if(r < 0 || r >= grid.size || c < 0 || c >= grid[r].size
           || value >= grid[r][c]) return
           grid[r][c] = value
           for(offset in offsets){
              change(value + 1, r + offset[0], c + offset[1])
           }
       }
       for(r in grid.indices){
        for(c in grid[r].indices){
            if(grid[r][c] == 0){
                for(offset in offsets){
                    change(1, r + offset[0], c + offset[1])
                }
            }
        }
       }
    }
}
