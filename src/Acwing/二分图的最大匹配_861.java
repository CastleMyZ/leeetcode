package Acwing;

import java.util.Arrays;
import java.util.Scanner;

public class 二分图的最大匹配_861  {
    static int n1, n2, m, N = 510, M = 200000, idx;
    static int[] ne = new int[M], e = new int[M], h = new int[M], match = new int[N];
    static boolean[] state = new boolean[N];

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n1 = in.nextInt();
        n2 = in.nextInt();
        m = in.nextInt();
        Arrays.fill(h, -1);
        for (int i = 0;i < m;i ++) {
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
        }
        int res = 0;
        for (int i = 1;i <= n1; i++) {
            Arrays.fill(state, false);
            if (finds(i))    res ++;
        }
        System.out.println(res);

    }

    private static boolean finds(int x) {
        for (int i = h[x];i != -1;i = ne[i]) {
            int j = e[i];
            if (!state[j]) {
                state[j] = true;
                if (match[j] == 0 || finds(match[j])) {
                    match[j] = x;
                    return true;
                }
            }

        }
        return false;
    }
}
