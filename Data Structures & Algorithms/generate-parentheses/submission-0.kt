class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val res = mutableListOf<String>()

        fun genParStrings(opened: Int, closed: Int, sb: StringBuilder){
            if(opened < n){
                sb.append('(')
                genParStrings(opened + 1, closed, sb)
                sb.deleteAt(sb.lastIndex)
            }
            if(opened > closed){
                sb.append(')')
                if(closed + 1 == n){
                    res.add(sb.toString())
                }else{
                    genParStrings(opened, closed + 1, sb)
                }
                sb.deleteAt(sb.lastIndex)
            }
        }
        genParStrings(0, 0, StringBuilder())
        return res
    }
}
