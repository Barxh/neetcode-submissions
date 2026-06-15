class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<MutableList<Int>,MutableList<String>>()
        
        strs.forEach{ str ->
            val list = MutableList(26){0}
            for(ch in str){
                list[ch - 'a']++
            }
            map.getOrPut(list) {mutableListOf<String>()}.add(str)
            
        }
        return map.map{(key, value) -> value}
    }
}
