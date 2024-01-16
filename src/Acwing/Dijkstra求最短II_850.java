package Acwing;

import java.util.*;

/**
 * @author Z
 * 稀疏图存储方式就要变成邻接表的方式
 */
public class Dijkstra求最短II_850 {
    static int n, m, idx, N= 1000010;
    static int[] h = new int[N], ne = new int[N], e = new int[N], w = new int[N], dis = new int[N];
    static boolean[] state = new boolean[N];  // 状态
    static Queue<Integer> q = new LinkedList<>();
    public static void add(int a, int b ,int c) {
        e[idx] = b;
        ne[idx] = h[a];
        w[idx] = c;
        h[a] = idx ++;
    }
    static class pair {
        int first, second;
        public pair(int a, int b) {
            this.first = a;
            this.second = b;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        Arrays.fill(dis, 0x3f3f3f3f);
        Arrays.fill(h, -1);
        for (int i = 0;i < m;i ++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            add(x, y , z);
        }
        System.out.println(dijiikstra());

    }
    public static int dijiikstra() {
        dis[1] = 0;
        PriorityQueue<pair> pq = new PriorityQueue<>(Comparator.comparingInt(p->p.first));
        pq.offer(new pair(0, 1));
        while (!pq.isEmpty()) {
            pair p = pq.poll();
            int ver = p.second, distance = p.first;
            if (state[ver]) continue;
            state[ver] = true;
            for(int i = h[ver];i != -1;i = ne[i]) {
                int j = e[i];
                if (dis[j] > dis[ver] + w[i]) {
                    dis[j] = dis[ver] + w[i];
                    pq.offer(new pair(dis[j], j));
                }
            }
        }

        return dis[n] == 0x3f3f3f3f ? -1 : dis[n];

    }
}
