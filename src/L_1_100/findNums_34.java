package L_1_100;

public class findNums_34 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int n = nums.length;
            if(n == 0)  return new int[]{-1, -1};
            int l = 0, r = n - 1;
            while(l < r) {
                int mid = l + r >> 1;
                if(nums[mid] >= target) r = mid;
                else l = mid + 1;
            }
            System.out.println(l);
            if(nums[l] != target) return new int[]{-1, -1};
            else r = n - 1;
            int[] ans = new int[2];
            ans[0] = l;
            while(l < r) {
                int mid = l + r + 1>> 1;
                if(nums[mid] <= target) l = mid;
                else r = mid - 1;
            }
            ans[1] = r;
            return ans;
        }
    }
}
