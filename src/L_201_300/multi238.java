package L_201_300;

public class multi238 {
    /**
     * 这是我一开始的做法，超时了。两重循环n^2，超时也是正常的
     * 实在是想不通如何把算法复杂度控制到O(n)以内
     * O(n)的做法十分美妙，左右侧列表相乘
     */
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            for(int i = 0;i < n;i ++) {
                int t1 = multi(nums, 0, i - 1);
                int t2 = multi(nums, i + 1, n -1);
                ans[i] = t1 * t2;
            }
            return ans;
        }
        public int multi(int[] nums, int start, int end) {
            // if(end == start)    return nums[start];
            // if(end == nums.length - 1)  return nums[end];
            int ans = 1;
            for(int i = start;i <= end;i ++) {
                ans *= nums[i];
            }
            return ans;
        }
    }
}
