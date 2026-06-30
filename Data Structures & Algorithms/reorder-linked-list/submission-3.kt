/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        var slow = head
        var fast = head?.next
        while(fast!=null || fast?.next != null){
            slow = slow?.next
            fast = fast?.next?.next
        }
        var pom = slow?.next
        slow?.let{ it.next = null }
        slow = pom
        pom = pom?.next
        slow?.let{ it.next = null}
        while(pom!=null){
            val copy = pom
            pom = pom?.next
            copy?.let{
                it.next = slow
            } 
            slow = copy
        }
        var i = 0
        pom = head
        while(slow != null && pom !=null){
            if(i%2 == 0){
                val next = pom?.next
                pom?.let{
                    it.next = slow
                }
                pom = next
            }else{
                val next = slow?.next
                slow?.let{
                    it.next = pom
                }
                slow = next
            }
            i++
        }
    }
}
