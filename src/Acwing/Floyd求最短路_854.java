package Acwing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 这道题的坑对我而言是顶点没从1开始，而是从0开始！
 */
public class Floyd求最短路_854 {
    static int n, m , k, N = 210, max = (int)1e8;
    static int[][] g = new int[N][N];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        for (int i = 1;i <= n;i ++) {
            Arrays.fill(g[i], max);
        }
        for (int i = 1;i <= n;i ++) {
            g[i][i] = 0;
        }
        for (int i = 0;i < m;i ++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            g[x][y] = Math.min(g[x][y], z);
        }
        floyd();
        while (k > 0) {
            k--;
            int x = in.nextInt();
            int y = in.nextInt();
            if (g[x][y] > max / 2) {
                System.out.println("impossible");
            } else {
                System.out.println(g[x][y]);
            }
        }
    }
    public static void floyd() {
        for (int k = 1;k <= n;k ++) {
            for (int i = 1;i <= n;i ++) {
                for (int j = 1;j <= n;j ++) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
    }
}
