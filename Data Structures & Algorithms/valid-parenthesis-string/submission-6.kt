class Solution {
    fun checkValidString(s: String): Boolean {
        var jokerToIdle = 0
        var jokerToClosed = 0
        var openToClose = 0

        for(ch in s){
            when(ch){
                '(' -> openToClose++
                ')' -> {
                    when{
                        openToClose > 0 -> openToClose--
                        jokerToClosed > 0 -> {
                            jokerToClosed--
                            jokerToIdle++
                        }
                        jokerToIdle > 0 -> {
                            jokerToIdle--
                        }
                        else -> return false
                    }
                }
                '*' ->{
                    if(openToClose == 0){
                        jokerToIdle++
                    }else{
                        jokerToClosed++
                        openToClose--
                    }
                }
            }
        }
        return openToClose == 0
    }
}
