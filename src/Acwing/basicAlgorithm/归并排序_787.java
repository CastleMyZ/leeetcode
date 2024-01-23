package Acwing.basicAlgorithm;

import java.util.Scanner;

public class 归并排序_787 {
    static int n, N = (int)1e5 + 10;
    static int[] a = new int[N], tmp = new int[N];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 0;i < n;i ++) {
            a[i] = in.nextInt();
        }
        merge_sort(a, 0, n - 1);
        for (int i = 0;i < n;i ++) {
            System.out.print(a[i] + " ");
        }
    }
    public static void merge_sort(int[] q, int l, int r) {
        if (l >= r) return;
        int mid = l + r >> 1;
        merge_sort(q, l, mid);
        merge_sort(q, mid + 1, r);
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] < q[j])    tmp[k ++] = q[i ++];
            else tmp[k ++] = q[j ++];
        }
        while (i <= mid)    tmp[k ++]   = q[i ++];
        while (j <= r)  tmp[k ++] = q[j ++];
        for (i = l,j = 0;i <= r;i ++,j ++) {
            q[i] = tmp[j];
        }
    }
}
