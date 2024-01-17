package Acwing;

import java.util.Arrays;
import java.util.Scanner;

public class Prim算法求最小生成树_858 {
    static int n, m, N = 510, max = (int)1e9;
    static int[][] g = new int[N][N];
    static int[] dis = new int[N];
    static boolean[] state = new boolean[N];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 0;i <= n;i ++) {
            Arrays.fill(g[i], max);
        }
        for (int i = 0;i < m;i ++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            g[u][v] = g[v][u] = Math.min(w, g[u][v]);
        }
        int t = prim();
        if (t == max) System.out.println("impossible");
        else System.out.println(t);

    }
    public static int prim() {
        Arrays.fill(dis, max);
        int ans = 0;
        for (int i = 0;i < n;i ++) {
            int t = -1;
            for (int j = 1;j <= n;j ++) {
                if (!state[j] && (t == -1 || dis[t] > dis[j]))
                    t = j;
            }
            state[t] = true;
            if (i > 0 && dis[t] == max) return max;
            if (i > 0)  ans += dis[t];
            for (int j = 1;j <= n;j ++) dis[j] = Math.min(dis[j], g[t][j]);
        }
        return ans;
    }
}
