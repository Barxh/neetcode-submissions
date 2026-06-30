class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy{it[0]}
        var newInterval = intervals[0]
        val res = mutableListOf<IntArray>()
        for(i in 1 until intervals.size){
            if(newInterval[1] >= intervals[i][0]){
                newInterval[1] = maxOf(newInterval[1], intervals[i][1])
            }else{
                res.add(newInterval)
                newInterval = intervals[i]
            }
        }
        res.add(newInterval)
        return res.toTypedArray()
    }
}
