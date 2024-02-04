
package Acwing.dataStructure;

import java.util.Scanner;

public class 双链表_827 {
    static int N = 100010, idx;
    static int[] e = new int[N], l = new int[N], r = new int[N];

    /**
     * 在a的右边插入x
     * @param a
     * @param x
     */
    static void insert(int a, int x) {
        e[idx] = x;
        l[idx] = a;
        r[idx] = r[a];
        l[r[a]] = idx;
        r[a] = idx ++;
    }

    /**
     * 删除第a个元素
     * @param a
     */
    static void remove(int a) {
        l[r[a]] = l[a];
        r[l[a]] = r[a];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        r[0] = 1; l[1] = 0;
        idx = 2;
        while (m > 0) {
            m--;
            String s = in.next(); // 判定输入需要注意
            char op = s.charAt(0);
            if(op == 'L') {
                int x = in.nextInt();
                insert(0, x);
            } else if (op == 'R') {
                int x = in.nextInt();
                insert(l[1], x);
            } else if (op == 'D') {
                int k = in.nextInt();
                remove(k + 1);  // 注意k要加1
            } else if (s.equals("IL")) {
                int k = in.nextInt();
                int x = in.nextInt();
                insert(l[k + 1], x);
            } else {
                int k = in.nextInt();
                int x = in.nextInt();
                insert(k + 1, x);
            }
        }
        for (int i = r[0];i != 1;i = r[i]) {
            System.out.print(e[i] + " ");
        }
    }
}
