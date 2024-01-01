package L_101_200;

import java.util.ArrayList;
import java.util.List;

public class rotatingArray189 {
    /**
     * 这道题我用了额外的空间去存取数据然后重新赋值到nums里
     */
    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            if(k >= n) {
                k %= n;
            }
            if(n == 1 || k == 0) {
                return;
            }
            int start = n - k;
            List<Integer> ans = new ArrayList<>();
            ans.add(nums[start]);
            start ++;
            while(start != n - k) {
                if(start == n) {
                    start = 0;
                }
                ans.add(nums[start]);
                start ++;
            }
            for(int i = 0;i < ans.size(); i ++) {
                nums[i] = ans.get(i);
            }

        }
    }
    /**
     * 这里贴一道我觉得很妙的解法，时间复杂度是O(1)
     * 在题解里看到的，示例是 1 2 3 4 5 6 7
     * 要得出 5 6 7 1 2 3 4
     * 所以第一次反转：7 6 5 4 3 2 1
     * 第二次反转 5 6 7 4 3 2 1
     * 第三次反转 5 6 7 1 2 3 4
     */
//    class Solution {
//        public void rotate(int[] nums, int k) {
//            k %= nums.length;
//            reverse(nums, 0, nums.length - 1);
//            reverse(nums, 0, k - 1);
//            reverse(nums, k, nums.length - 1);
//        }
//        public void reverse(int[] nums, int start, int end) {
//            while (start < end) {
//                int temp = nums[start];
//                nums[start] = nums[end];
//                nums[end] = temp;
//                start += 1;
//                end -= 1;
//            }
//        }
//    }

}
