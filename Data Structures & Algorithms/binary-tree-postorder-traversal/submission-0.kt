/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val res = mutableListOf<Int>()
        postTrav(root, res)
        return res
    }

    fun postTrav(root: TreeNode?, list: MutableList<Int>){
        if(root == null) return
        postTrav(root?.left, list)
        postTrav(root?.right, list)
        list.add(root?.`val` ?: 0)
    }
}
