package L_201_300;

public class reverseLinks_206 {
    class Solution {
        public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null)   return head;
            // ListNode cur = head;
            ListNode cur = head;
            ListNode pre = null;
            ListNode temp;
            while(cur != null) {
                temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            return pre;

        }
    }
}
