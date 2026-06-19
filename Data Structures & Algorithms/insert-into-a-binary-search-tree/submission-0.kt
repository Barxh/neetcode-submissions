/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        if(root == null) return TreeNode(`val`)
        
        if(root.`val` > `val`){
            if(root.left == null){
                root.left = TreeNode(`val`)
            }else{
                insertIntoBST(root.left, `val`)
            }
            
        }else{
            if(root.right == null){
                root.right = TreeNode(`val`)
            }else{
                insertIntoBST(root.right, `val`)
            }
        }
        return root
    }
}
