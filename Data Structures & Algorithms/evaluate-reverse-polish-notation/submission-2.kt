import kotlin.collections.ArrayDeque
class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        val setOfOperations = setOf("+", "-", "*", "/")
        for(str in tokens){
            if(setOfOperations.contains(str)){
                val num2 = stack.removeLastOrNull() ?: return -1
                val num1 = stack.removeLastOrNull() ?: return -1
                stack.addLast(executeOperation(num1, num2, str))
            }else{
                stack.addLast(str.toInt())
            }
        }
        return stack.lastOrNull() ?: -1
    }




    fun executeOperation(num1: Int, num2: Int, operation: String) = 
        when(operation){
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> num1 / num2
            else -> 0
        }
        
        
}
