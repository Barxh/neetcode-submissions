class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val courses = Array(numCourses){mutableListOf<Int>()}
        for(pre in prerequisites){
            courses[pre[0]].add(pre[1])
        }
        val res = IntArray(numCourses)
        var resI = 0
        val visited = BooleanArray(numCourses)
        val scheduled = BooleanArray(numCourses)
        fun hasLoop(course: Int): Boolean{
            if(visited[course]) return true
            visited[course] = true
            for(pre in courses[course]){
                if(hasLoop(pre)) return true
            }
            if(!scheduled[course])res[resI++] = course
            scheduled[course] = true
            visited[course] = false
            return false
        }
        for(i in courses.indices){
            if(scheduled[i]) continue
            if(hasLoop(i)) return intArrayOf()
        }
        return res
    }
}
