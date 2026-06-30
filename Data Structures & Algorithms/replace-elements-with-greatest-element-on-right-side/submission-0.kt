class Solution {
    fun replaceElements(arr: IntArray): IntArray {
        val result = IntArray(arr.size)
        result[result.lastIndex] = -1
        for(i in result.lastIndex - 1 downTo 0){
            result[i] = maxOf(result[i + 1], arr[i + 1])
        }
        return result
    }
}
