class Solution {
    fun mergeTriplets(triplets: Array<IntArray>, target: IntArray): Boolean {
        val res = IntArray(3)
        for(triple in triplets){
            if(target[0] >= triple[0] && target[1] >= triple[1] && 
            target[2] >= triple[2]){
                res[0] = maxOf(res[0], triple[0])
                res[1] = maxOf(res[1], triple[1])
                res[2] = maxOf(res[2], triple[2])
            }
        }
        return target.contentEquals(res)
    }
}
