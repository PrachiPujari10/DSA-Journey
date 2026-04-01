class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0;
        long sum = 0;

        
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        long left = max;
        long right = sum;

      
        while (left < right) {
            long mid = left + (right - left) / 2;

            if (canSplit(nums, k, mid)) {
                right = mid;  
            } else {
                left = mid + 1; 
            }
        }

        return (int) left;
    }

 
    private boolean canSplit(int[] nums, int k, long maxSum) {
        int subarrays = 1;
        long currentSum = 0;

        for (int num : nums) {
            currentSum += num;

            if (currentSum > maxSum) {
                subarrays++;
                currentSum = num;

                if (subarrays > k) {
                    return false;
                }
            }
        }

        return true;
    }
}