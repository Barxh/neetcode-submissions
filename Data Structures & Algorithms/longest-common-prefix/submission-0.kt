class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        val sb = StringBuilder()
        var i = 0;
        while(true){
            val ch = try{
                strs[0][i]
            }catch(_ : IndexOutOfBoundsException){
                break;
            }
            for(j in 1 until strs.size){
                if(strs[j].length <= i || strs[j][i] != ch){
                    return sb.toString()
                }
            }
            i++
            sb.append(ch)
        }

        return sb.toString()
    }
}
