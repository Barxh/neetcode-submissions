/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var firstList: ListNode? = list1
        var secondList: ListNode? = list2 
        return when{
            list1 == null -> list2
            list2 == null -> list1
            else -> {
                val head : ListNode? = when{
                    list1.`val` < list2.`val` -> {
                        val pom = firstList
                        firstList = firstList!!.next
                        pom
                    }
                    list2.`val` < list1.`val` -> {
                        val pom = secondList
                        secondList = secondList!!.next
                        pom
                    }
                    else -> {
                        val pom = firstList
                        firstList = firstList!!.next
                        pom
                    }
                }
                var pom = head
                while(firstList != null && secondList != null){
                    when{
                        firstList!!.`val` < secondList!!.`val` -> {
                            pom!!.next = firstList
                            pom = firstList
                            firstList = firstList!!.next
                        }
                        secondList!!.`val` < firstList!!.`val` -> {
                            pom!!.next = secondList
                            pom = secondList
                            secondList = secondList!!.next
                        }
                        else -> {
                            pom!!.next = firstList
                            pom = firstList
                            firstList = firstList!!.next
                        } 
                    }
                }
                if(firstList == null){
                    pom!!.next = secondList
                }else{
                    pom!!.next = firstList
                }

                head
            }
        }
    }
}