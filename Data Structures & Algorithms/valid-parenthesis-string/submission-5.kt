class Solution {
    fun checkValidString(s: String): Boolean {
        var jokerToIdle = 0
        var jokerToClosed = 0
        var stack = ArrayDeque<Char>()

        for(ch in s){
            when(ch){
                '(' -> stack.addLast('(')
                ')' -> {
                    when{
                        stack.isNotEmpty() -> stack.removeLast()
                        jokerToClosed > 0 -> {
                            jokerToClosed--
                            jokerToIdle++
                        }
                        jokerToIdle > 0 -> {
                            jokerToIdle--
                        }
                        else -> return false
                    }
                }
                '*' ->{
                    if(stack.isEmpty()){
                        jokerToIdle++
                    }else{
                        jokerToClosed++
                        stack.removeLast()
                    }
                }
            }
        }
        return stack.isEmpty()
    }
}
