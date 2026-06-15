/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if(p == null || q==null || root == null) return null
        var pom = root
        val pList = mutableListOf<TreeNode>()
        while(pom != null){
            pList.add(pom)
            when{
                pom.`val` == p.`val` -> {
                    break
                }
                pom.`val` < p.`val` -> {
                    pom = pom.right
                }
                else -> {
                    pom = pom.left
                }
            }      
        }
        if(pom == null) return null
        pom = root
        val qList = mutableListOf<TreeNode>()
        while(pom != null){
            qList.add(pom)
            when{
                pom.`val` == q.`val` -> {
                    
                    break
                }
                pom.`val` < q.`val` -> {
                    pom = pom.right
                }
                else -> {
                    pom = pom.left
                }
            }      
        }
        if(pom == null) return null
        
        var min = pList.first()
    
        while(pList.isNotEmpty() && qList.isNotEmpty() && pList.first().`val` == qList.first().`val`){
            min = pList.first()
            pList.removeAt(0)
            qList.removeAt(0)
        }
        return min;
    }
}
