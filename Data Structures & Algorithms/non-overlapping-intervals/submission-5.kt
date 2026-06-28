class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortWith(compareBy({it[0]} , {it[1]}))
        intervals.forEach{ interval ->
            print("[${interval[0]}, ${interval[1]}], ")
        }
        var lastInterval = intervals[0][1]
        var count = 0
        for(i in 1 until intervals.size){
            if(lastInterval > intervals[i][0]){
                count++
                lastInterval = minOf(lastInterval, intervals[i][1])
            }else{
                lastInterval = intervals[i][1]
            }
        }
        return count
    }
}
