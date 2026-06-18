class Solution {
    fun reverseString(s: CharArray) {
        var i = 0 
        var j = s.lastIndex
        while(i < j){
            var pom = s[i]
            s[i] = s[j]
            s[j] = pom
            i++
            j--
        }

    }
}
