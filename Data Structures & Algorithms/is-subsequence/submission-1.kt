class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        if(s.length > t.length) return false
        if(s.isEmpty()) return true
        var sPom = 0
        var tPom = 0
        while(tPom < t.length){
            if(s[sPom] == t[tPom]){
                sPom++
                if(sPom == s.length) return true
            }
            tPom++
        }
        return false
    }
}
