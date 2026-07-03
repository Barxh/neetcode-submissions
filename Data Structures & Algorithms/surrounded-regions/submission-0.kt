class Solution {
    val offsets = arrayOf(
        arrayOf(0, 1),
        arrayOf(0, -1),
        arrayOf(1, 0),
        arrayOf(-1, 0)
    )
    fun solve(board: Array<CharArray>) {
       fun change(r: Int, c: Int){
        if(r < 0 || r >= board.size || c < 0 || c >= board[r].size
        || board[r][c] != 'O') return
        board[r][c] = 'Y'
        for(offset in offsets){
            change(r + offset[0], c + offset[1])
        }
       }
       for(r in board.indices){
        for(c in board[r].indices){
            if(r == 0 || r == board.lastIndex || c == 0 || c == board[r].lastIndex){
                if(board[r][c] == 'O') change(r, c)
            }
        }
       }
       for(r in board.indices){
        for(c in board[r].indices){
            when(board[r][c]){
                'O' -> board[r][c] = 'X'
                'Y' -> board[r][c] = 'O'
            }
        }
       }
    }
}
