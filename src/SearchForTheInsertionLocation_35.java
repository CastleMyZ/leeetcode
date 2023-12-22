public class SearchForTheInsertionLocation_35 {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int n = nums.length;
            int l = 0, r = n - 1, f = -1;
            while(l < r) {
                int mid = l + r >> 1;
                if(nums[mid] >= target) r = mid;
                else l = mid + 1;
            }
            if(nums[l] == target)   return l;
            else if(nums[l] < target)   return r + 1;
            else return r;
        }
    }
}
