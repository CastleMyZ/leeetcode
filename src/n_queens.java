import java.util.*;
public class n_queens {
    static int n;
    static char[][] chs; // 答案
    static boolean[] col, dg, udg;  // 状态
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        chs = new char[n + 1][n + 1];
        col = new boolean[n + 10];
        dg = new boolean[n + 10];
        udg = new boolean[n + 10];
        for(int i = 0;i < n;i ++) {
            for(int j = 0;j < n;j ++) {
                chs[i][j] = '.';
            }
        }
        dfs(0);
    }
    public static void dfs(int x) {
        if(x == n) {
            for(int i = 0;i < n;i ++) {
                for(int j = 0;j < n;j ++) {
                    System.out.print(chs[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for(int y = 0;y < n;y ++) {
            if(!col[y] && !dg[y - x + n] && !udg[y + x]) {
                chs[x][y] = 'Q';
                col[y] = dg[y - x + n] = udg[y + x] = true;
                dfs(x + 1);
                chs[x][y] = '.';
                col[y] = dg[y - x + n] = udg[y + x] = false;
            }
        }

    }
}
