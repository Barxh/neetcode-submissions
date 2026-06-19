/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        if(root == null) return emptyList()
        val deque = ArrayDeque<TreeNode?>()
        deque.addFirst(root)
        val result = mutableListOf<Int>()
        while(deque.isNotEmpty()){
            val curr = deque.removeFirst() ?: break
            result.add(curr.`val`)
            curr.right?.let{ deque.addFirst(it) }
            curr.left?.let{ deque.addFirst(it) }
        }
        return result
    }
}
