class Solution {
    fun multiply(num1: String, num2: String): String {
        val nums = mutableListOf<String>()
        for(i in num2.lastIndex downTo 0){
            var bonus = 0
            val mul = toDigit(num2[i])
            var sb = StringBuilder()
            repeat(num2.lastIndex - i){ sb.append('0') }
            for(j in num1.lastIndex downTo 0){
                val num = toDigit(num1[j])
                val prod = num * mul + bonus
                bonus = prod/10
                sb.append(toChar(prod%10))
            }
            if(bonus > 0) sb.append(toChar(bonus))
            nums.add(sb.toString())
        }
        val res = StringBuilder()
        var bonus = 0
        for(i in 0 until nums.last().length){
            var sum = 0
            for(num in nums){
                if(num.length <= i) continue
                sum+= toDigit(num[i])
            }
            sum+=bonus
            bonus = sum/10
            res.append(toChar(sum%10))
        }
        while(bonus%10 != 0){
            res.append(bonus%10)
            bonus/=10
        }
        var i = 0
        var j = res.lastIndex
        while(res[j] == '0' && res.length > 1) {
            res.deleteAt(res.lastIndex)
            j--
        }

        while(i < j){
            val pom = res[i]
            res[i] = res[j]
            res[j] = pom
            j--
            i++
        }
        i = 0
        while(res[i] == '0' && res.length > 1){
            res
        }
        return res.toString()
    }
    private fun toDigit(ch: Char): Int{
        return when(ch){
            '1' -> 1
            '2' -> 2
            '3' -> 3
            '4' -> 4
            '5' -> 5
            '6' -> 6
            '7' -> 7
            '8' -> 8
            '9' -> 9
            else -> 0
        }
    }
    private fun toChar(i: Int): Char{
        return when(i){
            1 -> '1'
            2 -> '2'
            3 -> '3'
            4 -> '4'
            5 -> '5'
            6 -> '6'
            7 -> '7'
            8 -> '8'
            9 -> '9'
            else -> '0'
        }
    }
}
