class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val tasksCount = IntArray(26)
        for(task in tasks){
            tasksCount[task - 'A']++
        }
        tasksCount.sortDescending()
        var cycles = 0
        var tasksCompleted = 0 
        while(true){
            var taskFinishedInCycle = 0
            for(i in tasksCount.indices){
                if(tasksCount[i] > 0){
                    if(taskFinishedInCycle <= n){
                        cycles++
                        taskFinishedInCycle++
                        tasksCount[i]--
                        tasksCompleted++
                    }else{
                        tasksCount.sortDescending()
                        break
                    }
                }
            }
            if(tasksCompleted == tasks.size) break
            if(taskFinishedInCycle <= n){
                cycles+= n + 1 - taskFinishedInCycle
            }
            
            
        }
        return cycles
    }
}
