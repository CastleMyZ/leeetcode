package Acwing;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class spfa求最短路_851 {
    static int n, m, idx, N = 100010;
    static int[] ne = new int[N], e = new int[N], w = new int[N], h = new int[N], dis = new int[N];
    static boolean[] state = new boolean[N];

    public static void add(int a, int b, int c) {
        e[idx] = b;
        ne[idx] = h[a];
        w[idx] = c;
        h[a] = idx ++;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        Arrays.fill(h, -1);
        for (int i = 0;i < m;i ++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            add(x, y, z);
        }
        int t = spfa();
        if (t == 0x3f3f3f3f) {
            System.out.println("impossible");
        } else {
            System.out.println(dis[n]);
        }
    }

    private static int spfa() {
        Arrays.fill(dis, 0x3f3f3f3f);
        dis[1] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        state[1] = true;
        while (!q.isEmpty()) {
            int t = q.poll();
            state[t] = false;
            for (int i = h[t];i != -1;i = ne[i]) {
                int j = e[i];
                if (dis[j] > dis[t] + w[i]) {
                    dis[j] = dis[t] + w[i];
                    if (!state[j]) {
                        q.offer(j);
                        state[j] = true;
                    }
                }
            }
        }
        return dis[n];
    }
}
