class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val offsets = arrayOf(
            arrayOf(0, 1),
            arrayOf(0, -1),
            arrayOf(-1, 0),
            arrayOf(1, 0)
        )
        val path = HashSet<Pair<Int, Int>>()
        fun wordFound(row: Int, col: Int, charIndex: Int): Boolean{
            if(charIndex >= word.length || row < 0 || 
            row >= board.size || col < 0 || col >= board[0].size || 
            word[charIndex] != board[row][col]) return false
            if(charIndex == word.lastIndex) return true

            var isFound = false
            for(offset in offsets){
                val nextField = Pair(row + offset[0], col + offset[1])
                if(path.contains(nextField)) continue
                path.add(nextField)
                isFound = isFound || wordFound(nextField.first, nextField.second, charIndex + 1)
                path.remove(nextField)
            }
            return isFound
        }
        for(i in 0 until board.size){
            for(j in 0 until board[i].size){
                val nextField = Pair(i, j)
                path.add(nextField)
                if(wordFound(i, j, 0)) return true
                path.remove(nextField)
            }
        }
        return false
    }
}
