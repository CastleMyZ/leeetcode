public class SwapNodesInLinkedList {
     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null)   return head;
            ListNode cur = new ListNode(-1, head);
            ListNode now = cur;
            while(now.next != null && now.next.next != null) {  // 这个判断循环的是关键
                ListNode a = now.next;
                ListNode b = now.next.next;
                now.next = b;
                a.next = b.next;
                b.next = a;
                now = a;
            }
            return cur.next;
        }
    }
}
