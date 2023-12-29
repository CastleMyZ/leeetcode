import java.util.Scanner;

public class sortNumber_dfs {
    static int n;
    static int[] path;
    static boolean[] state;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        path = new int[n + 1];
        state = new boolean[n + 1];
        dfs(1);
    }
    public static void dfs(int u) {
        if(u > n) {
            for(int i = 1;i <= n;i ++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1;i <= n;i ++) {
            if(!state[i]) {
                path[u] = i;
                state[i] = true;
                dfs(u + 1);
                state[i] = false;
            }
        }

    }
}
