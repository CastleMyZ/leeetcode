package Acwing.searchAndGraph;

import java.util.Arrays;
import java.util.Scanner;

public class Kruskal算法求最小生成树_859 {
    static int n, m;
    static int[] p;
    public static class Edge implements Comparable<Edge> {
        int u, v, w;
        public Edge(int u,int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        p = new int[n + 1];
        Edge[] edges = new Edge[m];
        for (int i = 0;i < m;i ++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            edges[i] = new Edge(u, v, w);
        }
        int res = kruskal(edges);
        if (res == Integer.MAX_VALUE) {
            System.out.println("impossible");
        } else {
            System.out.println(res);
        }
    }
    public static int find(int x) {
        if(p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    private static int kruskal(Edge[] edges) {
        Arrays.sort(edges);
        for (int i = 1;i <= n;i ++) {  // 初始化并查集
            p[i] = i;
        }
        int res = 0, cnt = 0;
        for (Edge e : edges) {
            int u = e.u, v = e.v, w = e.w;
            u = find(u);
            v = find(v);
            if (u != v) {
                p[u] = v;
                res += w;
                cnt ++;
            }
        }
        if (cnt < n - 1)    return Integer.MAX_VALUE;
        return res;
    }
}
