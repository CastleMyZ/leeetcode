package Acwing;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dijkstra求最短路I_849 {
    static int n, m, idx, N= 510;
    static int[] dis = new int[N];
    static int[][] g = new int[N][N];
    static boolean[] state = new boolean[N];  // 状态
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 1;i <= n;i ++) {
            dis[i] = 100010;
            for(int j = 1;j <= n;j ++) {
                g[i][j] = 100010;
            }
        }
        for (int i = 0;i < m;i ++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            g[x][y] =Math.min(g[x][y], z);
        }
        System.out.println(dijiikstra());

    }
    public static int dijiikstra() {
        dis[1] = 0;
        for (int i = 0;i < n;i ++) {
            int t = -1;
            for(int j = 1;j <= n;j ++) {
                if (!state[j] && (t == -1 || dis[t] > dis[j])) {
                    t = j;
                }
            }
            state[t] = true;
            for (int j = 1;j <= n;j ++) {
                dis[j] = Math.min(dis[j], dis[t] + g[t][j]);
            }
        }
        return dis[n] == Integer.MAX_VALUE ? -1 : dis[n];

    }
}
