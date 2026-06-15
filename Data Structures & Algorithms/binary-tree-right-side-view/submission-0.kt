/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        if(root == null) return emptyList()

        val list = mutableListOf<Int>()
        val deque = ArrayDeque<TreeNode>()
        deque.add(root)
        list.add(root.`val`)
        while(deque.isNotEmpty()){
            val size = deque.size
            var isAdded = false
            for(i in 0 until size){
                val current = deque.removeFirst()
                current.right?.let{ 
                    deque.add(current.right!!)
                    print(isAdded)
                    if(!isAdded){
                        list.add(current.right!!.`val`)
                        isAdded = true
                    }
                }
                current.left?.let{ 
                    deque.add(current.left!!)
                    if(!isAdded){
                        list.add(current.left!!.`val`)
                        isAdded = true
                    }
                }

            }
        }
        return list
    }
}
