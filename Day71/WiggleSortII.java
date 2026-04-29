import java.util.*;

public class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;

        // Step 1: sort
        Arrays.sort(nums);

        // Step 2: split into two halves
        int mid = (n + 1) / 2;

        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, n);

        // Step 3: fill from end (important trick)
        int i = left.length - 1;
        int j = right.length - 1;

        for (int k = 0; k < n; k++) {
            if (k % 2 == 0) {
                nums[k] = left[i--];
            } else {
                nums[k] = right[j--];
            }
        }
    }
}