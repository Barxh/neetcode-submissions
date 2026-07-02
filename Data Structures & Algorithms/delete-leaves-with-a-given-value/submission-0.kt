/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
        if(root == null) return null
        val isRootLeafToDelete = deleteLeaf(root, target)
        return if(isRootLeafToDelete) null else root
    }

    fun deleteLeaf(root: TreeNode?, target: Int): Boolean{
        if(root == null) return false
        val toDeleteLeft = deleteLeaf(root.left, target)
        if(toDeleteLeft) root.left = null
        val toDeleteRight = deleteLeaf(root.right, target)
        if(toDeleteRight) root.right = null
        return if(root.`val` == target && root.left == null && root.right == null) true else false
    }
}
