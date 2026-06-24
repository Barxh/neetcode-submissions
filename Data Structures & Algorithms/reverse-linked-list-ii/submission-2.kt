/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        var subListPrev: ListNode? = if(left > 1) head else null
        for(i in 2 until left){
            subListPrev = subListPrev?.next
        }
        val firstNodeInSub = subListPrev?.next ?: head
        var pom = firstNodeInSub
        var pom2 = firstNodeInSub?.next
        for(i in left until right){
            val copy = pom2
            pom2 = pom2?.next
            copy?.let{
                it.next = pom
            }
            pom = copy
        }
        subListPrev?.let{
            it.next = pom
        }
        firstNodeInSub?.let{
            it.next = pom2
        }
        return if(left > 1) head else pom 
    }
}
