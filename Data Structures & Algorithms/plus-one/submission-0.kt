class Solution {
    fun plusOne(digits: IntArray): IntArray {
        val resultList = digits.toMutableList()
        var bonus = (resultList[resultList.lastIndex] + 1) / 10
        resultList[resultList.lastIndex] = (resultList[resultList.lastIndex] + 1) % 10
        for(i in resultList.lastIndex - 1 downTo 0){
            if(resultList[i] + bonus == 10){
                resultList[i] = (resultList[i] + bonus) % 10
                bonus = 1
            }else{
                resultList[i] = (resultList[i] + bonus) % 10
                bonus = 0
                break
            }
        }
        if(bonus == 1) resultList.add(0, 1)
        return resultList.toIntArray()
    }
}
