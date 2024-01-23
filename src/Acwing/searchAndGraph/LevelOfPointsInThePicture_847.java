package Acwing.searchAndGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 这道题原来不能用dfs，用dfs是搜索最长距离，应该用bfs
 */
public class LevelOfPointsInThePicture_847 {
    static int n, m, idx, N = 100010, ans = Integer.MAX_VALUE;
    static int[] e = new int[N * 2], h = new int[N * 2], ne = new int[N * 2], d = new int[N * 2];
    static boolean[] state = new boolean[N];
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
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
        }
        System.out.println(bfs());

    }
    public static int bfs() {
        Arrays.fill(d, -1);
        Queue<Integer> q = new LinkedList<>();
        d[1] = 0;
        q.offer(1);
        while (!q.isEmpty()) {
            int t = q.poll();
            for (int i = h[t]; i != -1;i = ne[i]) {
                int j = e[i];
                if(d[j] != -1)  continue;
                d[j] = d[t] + 1;
                q.offer(j);
            }
        }
        return d[n];
    }
//    public static boolean dfs(int u, int sum) {
//        if (state[u])   return false;
//        if (u == n) return true;
//        for(int i = h[u]; i != -1;i = ne[i]) {
//            int j = e[i];
//            state[j] = true;
//            sum ++;
//            if (dfs(u, sum)) {
//                ans = Math.min(ans, sum);
//            }
//            sum --;
//        }
//        return false;
//    }
}
