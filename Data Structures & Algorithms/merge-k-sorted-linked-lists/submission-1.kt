/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val pQ = PriorityQueue<ListNode>(compareBy{it.`val`})
        for(head in lists){
            var pom = head
            while(pom != null){
                pQ.add(pom)
                pom = pom.next
            }
        }
        val head = pQ.poll() ?: return null
        var pom = head
        while(pQ.isNotEmpty()){
            pom.next = pQ.poll()
            pom = pom.next!!
        }
        return head
    }
}
