class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        
        int firstPositive = firstGreater(nums, 0);
        int firstZero = firstGreater(nums, -1);
        
        int positive = n - firstPositive;
        int negative = firstZero;
        
        return Math.max(positive, negative);
    }

    
    private int firstGreater(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = nums.length;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return ans;
    }
}