package Acwing.oneP24Winter;

import java.util.*;

public class 管道_5407 {
    static class Pair implements Comparable<Pair> {
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        Pair[] w = new Pair[n];
        for (int i = 0; i < n; i++) {
            int L = in.nextInt();
            int S = in.nextInt();
            w[i] = new Pair(L, S);
        }

        int ans = binarySearch(w, m);
        System.out.println(ans);
    }

    static boolean check(Pair[] w, int m, int mid) {
        List<Pair> q = new ArrayList<>();
        for (int i = 0; i < w.length; i++) {
            int L = w[i].x;
            int S = w[i].y;
            if (S <= mid) {
                int t = mid - S;
                int l = Math.max(1, L - t);
                int r = Math.min(m, L + t);
                q.add(new Pair(l, r));
            }
        }
        Collections.sort(q);

        int st = -1, ed = -1;
        for (Pair p : q) {
            if (p.x <= ed + 1) {
                ed = Math.max(ed, p.y);
            } else {
                st = p.x;
                ed = p.y;
            }
        }

        return st == 1 && ed == m;
    }

    static int binarySearch(Pair[] w, int m) {
        int l = 0, r = (int) 2e9;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(w, m, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}
