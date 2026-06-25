/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        var head : ListNode? = null
        var i = -1
        var minValue = Int.MAX_VALUE
        for(j in lists.indices){
            if(lists[j] == null) continue
            if(lists[j]!!.`val` <= minValue){
                i = j
                minValue = lists[j]!!.`val`
            }
        }
        if(i == -1) return null
        head = lists[i]
        lists[i] = lists[i]?.next
        var pom = head  
        while(true){
            i = -1
            minValue = Int.MAX_VALUE
            for(j in lists.indices){
                if(lists[j] == null) continue
                if(lists[j]!!.`val` <= minValue){
                    i = j
                    minValue = lists[j]!!.`val`
                }
            }
            if(i == -1) break
            pom?.let{
                it.next = lists[i]
                lists[i] = lists[i]?.next
            }
            pom = pom?.next 
        }
        return head
    }
}
