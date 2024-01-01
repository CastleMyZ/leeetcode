package L_201_300;

public class removeNodes_203 {
    class Solution {
         public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }

        public ListNode removeElements(ListNode head, int val) {
            if(head == null)    return head;
            // 统一操作，防止head出现null值
            ListNode node = new ListNode(-1, head);  // 一定要设置一个虚拟节点，要不然就会过不了用例元素全部一致的情况
            ListNode now = node;
            ListNode cur = head;
            while(now != null) {
                if(now.val == val) {
                    // 这里是关键，要去想明白其实这时候pre还在now的前一个结点那
                    cur.next = now.next;
                } else {
                    cur = now;
                }
                now = now.next;  //元素不断往下移动
            }
            return node.next;
        }
    }
}
