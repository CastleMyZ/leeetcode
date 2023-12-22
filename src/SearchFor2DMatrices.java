public class SearchFor2DMatrices {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int n = matrix.length;
            int m = matrix[0].length;
            int idx = 0;
            int[] nums = new int[n * m];
            for(int i = 0;i < n;i ++) {
                for(int j = 0;j < m;j ++){
                    nums[idx ++] = matrix[i][j];
                }
            }
            int l = 0 , r = n * m - 1;
            while(l < r) {
                int mid = l + r >> 1;
                if(target <= nums[mid])    r = mid;
                else l = mid + 1;
            }
            if(nums[l] == target)   return true;
            else return false;
        }
    }
}
