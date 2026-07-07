class Solution {
    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        val map = HashMap<Char, Int>()
        for(i in order.indices){
            map.put(order[i], i)
        }
        fun compareTo(word1: String, word2: String): Boolean{
            val len = minOf(word1.length, word2.length)
            for(i in 0 until len){
                when{
                    map[word1[i]]!! > map[word2[i]]!! -> return false
                    map[word1[i]]!! < map[word2[i]]!! -> return true
                }
            }
            return word1.length <= word2.length
        }
        for(i in 1 until words.size){
            if(!compareTo(words[i - 1], words[i])) return false 
        }
        return true
    }
}
