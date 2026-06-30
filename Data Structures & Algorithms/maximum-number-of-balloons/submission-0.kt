class Solution {
    fun maxNumberOfBalloons(text: String): Int {
        val map = text.groupingBy{ it }.eachCount()
        return minOf(map['b']?: 0, map['a']?: 0, map.getOrDefault('l', 0)/2,
        map.getOrDefault('o', 0)/2, map['n'] ?: 0)
    }
}