class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>(emptyList())
        nums.forEach{ num ->
            val pom = listOf(num)
            val size = result.size
            for(i in 0 until size){
                result.add(result[i] + pom)
            }
        }
        return result
    }
}
