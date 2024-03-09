package Acwing.searchAndGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class spfa判断负环_852 {
        static int n, m, idx, N = 100010, M = N * 2, ma = 0x3f3f3f3f;
        static int[] e = new int[M], ne = new int[M], h = new int[N], w = new int[M], dis = new int[N], cnt = new int[N];
        static boolean[] st = new boolean[N];
        static void add(int a, int b, int v) {
            e[idx] = b;
            ne[idx] = h[a];
            w[idx] = v;
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
                int t = in.nextInt();
                add(u, v, t);
            }
            int count = spfa();
            if (count >= n) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

        private static int spfa() {
//            int count = 0;
            Arrays.fill(dis, ma);
            dis[1] = 0;
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1;i <= n;i ++) {
                q.offer(i);
                st[i] = true;
            }
            while (!q.isEmpty()) {
                int now = q.poll();
                st[now] = false;
                for (int i = h[now];i != -1;i = ne[i]) {
                    int j = e[i];
                    if (dis[j] > dis[now] + w[i]) {
                        dis[j] = dis[now] + w[i];
                        cnt[j] = cnt[now] + 1;
                        if (cnt[j] >= n)  return cnt[j];
                        if (!st[j]) {
                            st[j] = true;
                            q.offer(j);

                        }
                    }
                }
            }
            return 0;

        }
    }
