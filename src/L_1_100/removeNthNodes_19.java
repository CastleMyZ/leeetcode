package L_1_100;

public class removeNthNodes_19 {

     public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head == null)    return head;

            ListNode cur = head;
            int size = 0;
            while(cur != null) {
                size ++;
                cur = cur.next;
            }
            if(n == size) return head.next;
            cur = new ListNode(-1, head);
            for(int i = 0;i < size - n;i ++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            return head;
        }
    }
}
