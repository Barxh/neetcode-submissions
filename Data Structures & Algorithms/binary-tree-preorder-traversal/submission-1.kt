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
        return listOf(root.`val`) + preorderTraversal(root.left) + preorderTraversal(root.right)
    }
}
