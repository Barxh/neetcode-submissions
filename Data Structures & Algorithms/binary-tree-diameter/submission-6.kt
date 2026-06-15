/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    private var maxDiameter = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        maxDiameter = 0 // Reset za svaki test primer
        izracunajVisinu(root)
        return maxDiameter
    }

    private fun izracunajVisinu(root: TreeNode?): Int {
        if (root == null) return 0
        
        val left = izracunajVisinu(root.left)
        val right = izracunajVisinu(root.right)
        
        // Usput ažuriramo globalni maksimum ako je put kroz trenutni čvor veći
        maxDiameter = maxOf(maxDiameter, left + right)
        
        // Vraćamo samo visinu
        return 1 + maxOf(left, right)
    }
}
