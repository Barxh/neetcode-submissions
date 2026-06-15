class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val set = HashSet<Int>()
        nums.forEach{ num ->
            if(set.contains(num)){
                return true
            }
            set.add(num)
        }
        return false
    }
}
