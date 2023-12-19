public class saveRain_42 {
    /**
     * 解法一：动态规划
     */
    class Solution {
        public int trap(int[] height) {
            int n = height.length, ans = 0;
            int[] l = new int[n + 10],r = new int[n + 10];
            l[0] = height[0];
            r[n - 1] = height[n - 1];
            for(int i = 1;i < n;i ++)   l[i] = Math.max(l[i - 1], height[i]);
            for(int i = n - 2;i >= 0;i --)  r[i] = Math.max(r[i + 1], height[i]);
            for(int i = 0;i < n;i ++)   ans += Math.min(l[i], r[i]) - height[i];
            return ans;
        }
    }
    /**
     * 解法二：双指针
     */
    class Solution2 {
        public int trap(int[] height) {
            int left = 0, right = height.length - 1;
            int leftMax = 0, rightMax = 0;
            int sum = 0;
            while (left < right) {
                // 如果左侧高度小于右侧高度，则处理左侧
                if (height[left] < height[right]) {
                    // 如果左侧高度大于等于 leftMax，更新 leftMax
                    if (height[left] >= leftMax) {
                        leftMax = height[left];
                    } else {
                        // 否则计算左侧能容纳的水量并累加到 sum 中
                        sum += leftMax - height[left];
                    }
                    left++; // 移动左指针
                } else {
                    // 处理右侧高度大于等于左侧高度的情况
                    if (height[right] >= rightMax) {
                        rightMax = height[right];
                    } else {
                        // 计算右侧能容纳的水量并累加到 sum 中
                        sum += rightMax - height[right];
                    }
                    right--; // 移动右指针
                }
            }
            return sum; // 返回总的积水量
        }
    }
}
