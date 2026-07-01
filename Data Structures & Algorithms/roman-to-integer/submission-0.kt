class Solution {
    fun romanToInt(s: String): Int {
        val map = mapOf<Char, Int>('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50,
         'C' to 100, 'D' to 500, 'M' to 1000)
        var max = 0
        var res = 0
        for(i in s.length - 1 downTo 0){
            var num = map[s[i]] ?: return -1
            if(num < max) num = -1 * num
            if(num > max) max = num
            res += num 
        }
        return res
    }
}
