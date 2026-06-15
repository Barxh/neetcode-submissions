/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun goodNodes(root: TreeNode?): Int {
        return help(root, -101)
    }

    fun help(root: TreeNode?, max: Int): Int{
        if(root == null) return 0

        return if(root.`val` >= max) 1 + help(root.left, root.`val`) + help(root.right, root.`val`)
        else help(root.left, max) + help(root.right, max)
    }
}
