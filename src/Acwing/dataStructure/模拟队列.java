package Acwing.dataStructure;

import java.util.Scanner;

public class 模拟队列 {
    static int tt, hh = -1, M = 1000010;
    static int[] nums = new int[M];
    static void push(int x) {
        nums[++ hh] = x;
    }
    static void pop() {
        tt ++;
    }
    static String empty() {
        if (hh >= tt)   return "NO";
        else return "YES";
    }
    static void query() {
        System.out.println(nums[tt]);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        while (m > 0) {
            m--;
            String s = in.next();
            if (s.equals("push")) {
                int x = in.nextInt();
                push(x);
            } else if (s.equals("empty")) {
                System.out.println(empty());
            } else if (s.equals("pop")) {
                pop();
            } else {
                query();
            }
        }
    }
}
