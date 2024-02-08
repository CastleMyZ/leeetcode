package Acwing.dataStructure;

import java.util.Scanner;

public class 最大异或对_143 {
    static int idx, N = 3100010;
    static int[][] t = new int [N][2];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n + 1];
        for (int i = 0 ;i < n;i ++) {
            a[i] = in.nextInt();
            insert(a[i]);
        }
        int res = 0;
        for (int i = 0;i < n;i ++) {
            res = Math.max(res, query(a[i]));
        }
        System.out.println(res);
    }

    private static int query(int k) {
        int p = 0, res = 0;
        for (int i = 30;i >= 0;i --) {
            int u = k >> i & 1;
            if (t[p][1 - u] != 0) {
                res += (1 << i);
                p = t[p][1 - u];
            } else {
                p = t[p][u];
            }
        }
        return res;
    }

    private static void insert(int k) {
        int p = 0;
        for (int i = 30 ;i >= 0;i --) {
            int u = k >> i & 1;
            if (t[p][u] == 0) t[p][u]= ++idx;
            p = t[p][u];
        }
    }
}
