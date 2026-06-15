class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toMutableSet()
        var max = 0
        var begin = 0
        while(set.isNotEmpty()){
            for(i in set){
                if(!set.contains(i - 1)){
                    begin = i
                    break;
                }
            }
            var count = 1
            while(set.contains(begin + 1)){
                count++
                set.remove(begin++)
            }
            set.remove(begin)
            if(count > max) max = count
        }

        return max
    }
}
