class Solution {
    fun countSeniors(details: Array<String>): Int {
        var count = 0
        for(detail in details){
            val age = detail.substring(11, 13).toInt()
            if(age > 60) count++
        }
        return count
    }
}
