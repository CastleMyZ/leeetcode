package Acwing.basicAlgorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 逆序对的数量_788 {
    static int n,N = (int)1e5 + 10;
    static int[] a = new int[N], tmp = new int[N];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 0;i < n;i ++) {
            a[i] = in.nextInt();
        }
        System.out.println(merge_sort(a, 0 , n - 1));

    }
    public static long merge_sort(int[] q, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = l + r >> 1;
        long res = merge_sort(q, l, mid) + merge_sort(q, mid + 1, r);
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) {
                tmp[k ++] = q[i ++];
            } else
            {
                res += mid - i + 1;
                tmp[k ++] = q[j ++];
            }
        }
        while (i <= mid) {
            tmp[k ++ ] = q[i ++ ];
        }
        while (j <= r) {
            tmp[k ++ ] = q[j ++ ];
        }
        for (i = l, j = 0; i <= r; i ++, j ++ ) {
            q[i] = tmp[j];
        }

        return res;
    }

}
