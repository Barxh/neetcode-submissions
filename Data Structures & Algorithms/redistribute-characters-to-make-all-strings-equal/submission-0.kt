class Solution {
    fun makeEqual(words: Array<String>): Boolean {
        val count = IntArray(26)
        for(word in words){
            for(ch in word){
                count[ch - 'a']++
            }
        }

        for(ch in count){
            if(ch % words.size != 0) return false
        }
        return true
    }
}