/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        if(root == null) return -1
        val deque = ArrayDeque<TreeNode>()
        var pom = root
        var n = k
        do{
            while(pom != null){
                deque.add(pom)
                pom = pom.left
            }
            
            do{
                pom = deque.removeLast()
                println(pom.`val`)
                if(--n == 0) return pom?.`val` ?: -1
            }while(pom?.right == null)
            
            pom = pom.right
            
        }while(true)
        println(pom?.`val`)
        return pom?.`val` ?: -1
    }
}
