package Acwing.dataStructure;

import java.util.Scanner;

public class 食物链_240 {
    static int n, k, N = 50010;
    static int[] p = new int[N], dis = new int[N];
    public static int find(int x) {
        if (p[x] != x) {
            int t = find(p[x]);
            dis[x] += dis[p[x]];
            p[x] = t;
        }
        return p[x];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        for (int i = 1;i <= n;i ++) {
            p[i] = i;
        }
        int ans = 0;
        while (k > 0) {
            k--;
            int d = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            if (a > n || b > n) {
                ans++;
            } else {
                int pa = find(a), pb = find(b);
                if (d == 1) {
                    if (pa == pb && (dis[a] - dis[b]) % 3 != 0) ans ++;
                    else if (pa != pb) {
                        p[pa] = pb;
                        dis[pa] = dis[b] - dis[a];
                    }
                } else {
                    if (pa == pb && (dis[a] - dis[b] - 1) % 3 != 0) ans ++;
                    else if (pa != pb) {
                        p[pa] = pb;
                        dis[pa] = dis[b] - dis[a] + 1;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
