package L_401_500;

import java.util.*;

class Solution {
    int m, n;
    int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    List<List<Integer>> ans;
    int[][] height;

    class pair {
        int x, y;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;
        ans = new ArrayList<>();
        if (n * m == 1) {
            ans.add(Arrays.asList(0, 0));
            return ans;
        }
        height = heights;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, false, false);
            }
        }
        return ans;
    }

    public void dfs(int x, int y, boolean isPac, boolean isAtl) {
        if(x == 2 && y == 1) {
            System.out.println("1111");
        }
        ArrayDeque<pair> aq = new ArrayDeque<>();
        List<Integer> nowAns = new ArrayList<>();
        if (x == 0 || y == 0) isPac = true;
        if (x == n - 1 || y == m - 1) isAtl = true;
        aq.offer(new pair(x, y));
        boolean[][] st = new boolean[n][m];
        st[x][y] = true;
        while (!aq.isEmpty()) {
            pair p = aq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i], ny = p.y + dy[i];
                if (notLegal(nx, ny)) continue;
                if (height[nx][ny] > height[p.x][p.y] || st[nx][ny]) continue;
                if (nx == 0 || ny == 0) isPac = true;
                if (nx == n - 1 || ny == m - 1) isAtl = true;
                if (isPac && isAtl) {
                    nowAns.add(x);
                    nowAns.add(y);
                    ans.add(nowAns);
                    return;
                }
                aq.offer(new pair(nx, ny));
                st[nx][ny] = true;
            }
        }
    }

    public boolean notLegal(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= m;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example input
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        // Get the result
        List<List<Integer>> result = sol.pacificAtlantic(heights);

        // Print the result
        System.out.println("Cells that can flow to both Pacific and Atlantic oceans:");
        for (List<Integer> cell : result) {
            System.out.println(cell);
        }
    }
}
