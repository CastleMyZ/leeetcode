package Acwing.searchAndGraph;

import java.util.*;

public class centerOfGravityOftheTree {
    static int n, m, idx, N = 100010,record;
    static int[] e = new int[N], ne = new int[N], h = new int[N], dis = new int[N];
    static Queue<Integer> q = new LinkedList<>();
    static List<Integer> list = new ArrayList<>();
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
        for (int i = 0;i < m ;i ++) {
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
            dis[b] ++;
        }
        if (topSort()) {
            for (int i = 0;i < list.size();i ++) {
                System.out.println(list.get(i));
            }
        } else {
            System.out.println(-1);
        }
    }

    private static boolean topSort() {
        for (int i = 1;i <= n;i ++) {
            if (dis[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            record ++;
            int t = q.poll();
            list.add(t);
            for(int i = h[t];i != -1;i = ne[i]) {
                int j = e[i];
                dis[j] --;
                if (dis[j] == 0) {
                    q.offer(j);
                }
            }
        }
//        System.out.println(record);
        return record == n;

    }
}
