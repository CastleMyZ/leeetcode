package Acwing.dataStructure;

import java.util.Scanner;

public class 模拟栈_828 {
    static int idx = -1, N = 100010;
    static int[] stk = new int[N];
    static void push(int x) {
        stk[++ idx] = x;
    }
    static void pop() {
        idx --;
    }
    static String empty() {
        return idx == -1 ? "YES" : "NO";
    }
    static int query() {
        return stk[idx];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        while (m > 0) {
            m --;
            String s= in.next();
            if (s.equals("push")) {
                int x = in.nextInt();
                push(x);
            } else if (s.equals("query")) {
                System.out.println(query());
            } else if (s.equals("pop")) {
                pop();
            } else {
                System.out.println(empty());
            }
        }
    }
}
