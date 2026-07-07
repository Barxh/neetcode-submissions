class Solution {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val people = Array(n + 1){mutableListOf<Int>()}
        for(t in trust){
            people[t[1]].add(t[0])
        }
        var max = 0
        var maxI = 0
        for(i in people.indices){
            if(max < people[i].size){
                maxI = i
                max = people[i].size
            }
        }
        return if(max == n - 1 && !trust.any{ it[0] == maxI }) maxI else -1
    }
}
