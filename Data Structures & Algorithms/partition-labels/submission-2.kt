class Solution {
    fun partitionLabels(s: String): List<Int> {
        val charCount = IntArray(26)
        for(ch in s){
            charCount[ch - 'a']++
        }
        val result = mutableListOf<Int>()
        var i = 0
        val checkedCh = IntArray(26)
        
        while(i < s.length){
            var subLength = 1
            checkedCh[s[i] - 'a']++
            i++
            while(i < s.length && !couldFormSubString(checkedCh, charCount)){
                checkedCh[s[i++] - 'a']++
                subLength++
            }
            result.add(subLength)
        }
        return result
    }
    private fun couldFormSubString(checkedCh: IntArray, charCount: IntArray): Boolean{
        for(i in 0 until 26){
            if(checkedCh[i] == 0) continue
            if(checkedCh[i] < charCount[i]) return false
        }
        return true
    }
    
}
