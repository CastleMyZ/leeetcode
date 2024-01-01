package L_1_100;

import java.util.*;
public class completely_sort_46 {
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> re = new ArrayList<>();
        boolean[] state;
        public List<List<Integer>> permute(int[] nums) {
            int n = nums.length;
            state = new boolean[n + 1];
            dfs(nums);

            return ans;
        }
        public void dfs(int[] nums) {
            if(re.size() == nums.length) {
                ans.add(new ArrayList<>(re));
                return;
            }
            for(int i = 0;i < nums.length;i ++) {
                if(!state[i]) {
                    re.add(nums[i]);
                    state[i] = true;
                    dfs(nums);
                    re.remove(re.size() - 1);  // 移除最后一个添加进去的即可
                    state[i] = false;
                }
            }
        }
    }
}
