class Solution {
    fun lemonadeChange(bills: IntArray): Boolean {
        var five = 0
        var ten = 0
        for(bill in bills){
            when(bill){
                5 -> five++
                10 -> {
                    five--
                    ten++
                }
                20 ->{
                    if(ten > 0){
                        ten--
                        five--
                    }else{
                        five-=3
                    }
                }
            }
            if(five < 0) return false
        }
        return true
    }
}
