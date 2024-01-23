package Acwing.searchAndGraph;

import java.util.Arrays;
import java.util.Scanner;

public class 树的重心_846 {

    static int n, idx, ans = Integer.MAX_VALUE;
    static int[] e, ne, h;
    static boolean[] state;

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        e = new int[n * 2];
        ne = new int[n * 2];
        h = new int[n * 2];
        state = new boolean[n * 2];
        Arrays.fill(h, -1);
        for(int i = 0;i < n - 1;i ++) {
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
            add(b, a);
        }
        dfs(1);
        System.out.println(ans);
    }
    public static int dfs(int u) {
        state[u] = true; // 表示已经搜索过了
        int size = 0, sum = 0;
        for (int i = h[u]; i != -1;i = ne[i]) {
            int j = e[i];
            if (state[j]) continue;
            int s = dfs(j);
            size = Math.max(size, s);
            sum += s;
        }
        size = Math.max(size, n - sum - 1);
        ans = Math.min(ans, size);
        return sum + 1;
    }
}
