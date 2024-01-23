package Acwing.searchAndGraph;

import java.util.*;

public class 八数码_845 {
    static Map<String, Integer> map = new HashMap<>();
    static int[][] state = new int[3][3];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i < 9;i ++) {
            sb.append(in.next());
        }
        String s = sb.toString();
        System.out.println(bfs(s));
    }
    public static int bfs(String s) {
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        map.put(s, 0);
        int[] dx = {0, 1, 0, -1}, dy= {1, 0, -1, 0};
        String target = "12345678x";
        while (!q.isEmpty()) {
            String now = q.poll();
            if (now.equals(target)) {
                return map.get(now);
            }
            int k = now.indexOf('x');
            int x = k / 3, y = k % 3;
            for (int i = 0;i < 4;i ++) {
                int x1 = x + dx[i], y1 = y + dy[i];
                if (!isArea(x1, y1)) {
                    continue;
                }
                char[] cs = now.toCharArray();
                cs[k] = cs[x1 * 3 + y1];
                cs[x1 * 3 + y1] = 'x';
                state[x1][y1] = state[x][y] + 1;
                String nows = String.valueOf(cs);
                if (!map.containsKey(nows)) {
                    map.put(nows, map.get(now) + 1);
                    q.offer(nows);
                }
            }
        }
        return -1;

    }
    public static boolean isArea(int x, int y) {
        return x >= 0 && y >= 0 && x < 3 && y < 3;
    }
}
