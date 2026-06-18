class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        var r = people.lastIndex
        var boatCount = 0
        while(r >= 0 && people[r] == limit) {
            boatCount++
            r--
        }
        var l = 0
        while(r > l){
            if(people[r] + people[l] <= limit){
                l++
            }
            r--
            boatCount++
        }
        
        if(r == l) boatCount++
        return boatCount
    }
}
