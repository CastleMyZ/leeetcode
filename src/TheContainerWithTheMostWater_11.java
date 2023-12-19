public class TheContainerWithTheMostWater_11 {
    class Solution {
        public int maxArea(int[] height) {
            int n = height.length;
            int ans = 0;
            for(int i = 0, j = n - 1;i < j;) {
                int tmin = Math.min(height[i], height[j]);
                ans = Math.max(ans, (j - i) * tmin);
                if(height[i] > height[j])   j --;
                else i ++;
            }
            return ans;
        }
    }
}
