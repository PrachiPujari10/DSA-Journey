class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int xor = 0;

        for (int num : nums) xor ^= num;
        for (int i = 1; i <= n; i++) xor ^= i;

        int rightmostBit = xor & -xor;

        int x = 0, y = 0;

        for (int num : nums) {
            if ((num & rightmostBit) != 0) x ^= num;
            else y ^= num;
        }

        for (int i = 1; i <= n; i++) {
            if ((i & rightmostBit) != 0) x ^= i;
            else y ^= i;
        }

        for (int num : nums) {
            if (num == x) return new int[]{x, y};
        }

        return new int[]{y, x};
    }
}