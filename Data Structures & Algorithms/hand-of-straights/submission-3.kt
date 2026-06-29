class Solution {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        val map = TreeMap<Int, Int>()
        hand.forEach{ 
            map[it] = map.getOrDefault(it, 0) + 1
        }
        val n = (hand.size + groupSize - 1) / groupSize
        var count = 0
        for(i in 0 until n){
            var last = -1
            for((key, value) in map){
                if(value == 0) continue
                if(last != -1 && key - last > 1) return false
                map[key] = value - 1
                count++
                if(count%groupSize == 0) break
                last = key
            }
            if(count%groupSize != 0) return false
        }
        return true
    }
}
