package Acwing.basicAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class 区间合并_803 {
    static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        Pair[] p = new Pair[n + 1];
        for (int i = 0;i < n;i ++) {
            int l = in.nextInt();;
            int r = in.nextInt();
            p[i] = new Pair(l , r);
        }
        int ans = 1;
        Arrays.sort(p, 0, n);
        int l = p[0].x, r = p[0].y;
        for (int i = 1;i < n;i ++) {
            if (p[i].x <= r) {
                r = Math.max(r, p[i].y);
            }
            else {
                ans ++;
                l = p[i].x;
                r = p[i].y;
            }
        }
        System.out.println(ans);


    }
    public static class Pair implements Comparable<Pair>{
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.x, o.x);
        }


    }
}
