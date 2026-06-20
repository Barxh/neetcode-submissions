/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return       -1 if num is higher than the picked number
 *                1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num: Int): Int
 */

class Solution : GuessGame() {
    fun guessNumber(n: Int): Int {
        var l = 1
        var r = n
        while(l < r){
            val curr = r - (r - l)/2
            val guess = guess(curr)
            when(guess){
                0 -> return curr
                1 -> l = curr + 1
                -1 -> r = curr - 1
            }
        }
        return l
    }
}
