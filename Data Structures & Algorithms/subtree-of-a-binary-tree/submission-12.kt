/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        return help(root, subRoot, subRoot)
     }
    fun help(root: TreeNode?, subRoot: TreeNode?, orgSubRoot: TreeNode?): Boolean{
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        return when{ 
            root.`val` != subRoot.`val` ->{
                val isSubLeft = help(root.left, orgSubRoot, orgSubRoot)
                if(isSubLeft) return true else help(root.right, orgSubRoot, orgSubRoot)
            }
            else ->  {
                val isSubTreeLeft = help2(root.left, subRoot.left) 
                if(!isSubTreeLeft) return help(root.left, orgSubRoot, orgSubRoot) || help(root.right, orgSubRoot, orgSubRoot)
                val isSubTreeRight = help2(root.right, subRoot.right) 
                if(isSubTreeRight) true else help(root.left, orgSubRoot, orgSubRoot) || help(root.right, orgSubRoot, orgSubRoot)
            }
        }
        
        
    }
    fun help2(root: TreeNode?, subRoot: TreeNode?): Boolean{
            if(root == null && subRoot == null) return true
            if(root == null || subRoot == null) return false
            if(root.`val` != subRoot.`val`) return false
            val left = help2(root.left, subRoot.left)
            if(!left) return false
            return help2(root.right, subRoot.right)
        }
}
