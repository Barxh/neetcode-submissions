class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val listOfNums = mutableListOf<HashSet<Int>>()
        val map = HashMap<Int,Int>()

        for(num in nums){
            if(map.containsKey(num)){
                val index = map[num]?:0
                listOfNums[index].remove(num)
                map[num] = map.getOrDefault(num, 0) + 1
                if(listOfNums.size <= index + 1) listOfNums.add(HashSet<Int>())
                listOfNums[index + 1].add(num)
            }else{
                map.put(num, 0)
                if(listOfNums.isEmpty()){
                    listOfNums.add(HashSet<Int>())
                }
                listOfNums[0].add(num)
            }
        }
        val result = IntArray(k)
        var insCount = 0
        for(i in listOfNums.lastIndex downTo 0){
            for(num in listOfNums[i]){
                result[insCount++] = num
                if(insCount == k) return result
            }
        }
        return result
    }
}
