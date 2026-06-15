/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if(root == null) return 0;
        return help(root).second
    }
    fun help(root: TreeNode?): Pair<Int, Int> {
        if(root == null) return Pair(0 , 0);
        val left = help(root.left)
        val right = help(root.right)
        return Pair(1 + Math.max(left.first, right.first), 
        Math.max((left.first + right.first), Math.max(left.second, right.second)))
    }
}
