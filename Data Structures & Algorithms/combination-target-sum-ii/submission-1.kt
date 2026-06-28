class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val res = mutableSetOf<List<Int>>()
        candidates.sort()
        val currPath = mutableListOf<Int>()
        fun findSums(currSum: Int, i: Int){
            var j = i
            while(j < candidates.size){
                when{
                    currSum + candidates[j] > target -> return 
                    currSum + candidates[j] < target ->{
                        currPath.add(candidates[j])
                        findSums(currSum + candidates[j], j + 1)
                        currPath.removeLast()
                        while(j < candidates.lastIndex && candidates[j] == candidates[j + 1]){
                            j++
                        }
                    }
                    else -> {
                        res.add(ArrayList(currPath).apply{ add(candidates[j]) })
                    }    
                }
                j++
            }
        }
        findSums(0, 0)
        return res.toList()
    }
}
