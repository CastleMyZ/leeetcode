package Acwing.searchAndGraph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Z
 */
public class 染色法判定二分图_860 {
    static int n, m,N = 100010, idx;
    static int[] ne = new int[N * 2 + 10], e = new int[N * 2 + 10], h = new int[N * 2 + 10],
            col = new int[N];  // 1代表未染色，2代表染色
    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        Arrays.fill(h, -1);
        for (int i = 0;i < m;i ++) {
            int u = in.nextInt();
            int v = in.nextInt();
            add(u, v);
            add(v, u);
        }
        boolean f = true;
        for (int i = 1;i <= n;i ++) {
            if (col[i] == 0) {
                if (!dfs(i, 1)) {
                    f = false;
                    break;
                }
            }
        }
        if (!f) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
    public static boolean dfs(int u, int c) {
        col[u] = c;
        for (int i = h[u];i != -1;i = ne[i]) {
            int j = e[i];
            if (col[j] == 0) {
                if (!dfs(j, 3 - c)) {
                    return false;
                }
            }
            if (col[j] == c) {
                return false;
            }
        }
        return true;
    }
}
