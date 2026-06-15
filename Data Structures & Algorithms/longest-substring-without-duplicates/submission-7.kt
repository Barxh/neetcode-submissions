class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if(s.isEmpty()) return 0
        var i = 0
        val set = mutableSetOf(s[i])
        var max = 1
        for(k in 1 until s.length){
            if(set.contains(s[k])){
                max = max(max, k - i)
                while(s[i] != s[k]){
                    set.remove(s[i++])
                }
                i++
            }else{
                set.add(s[k])
            }
        }
        return max(max, set.size)
    }
}
