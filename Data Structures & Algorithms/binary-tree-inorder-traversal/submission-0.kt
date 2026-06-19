/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        if(root == null) return emptyList<Int>()
        return inorderTraversal(root.left) + root.`val` + inorderTraversal(root.right)
    }
}
