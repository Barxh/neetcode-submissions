class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()
        val res = mutableSetOf<List<Int>>()
        res.add(emptyList())
        fun findPermutations(idx: Int, usedNums: MutableSet<Int>, path: MutableList<Int>){
            for(i in idx until nums.size){
                if(usedNums.contains(nums[i])) continue
                path.add(nums[i])
                res.add(ArrayList(path))
                findPermutations(i + 1, usedNums, path)
                path.removeLast()
                if(path.isEmpty()) usedNums.add(nums[i])
            }
        }
        findPermutations(0, mutableSetOf(), mutableListOf())
        return res.toList()
    }
}
