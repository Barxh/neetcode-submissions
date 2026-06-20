import kotlin.collections.ArrayDeque
class Solution {
    fun simplifyPath(path: String): String {
        val stack = ArrayDeque<String>()
        val sb = StringBuilder()
        fun execute(){
            when{
                sb.length == 2 && sb.all{ it == '.'} -> stack.removeLastOrNull()
                sb.length == 1 && sb[0] == '.' -> {}
                sb.length > 0 ->{
                    stack.addLast(sb.toString())
                }
            }
            sb.clear()
        }
        for(ch in path){
            if(ch != '/'){
                sb.append(ch)
            }else{
                execute()
                
            }
        }
        if(sb.isNotEmpty()) {
            execute()
        }
        while(stack.isNotEmpty()){
            val curr = stack.removeFirstOrNull() ?: ""
            sb.append('/' + curr)
        }
        return if(sb.isEmpty()) "/" else sb.toString()
    }
}
