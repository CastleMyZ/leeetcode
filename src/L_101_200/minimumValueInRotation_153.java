package L_101_200;

public class minimumValueInRotation_153 {
    class Solution {
        public int findMin(int[] nums) {
            int n = nums.length;
            int l = 0, r = n - 1;
            if(nums[r] >= nums[l])  return nums[l];
            while(l < r) {
                int mid = l + r>> 1;
                if(nums[mid] > nums[r])    l = mid + 1;
                else r = mid;
            }
            return nums[l];
        }
    }
}
