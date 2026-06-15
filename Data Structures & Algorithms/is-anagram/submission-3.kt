class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length) return false
        val n = s.length
        val sArr = IntArray(26)
        val tArr = IntArray(26)
        for(i in 0..n - 1){
            sArr[s[i] - 'a']++
            tArr[t[i] - 'a']++
        }
        for(i in 0..25){
            if(sArr[i] != tArr[i]) return false
        }
        return true
    }
}
