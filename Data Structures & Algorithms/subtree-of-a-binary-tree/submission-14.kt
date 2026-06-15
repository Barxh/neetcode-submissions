/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null) return false
        
        // Tvoja help2 funkcija (isSameTree) pretočena u uslov
        if (isSameTree(root, subRoot)) return true
        
        // Tvoji pozivi help(root.left, org, org) || help(root.right, org, org)
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }

    // Ovo je tvoja help2 funkcija, samo napisana u kraćem Kotlin stilu
    fun isSameTree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null) return true
        if (root == null || subRoot == null) return false
        if (root.`val` != subRoot.`val`) return false
        
        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right)
    }
}

