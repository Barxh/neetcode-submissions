/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()

        val list = mutableListOf<Int>()
        val deque = ArrayDeque<TreeNode>()
        deque.addLast(root)

        while (deque.isNotEmpty()) {
            val size = deque.size
            
            for (i in 0 until size) {
                val current = deque.removeFirst()
                
                // Ako je ovo POSLEDNJI element u trenutnom nivou (i == size - 1),
                // to znači da je on skroz desno i njega dodajemo u vidik.
                if (i == size - 1) {
                    list.add(current.`val`)
                }

                // Standardno dodavanje dece s leva na desno.
                // Korišćenjem 'it' rešavamo problem sa null-safety i kompajlerom!
                current.left?.let { deque.addLast(it) }
                current.right?.let { deque.addLast(it) }
            }
        }
        return list
    }
}
