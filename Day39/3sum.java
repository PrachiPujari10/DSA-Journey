import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 1. Sort the array to use the two-pointer approach
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        // 2. Iterate through the array, fixing one number at a time
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // If we find the exact target, return immediately
                if (currentSum == target) {
                    return currentSum;
                }

                // Update closestSum if the current difference is smaller
                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                    closestSum = currentSum;
                }

                // Move pointers based on how the sum compares to the target
                if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }
}
