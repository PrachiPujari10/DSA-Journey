import java.util.*;

class Solution {
    int[] prefix;
    int total;
    Random rand;

    public Solution(int[] w) {
        prefix = new int[w.length];
        total = 0;
        rand = new Random();

        for (int i = 0; i < w.length; i++) {
            total += w[i];
            prefix[i] = total;
        }
    }

    public int pickIndex() {
        int target = rand.nextInt(total) + 1;

        int left = 0;
        int right = prefix.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (prefix[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}