/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if(p == null || q == null || root == null) return null;
        var pom1 = root
        var pom2 = root
        var min  = root
        while(pom1 != null && pom2 != null && pom1.`val` == pom2.`val`){
            min = pom2
            if(pom1.`val` == p.`val` || pom2.`val` == q.`val`) break
            if(pom1.`val` > p.`val`) pom1 = pom1.left
            else pom1 = pom1.right
            if(pom2.`val` > q.`val`) pom2 = pom2.left
            else pom2 = pom2.right
        }
        return min
    }
}
