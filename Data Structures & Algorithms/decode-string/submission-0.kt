class Solution {
    fun decodeString(s: String): String {
        val deque = ArrayDeque<Pair<Int, StringBuilder>>()
        deque.addLast(Pair(1, StringBuilder()))
        var i = 0
        while(i < s.length){
            when{
                isNumber(s[i]) ->{
                    var j = i
                    while(isNumber(s[j])) j++
                    var num = s.substring(i, j).toInt()
                    deque.addLast(Pair(num, StringBuilder()))
                    i = j 
                }
                isLetter(s[i]) -> {
                    deque.last().second.append(s[i])
                }
                s[i] == ']' ->{
                    val pair = deque.removeLast()
                    repeat(pair.first){
                        deque.last().second.append(pair.second)
                    }
                }
            }
            i++
        }
        return deque.last().second.toString()

    }

    fun isNumber(ch: Char) = ch >= '0' && ch <= '9'
    fun isLetter(ch: Char) = ch >= 'a' && ch <= 'z'

}
