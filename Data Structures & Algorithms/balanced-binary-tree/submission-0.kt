/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        return help(root).second;   
    }
    fun help(root: TreeNode?): Pair<Int, Boolean>{
        if(root == null) return Pair(0, true)
        val (hLeft, isBalancedLeft) = help(root.left)
        val (hRight, isBalancedRight) = help(root.right)
        return Pair(1 + maxOf(hLeft, hRight), isBalancedLeft && isBalancedRight && abs(hLeft - hRight) < 2)
    }
    
}
