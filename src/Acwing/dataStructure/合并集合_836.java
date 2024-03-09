package Acwing.dataStructure;

import java.util.Scanner;

public class 合并集合_836 {
    static int[] p = new int[10010];
    static int find(int x) {
        if (p[x] !=x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 1;i <= n;i ++) {
            p[i] = i;
        }
        while (m > 0) {
            m--;
            String s = in.next();
            int a = in.nextInt();
            int b = in.nextInt();
            if (s.equals("M")) {
                p[find(a)] = find(b);
            } else {
                if (find(a) == find(b)) {
                    System.out.println("Yes");
                } else{
                    System.out.println("No");
                }
            }
        }
    }
}
