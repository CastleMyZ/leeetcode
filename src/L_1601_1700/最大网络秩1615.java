package L_1601_1700;

import ReservedBus.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class 最大网络秩1615 {
    int N = 100, M = N * 4, idx = 0;
    int[] in = new int[N];
    public int maximalNetworkRank(int n, int[][] roads) {
        // Arrays.fill(h, -1);
        for(int[] r : roads) {
            in[r[0]]++;
            in[r[1]]++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i < n;i ++) {
            ans.add(i);
        }
        Collections.sort(ans);
        return ans.get(n - 1) + ans.get(n - 2);
    }
    public static void main(String[] args) {
        最大网络秩1615 solution = new 最大网络秩1615();
        int[][] roads = {{0,1},{0,3},{1,2},{1,3}};
        solution.maximalNetworkRank(4, roads);
    }
}
