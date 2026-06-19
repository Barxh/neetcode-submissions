/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if(left == right || head == null) return head
        var nodeBeforeSubList : ListNode? = null
        for(i in 1 until left){
            if(nodeBeforeSubList == null) nodeBeforeSubList = head
            else nodeBeforeSubList = nodeBeforeSubList?.next
        }
        var firstNode = nodeBeforeSubList?.next ?: head
        var pom : ListNode? = firstNode
        var nextPom = pom?.next
        for(i in 0 until right - left){
            val p = nextPom
            nextPom = nextPom?.next
            pom?.let{ pom1 ->
                p?.let{ pom2 ->
                    pom2.next = pom
                }
            }
            pom = p
        }
        firstNode?.let{ it.next = nextPom}
        nodeBeforeSubList?.let{ it.next = pom}

        return if(nodeBeforeSubList == null) pom else head
    }
}
