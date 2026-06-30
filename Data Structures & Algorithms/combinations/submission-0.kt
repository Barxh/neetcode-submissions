class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()

        fun findCombinations(inx: Int, path: MutableList<Int>){
            for(i in inx until n + 1){
                if(path.size + n + 1 - i < k) break
                path.add(i)
                if(path.size == k){
                    res.add(ArrayList(path))
                }else{
                    findCombinations(i + 1, path)
                }
                path.removeLast()
            }
        }
        findCombinations(1, mutableListOf())
        return res
    }
}
