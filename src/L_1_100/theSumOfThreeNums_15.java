package L_1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class theSumOfThreeNums_15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums); // 将数组排序
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue; // 跳过重复元素
                for (int j = i + 1, k = n - 1; j < k; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue; // 跳过重复元素
                    while (j < k - 1 && (nums[i] + nums[j] + nums[k - 1]) >= 0) k--; // 通过移动 k，寻找满足条件的元素
                    if ((nums[i] + nums[j] + nums[k]) == 0) {
                        ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]))); // 找到满足条件的三元组
                    }
                }
            }
            return ans;
        }
    }

}
