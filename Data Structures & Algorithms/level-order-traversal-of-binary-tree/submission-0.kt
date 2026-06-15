/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if(root == null) return emptyList()
        val lista = mutableListOf<MutableList<Int>>()
        val red = ArrayDeque<Pair<TreeNode, Int>>()
        red.addLast(Pair(root, 0))

        while(red.isNotEmpty()){
            val trenutni = red.removeFirst()
            while(lista.size <= trenutni.second) lista.add(mutableListOf<Int>())
            lista.get(trenutni.second).add(trenutni.first.`val`)
            trenutni.first.left?.let{ red.addLast(Pair(trenutni.first.left!!, trenutni.second + 1)) }
            trenutni.first.right?.let{ red.addLast(Pair(trenutni.first.right!!, trenutni.second + 1)) }
        }
        return lista
    }
}
