import kotlin.collections.ArrayDeque
class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        val open = mapOf('}' to '{', ']' to '[', ')' to '(')
        for(c in s){
            if(open.containsKey(c)){
                val pom = stack.removeLastOrNull() ?: return false
                if(open[c] != pom) return false
            }else{
                stack.addLast(c)
            }
        }
        if(stack.isNotEmpty()) return false
        return true
    }
}
