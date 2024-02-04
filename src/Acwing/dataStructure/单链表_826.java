package Acwing.dataStructure;

import java.util.Arrays;
import java.util.Scanner;

public class 单链表_826 {
    static int idx, head, N = 100010;
    static int[] e = new int[N], ne = new int[N];

    /**
     * 初始化数组链表
     */
    static void init() {
        head = -1;
        idx = 0;
    }
    /**
     * 插入到头结点
     * @param x
     */
    static void add_to_head(int x) {
        e[idx] = x;
        ne[idx] = head;
        head = idx ++;
    }
    /**
     * 插入到第k个结点
     * @param k
     * @param x
     */
    static void add(int k, int x) {
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx ++;
    }
    /**
     * 移除第k个结点后面的链表
     * @param k
     */
    static void remove(int k) {
         ne[k] = ne[ne[k]];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        init();
        while (n > 0) {
            n--;
            String s = in.next();
            char ts = s.charAt(0);
            if(ts == 'H') {
                int x = in.nextInt();
                add_to_head(x);
            } else if (ts == 'D') {
                int k = in.nextInt();
                if(k == 0)  head = ne[head];  //这个分支一定要加，要不然会越界
                else remove(k - 1);
            } else {
                int k = in.nextInt();
                int x = in.nextInt();
                add(k - 1, x);
            }
        }
        for (int ix = head; ix != -1; ix = ne[ix] ){
            System.out.print(e[ix] + " ");
        }
    }

}
