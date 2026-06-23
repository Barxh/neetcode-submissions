class Solution {
    fun mergeTriplets(triplets: Array<IntArray>, target: IntArray): Boolean {
        val resultTriple = IntArray(3)
        for(triplet in triplets){
            if(!isValidTriple(triplet, target)) continue
            resultTriple[0] = max(resultTriple[0], triplet[0])
            resultTriple[1] = max(resultTriple[1], triplet[1])
            resultTriple[2] = max(resultTriple[2], triplet[2])
        }
        return resultTriple[0] == target[0] && resultTriple[1] == target[1] && 
        resultTriple[2] == target[2]
    }
    fun isValidTriple(triple: IntArray, target: IntArray) = 
        triple[0] <= target[0] && triple[1] <= target[1] && triple[2] <= target[2]
}
