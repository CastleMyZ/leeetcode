package Acwing.dataStructure;

import java.util.Scanner;

public class 堆排序_838 {

    static int cnt, n, m, N = 100010;
    static int[] a = new int[N];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 1;i <= n;i ++) {
            a[i] = in.nextInt();
        }
        cnt = n;
        for (int i = n / 2; i >= 0;i --) {
            down(i);
        }
        while (m > 0) {
            m--;
            System.out.print(a[1] + " ");
            a[1] = a[cnt --];
            down(1);
        }
    }

    private static void down(int u) {
        int t = u;
        if (u * 2 <= cnt && a[u * 2] < a[t]) t = u * 2;
        if (u * 2+ 1 <= cnt && a[u *2 + 1] < a[t])  t = u* 2 + 1;
        if (u != t) {
            int temp = a[u];
            a[u] = a[t];
            a[t] = temp;
            down(t);
        }
    }
}
