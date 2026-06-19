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
        var nextToCheck = root
        while(true){
            if(nextToCheck!!.`val` > `val`){
                if(nextToCheck!!.left == null){
                    nextToCheck!!.left = TreeNode(`val`)
                    break
                }else{
                    nextToCheck = nextToCheck!!.left
                }
            }else{
                if(nextToCheck!!.right == null){
                    nextToCheck!!.right = TreeNode(`val`)
                    break
                }else{
                    nextToCheck = nextToCheck!!.right
                }
            }
        }
        return root
    }
}
