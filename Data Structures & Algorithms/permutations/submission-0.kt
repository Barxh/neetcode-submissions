class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        
        fun findPermutations(usedNums: MutableSet<Int>, path: MutableList<Int>){
            for(num in nums){
                if(usedNums.contains(num)) continue
                path.add(num)
                if(path.size == nums.size){
                    res.add(ArrayList(path))
                }else{
                    usedNums.add(num)
                    findPermutations(usedNums, path)
                    usedNums.remove(num)
                }
                path.removeLast()
            }
        }
        findPermutations(mutableSetOf(), mutableListOf())
        return res
    }
}
