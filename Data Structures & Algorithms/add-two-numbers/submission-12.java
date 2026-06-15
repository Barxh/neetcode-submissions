/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode resultHead = null;
        int extra = 0;
        while (l1 != l2) {
            if (l1 == null) {
                result.next = new ListNode((l2.val + extra)%10);
                extra = (l2.val + extra)/10;
                l2 = l2.next;
            } else if (l2 == null) {
                result.next = new ListNode((l1.val + extra)%10);
                extra = (l1.val + extra) / 10;
                l1 = l1.next;
            } else {
                ListNode n = new ListNode((l1.val + l2.val)%10 + extra);
                extra = (l1.val + l2.val) / 10;
                if (result == null) {
                    result = n;
                    resultHead = n;
                    l1 = l1.next;
                    l2 = l2.next;
                    continue;
                }
                result.next = n;
                l1 = l1.next;
                l2 = l2.next;
            }
            result = result.next;
        }
        if (extra != 0) {
            result.next = new ListNode(extra);
        }
        return resultHead;
    }
}
