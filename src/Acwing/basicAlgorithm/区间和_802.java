package Acwing.basicAlgorithm;

import java.util.*;

public class 区间和_802 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<Integer> alls = new ArrayList<>();
        List<Pair> add = new ArrayList<>();
        List<Pair> query = new ArrayList<>();
        for (int i =0 ;i < n;i ++) {
            int x = in.nextInt();
            int c = in.nextInt();
            add.add(new Pair(x, c));
            alls.add(x);
        }
        while (m > 0) {
            m--;
            int l = in.nextInt();
            int r = in.nextInt();
           query.add(new Pair(l, r));
           alls.add(l);
           alls.add(r);
        }
        Collections.sort(alls);
        List<Integer> unique = new ArrayList<>(alls);
        alls.clear();
        alls.addAll(unique);

        int[] a = new int[alls.size() + 1];
        for (Pair item : add) {
            int x = find(alls, item.x);
            a[x] += item.y;
        }
        // 处理前缀和
        int[] s = new int[alls.size() + 1];
        for (int i = 1;i <= alls.size();i ++) s[i] = s[i - 1] + a[i];
        for (Pair item : query) {
            int l = find(alls, item.x);
            int r = find(alls, item.y);
            System.out.println(s[r] - s[l - 1]);
        }
    }

    private static int find(List<Integer> alls, int x) {
        int l = 0, r = alls.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (alls.get(mid) >= x) r = mid;
            else l = mid + 1;
        }
        return r + 1;// 返回元素 x 在列表中的位置（从 1 开始）
    }

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
