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
    public void reorderList(ListNode head) {
        ListNode l = head;  
        int n = 0;
        while(l != null){
            l = l.next;
            n++;
        }
        n /= 2;
        l = head;
        while(l!=null || n > 0){
            ListNode r = l.next;
            while(r!=null && r.next != null && r.next.next!=null) r = r.next;
            if(r == null || r.next == null) return;
            r.next.next = l.next;
            l.next = r.next;
            r.next = null;
            l = l.next.next;
            n--;
        }
    }
}
