package L_601_700;

public class max_area_of_island_695 {
    class Solution {
        int ans = 0, n, m;
        public int maxAreaOfIsland(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            for(int i = 0;i < m;i ++) {
                for(int j = 0;j < n;j ++) {
                    if(grid[i][j] == 1) {
                        ans = Math.max(dfs(grid, i, j), ans);
                    }
                }
            }
            return ans;
        }
        public int dfs(int[][] grid, int x,int y){
            if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0) return 0;
            grid[x][y] = 0;
            return dfs(grid, x+ 1, y) + dfs(grid, x - 1, y) +
                    dfs(grid, x, y + 1) + dfs(grid, x, y - 1) + 1;
        }
    }
}
