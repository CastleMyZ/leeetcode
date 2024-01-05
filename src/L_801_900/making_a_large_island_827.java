package L_801_900;
import java.util.*;
public class making_a_large_island_827 {
    class Solution {
        int n;
        Map<Integer, Integer> map = new HashMap<>();
        public int largestIsland(int[][] grid) {
            n = grid.length;
            int ans = 0;
            int index = 2;
            for(int i = 0 ;i < n;i ++) {
                for(int j = 0;j < n;j ++) {
                    if(grid[i][j] == 1) {
                        int t = land(grid,i, j, index);
                        map.put(index, t);
                        index ++;
                        ans = Math.max(ans, t);
                    }
                }
            }
            if(ans == 0)    return 1;
            for(int i = 0;i < n;i ++) {
                for(int j = 0; j < n;j ++) {
                    if(grid[i][j] == 0) {
                        HashSet<Integer> set = findNeighbor(grid, i, j);
                        if(set.size() < 1) continue;
                        int t = 1;
                        for(Integer m : set) t += map.get(m);
                        ans = Math.max(ans, t);
                    }
                }
            }
            return ans;

        }
        public HashSet<Integer> findNeighbor(int[][] grid, int x, int y) {
            HashSet<Integer> set = new HashSet<>();
            if(!notarea(x- 1, y) && grid[x - 1][y] != 0)    set.add(grid[x - 1][y]);
            if(!notarea(x + 1, y) && grid[x + 1][y] != 0)    set.add(grid[x + 1][y]);
            if(!notarea(x, y - 1) && grid[x][y - 1] != 0)    set.add(grid[x][y - 1]);
            if(!notarea(x, y + 1) && grid[x][y + 1] != 0)    set.add(grid[x][y + 1]);
            return set;
        }
        public int land(int[][] grid, int x, int y, int index) {
            if(notarea(x, y) || grid[x][y] == 0) return 0;
            if(grid[x][y] != 1) return 0;
            grid[x][y] = index;
            int region = land(grid, x , y + 1, index) + land(grid, x, y - 1, index)
                    + land(grid, x + 1, y, index) + land(grid, x - 1, y, index);
            return region + 1;

        }
        public boolean notarea(int x, int y) {
            if(x < 0 || y < 0 || x >= n || y >= n) return true;
            return false;
        }
    }
}
