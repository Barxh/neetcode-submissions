class Solution {
    fun numOfSubarrays(arr: IntArray, k: Int, threshold: Int): Int {
        if(arr.size < k || k == 0) return 0
        var result = 0
        var sum = 0
        var r = 0
        while(r < k){
            sum += arr[r++] 
        }
        var l = 0
        if(r == arr.size){
            return if(sum/k >= threshold) 1 else 0
        }
        do{
            if(sum/k >= threshold) result++
            sum += arr[r++] - arr[l++]
            
        }while(r < arr.size)


        return if(sum/k >= threshold) result + 1 else result

    }
}
