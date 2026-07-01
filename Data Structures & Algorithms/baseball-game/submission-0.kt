class Solution {
    fun calPoints(operations: Array<String>): Int {
        val list = mutableListOf<Int>()
        for(operation in operations){
            when(operation){
                "D" -> list.add(list.last() * 2)
                "C" -> list.removeLast()
                "+" -> list.add(list.last() + list[list.lastIndex - 1])
                else -> list.add(operation.toInt())
            }
        }
        return list.sum()
    }
}
