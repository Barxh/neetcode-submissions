class Solution {
    fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size
        for(i in 0 until n){
            for(j in i + 1 until n){
                val pom = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = pom
            }
        }
        for(i in 0 until n){
            var l = 0
            var r = n - 1
            while(l < r){
                val pom = matrix[i][l]
                matrix[i][l] = matrix[i][r]
                matrix[i][r] = pom
                l++
                r--
            }
        }

    }
}
