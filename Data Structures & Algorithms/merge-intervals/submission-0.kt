class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val resultList = mutableListOf<IntArray>()
        intervals.sortBy{ it[0] }
        for(i in 1 until intervals.size){
            if(intervals[i][0] <= intervals[i - 1][1]){
                intervals[i][0] = intervals[i - 1][0]
                intervals[i][1] = max(intervals[i][1], intervals[i - 1][1]) 
            }else{
                resultList.add(intervals[i - 1])
            }
        }
        resultList.add(intervals[intervals.lastIndex])
        return resultList.toTypedArray()
    }
}
