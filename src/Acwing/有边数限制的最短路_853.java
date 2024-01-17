package Acwing;

import java.util.Arrays;
import java.util.Scanner;

public class 有边数限制的最短路_853 {
    static int n, m, k, N = 510,Ma = 0x3f3f3f3f,M = 10010;
    static int[] dis = new int[N], copyArray = new int[N];
    static Edge[] e = new Edge[M];
    public static class Edge {
        int a, b, w;
        public Edge(int a, int b , int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();

        for (int i = 0;i < m;i ++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            e[i] = new Edge(x, y , z);
        }
        bellmanFord();
        if (dis[n] > Ma / 2) {
            System.out.println("impossible");
        } else {
            System.out.println(dis[n]);
        }
    }

    private static void bellmanFord() {
        Arrays.fill(dis, Ma);
        dis[1] = 0;
        for (int i = 0; i< k ;i ++) {  // 只能走k条边
            System.arraycopy(dis, 0, copyArray, 0, dis.length);
            for (int j = 0 ;j < m ;j ++) {
                Edge ne = e[j];
                dis[ne.b] = Math.min(dis[ne.b], copyArray[ne.a] + ne.w);
            }
        }
    }
}
