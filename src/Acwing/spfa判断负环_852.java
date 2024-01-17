package Acwing;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class spfa判断负环_852 {
    static int n, m, idx, N = 100010;
    static int[] ne = new int[N], e = new int[N], w = new int[N],
            h = new int[N], dis = new int[N], cnt = new int[N];
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
        if (!spfa()) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

    private static boolean spfa() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1;i <= n;i ++) {
            state[i] = true;
            q.offer(i);
        }
        while (!q.isEmpty()) {
            int t = q.poll();
            state[t] = false;
            for (int i = h[t];i != -1;i = ne[i]) {
                int j = e[i];
                if (dis[j] > dis[t] + w[i]) {
                    dis[j] = dis[t] + w[i];
                    cnt[j] = cnt[t] + 1;
                    if (cnt[j] >= n)    return true;
                    if (!state[j]) {
                        state[j] = true;
                        q.offer(j);
                    }
                }
            }
        }
        return false;
    }
}
