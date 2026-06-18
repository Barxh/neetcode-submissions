class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val verticals = Array(9){mutableSetOf<Char>()}
        val horizontals = Array(9){mutableSetOf<Char>()}
        val squares = Array(9){mutableSetOf<Char>()}
        
        for(i in board.indices){
            for(j in board[0].indices){
                val ch = board[i][j]
                if(ch == '.') continue
                val squareIndex = (i/3) * 3 + j / 3
                if(verticals[j].contains(ch) || horizontals[i].contains(ch) || 
                        squares[squareIndex].contains(ch)) return false
                verticals[j].add(ch)
                horizontals[i].add(ch)
                squares[squareIndex].add(ch)
                
            }
        }
        return true
    }
}
