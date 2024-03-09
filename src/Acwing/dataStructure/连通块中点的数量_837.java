package Acwing.dataStructure;

import java.util.Scanner;

public class 连通块中点的数量_837 {
    static int N = 100010;
    static int[] p = new int[N],count = new int[N];
    static int find(int x) {
        if (p[x] != x) {
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
            count[i] = 1;
        }
        while (m > 0) {
            m--;
            String s = in.next();
            int a = in.nextInt();
            if(s.equals("C")) {
                int b = in.nextInt();
                a = find(a);
                b = find(b);
                if (a != b) {
                    p[a] = b;
                    count[b] += count[a];
                }
            } else if (s.equals("Q1")) {
                int b = in.nextInt();
                if (find(a) == find(b)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            } else {
                a = find(a);
                System.out.println(count[a]);
            }

        }
    }
}
