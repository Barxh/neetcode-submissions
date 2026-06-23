/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {
        val intervalsSorted = intervals.sortedBy{ it.start }
        for(i in 1 until intervalsSorted.size){
            if(isInInterval(intervalsSorted[i].start, intervalsSorted[i - 1])){
                return false
            }
        }
        return true
    }
    fun isInInterval(num: Int, interval: Interval) = num >= interval.start && num < interval.end
}
