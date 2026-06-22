class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if(s1.length > s2.length) return false

        val charCount = IntArray(26)
        for(ch in s1){
            charCount[ch - 'a']++
        }

        var matches = 0
        var clone = charCount.copyOf()
        var startSec = 0 
        for(i in 0 until s2.length){
            if(clone[s2[i] - 'a'] > 0){
                matches++
                if(matches == s1.length) return true
                if(matches == 1) startSec = i
                clone[s2[i] - 'a']--
            }else{
                if(matches > 0){
                    if(charCount[s2[i] - 'a'] > 0){
                        while(s2[i] != s2[startSec]){
                            clone[s2[startSec++] - 'a']++
                            matches--
                    
                        }
                        startSec++
                    }else{
                        matches = 0
                        clone = charCount.copyOf()
                    }
                    
                }
            }
        }

        return false
    }
}
