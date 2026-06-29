class Solution {
    fun letterCombinations(digits: String): List<String> {
        if(digits.isEmpty()) return emptyList()
        val chars = arrayOf(
            arrayOf('a', 'b', 'c'),
            arrayOf('d', 'e', 'f'),
            arrayOf('g', 'h', 'i'),
            arrayOf('j', 'k', 'l'),
            arrayOf('m', 'n', 'o'),
            arrayOf('p', 'q', 'r', 's'),
            arrayOf('t', 'u', 'v'),
            arrayOf('w', 'x', 'y', 'z'),
        )
        val res = mutableListOf<String>()
        fun combLetters(charIndex: Int, sb: StringBuilder){
            
            for(char in chars[digits[charIndex] - '2']){
                sb.append(char)
                if(charIndex == digits.lastIndex){
                    res.add(sb.toString())
                }else{
                    combLetters(charIndex + 1, sb)
                }
                sb.deleteAt(sb.lastIndex)
            }
        }
        combLetters(0, StringBuilder())
        return res
    }
}
