package L_1101_1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 查找集群内的关键连接1192 {
    class Solution {
        int time = 0;
        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer>[] graph = new ArrayList[n + 1];
            for(int i = 0;i <= n;i ++) {
                graph[i] = new ArrayList<>();
            }
            for(List<Integer> c : connections) {
                graph[c.get(0)].add(c.get(1));
                graph[c.get(1)].add(c.get(0));
            }
            int[] disc = new int[n + 1];
            Arrays.fill(disc, -1);
            int[] low = new int[n + 1];
            for(int i = 0 ;i < n;i ++) {
                if(disc[i] == -1) {
                    dfs(i, i, disc, low, graph, ans);
                }
            }
            return ans;
        }
        public void dfs(int u, int parent, int[]disc, int[] low, List<Integer>[] graph, List<List<Integer>> ans) {
            disc[u] = low[u] = ++time;
            for(int g : graph[u]) {
                if(g == parent) {
                    continue;
                }
                if(disc[g] == -1) {
                    dfs(g, u, disc, low, graph, ans);
                    low[u] = Math.min(low[u], low[g]);
                    if(low[g] > disc[u]) {  // 这是关键---代表着没有其他路可以通向这里，就无法更新到更小的值
                        ans.add(Arrays.asList(u, g));
                    }
                } else {
                    low[u] = Math.min(low[u], disc[g]);
                }
            }
        }
    }
}
