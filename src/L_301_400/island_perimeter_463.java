package L_301_400;

public class island_perimeter_463 {
    class Solution {
        int n,m;
        public int islandPerimeter(int[][] grid) {
            n = grid.length;
            m = grid[0].length;
            for(int i = 0;i < n;i ++) {
                for(int j = 0;j < m;j ++) {
                    if(grid[i][j] == 1) {
                        return dfs(grid, i, j);
                    }
                }
            }
            return 0;
        }
        public int dfs(int[][] grid, int x,int y) {
            if(x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == 0)  return 1;

            if(grid[x][y] != 1) {
                return 0;
            }
            grid[x][y] = 2;
            return dfs(grid, x + 1, y) + dfs(grid, x - 1, y) +
                    dfs(grid, x, y - 1) + dfs(grid, x, y + 1);
        }
    }
}
