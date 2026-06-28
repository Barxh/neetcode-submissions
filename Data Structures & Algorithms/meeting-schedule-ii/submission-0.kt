/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        val list = intervals.sortedBy{ it.start }
        val meetings = PriorityQueue<Interval>(compareBy{ it.end })
        var max = 0
        for(interval in list){
            while(meetings.isNotEmpty() && interval.start >= meetings.peek().end){
                meetings.poll()
            }
            meetings.add(interval)
            max = max(max, meetings.size)
        }
        return max

    }
}
