import java.util.*;
public class n_qqueen_51 {
    class Solution {
        List<List<String>> ans = new ArrayList<>();
        int t;
        char[][] chs;
        boolean[] col, dg, udg;
        public List<List<String>> solveNQueens(int n) {
            t = n;
            chs = new char[n + 1][n + 1];
            col = new boolean[n + 1];dg = new boolean[2 * n + 10];udg = new boolean[2 * n + 10];
            for(int i = 0;i < n;i ++) {
                for(int j = 0;j < n;j ++) {
                    chs[i][j] = '.';
                }
            }
            dfs(0);  // 从0行开始
            return ans;
        }
        public void dfs(int x) {
            if(x == t) {
                List<String> res = new ArrayList<>();
                for(int i = 0;i < t;i ++) {
                    StringBuffer sb = new StringBuffer();
                    for(int j = 0;j < t;j ++) {
                        sb.append(chs[i][j]);
                    }
                    res.add(new String(sb));
                }
                ans.add(new ArrayList<>(res));
                return;
            }
            for(int y = 0;y < t;y ++) {
                if(!col[y] && !dg[y - x + t] && !udg[y + x]) {
                    chs[x][y] = 'Q';
                    col[y] = dg[y - x + t] = udg[y + x] = true;
                    dfs(x + 1);
                    chs[x][y] = '.';
                    col[y] = dg[y - x + t] = udg[y + x] = false;
                }
            }

        }
    }
}
