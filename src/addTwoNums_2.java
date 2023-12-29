import java.util.*;

public class addTwoNums_2 {
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            List<Integer> ans = new ArrayList<>();
            while(l1 != null && l2 != null) {
                int a = l1.val;
                int b = l2.val;
                ans.add(a + b);
                l1 = l1.next;
                l2 = l2.next;
            }
            if(l1 != null || l2 != null) {
                ListNode cur = (l1 == null ? l2 : l1);
                while(cur != null) {
                    ans.add(cur.val);
                    cur = cur.next;
                }
            }
            ListNode res = new ListNode();
            ListNode res2 = res;
            int go = 0;
            for(int i = 0;i < ans.size();i ++) {
                System.out.println(ans.get(i));
                int temp = go;
                go = 0;
                if(ans.get(i) + temp> 9) {
                    go ++;
                    temp += ans.get(i) - 10;
                } else {
                    temp += ans.get(i);
                }
                res.next = new ListNode(temp);
                res = res.next;
            }
            if(go != 0){
                res.next = new ListNode(1);
            }
            return res2.next;

        }
    }
}
