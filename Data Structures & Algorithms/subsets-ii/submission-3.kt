class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        res.add(emptyList())
        nums.sort()
        fun findSubsets(idx: Int, path: MutableList<Int>){
            var i = idx
            while(i < nums.size){
                path.add(nums[i])
                res.add(ArrayList(path))
                findSubsets(i + 1, path)
                path.removeLast()
                while(i < nums.lastIndex && nums[i] == nums[i + 1]) i++
                i++
            }
        }
        findSubsets(0, mutableListOf())
        return res
    }
}
