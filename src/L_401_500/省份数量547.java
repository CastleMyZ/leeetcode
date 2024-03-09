package L_401_500;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class 省份数量547 {
    class Solution {
        int N = 210;
        int[] p = new int [N];
        public int find(int x) {
            if(p[x] != x) {
                p[x] = find(p[x]);
            }
            return p[x];
        }
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            for(int i = 0;i < n;i ++) {
                p[i] = i;
            }
            for(int i = 0;i < n;i ++) {
                for(int j = 0;j < n;j ++) {
                    if(i == j)  continue;
                    if(isConnected[i][j] == 1) {
                        int a = find(i), b = find(j);
                        if(a != b) {
                            p[b] = a;
                        }
                    }
                }
            }
            Set<Integer> ans = new HashSet<>();
            ans.add(find(0));
            for(int i = 1;i < n;i ++) {
                int a = find(i);
                if(!ans.contains(a)) {
                    ans.add(a);
                }
            }
            return ans.size();

        }
    }
}
