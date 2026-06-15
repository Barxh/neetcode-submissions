/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        
        return help(root, subRoot, subRoot)
     }
    fun help(root: TreeNode?, subRoot: TreeNode?, orgSubRoot: TreeNode?): Boolean{
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        return when{
            root.`val` != subRoot.`val` && subRoot == orgSubRoot -> help(root.left, subRoot, orgSubRoot) || help(root.right, subRoot, orgSubRoot)
            root.`val` != subRoot.`val` && subRoot != orgSubRoot -> help(root.left, orgSubRoot, orgSubRoot) || help(root.right, orgSubRoot, orgSubRoot)
            else -> (help(root.left, subRoot.left, orgSubRoot) && help(root.right, subRoot.right, orgSubRoot)) || help(root.right, subRoot, orgSubRoot) || help(root.left, subRoot, orgSubRoot)
        }
        
    }
}
