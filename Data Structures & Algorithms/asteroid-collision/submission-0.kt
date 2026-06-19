class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val surAst = ArrayDeque<Int>()

        for(asteroid in asteroids){
            if(asteroid < 0){
                var isSurvived = true
                while(surAst.isNotEmpty() && surAst.last() > 0){
                    val diff = surAst.last() - abs(asteroid)
                    when{
                        diff > 0 -> {
                            isSurvived = false
                            break
                        }
                        diff < 0 -> surAst.removeLast()
                        else ->{
                            surAst.removeLast()
                            isSurvived = false
                            break
                        }
                    }
                }
                if(isSurvived) surAst.addLast(asteroid)
            }else{
                surAst.addLast(asteroid)
            }
        }
        return surAst.toIntArray()
    }
}
