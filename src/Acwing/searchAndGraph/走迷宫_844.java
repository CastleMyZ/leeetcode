package Acwing.searchAndGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 走迷宫_844 {
    static int n, m,M = (int)1e9 ;
    static int[][] g, dis;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        g = new int[n + 1][m + 1];
        dis = new int[n +1][m + 1];

        for (int i = 0;i < n;i ++) {
            for(int j = 0;j < m;j ++) {
                g[i][j] = in.nextInt();
            }
        }
        bfs(0,0);
        System.out.println(dis[n - 1][m - 1]);
    }
    public static void bfs(int x, int y) {
        Queue<PII> q = new LinkedList<>();
        q.offer(new PII(x, y));
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        while (!q.isEmpty()) {
            PII p = q.poll();
            for (int i = 0;i < 4;i ++) {
                int now_x = p.x + dx[i], now_y = p.y + dy[i];
                if (!isArea(now_x, now_y) || g[now_x][now_y] == 1) continue;
                if (g[now_x][now_y] == 0) {
                    dis[now_x][now_y] = dis[p.x][p.y] + 1;
                    g[now_x][now_y] = 2;
                    q.offer(new PII(now_x, now_y));
                }
            }
        }
    }
    public static boolean isArea(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m) return false;
        return true;
    }
    static class PII {
        int x, y;
        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
