class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<List<Int>, MutableList<String>>()
        for(str in strs){
            map.getOrPut(countCharsInString(str)) {mutableListOf()}.add(str)
        }
        return map.values.toList()
    }

    fun countCharsInString(s: String): List<Int>{
        val arr = IntArray(26)
        for(ch in s){
            arr[ch - 'a']++
        }
        return arr.toList()
    }
}
