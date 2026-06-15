/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        return help(root).second
    }

    fun help(root: TreeNode?): Pair<Int, Int> {
        if (root == null) return Pair(0, 0)
        
        // Raspakivanje para na visinu (h) i prečnik (d)
        val (leftH, leftD) = help(root.left)
        val (rightH, rightD) = help(root.right)
        
        val trenutnaVisina = 1 + maxOf(leftH, rightH)
        val trenutniPrecnik = maxOf(leftH + rightH, leftD, rightD)
        
        return Pair(trenutnaVisina, trenutniPrecnik)
    }
}
