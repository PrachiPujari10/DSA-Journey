class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (count(mid, m, n) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int count(int x, int m, int n) {
        int total = 0;

        for (int i = 1; i <= m; i++) {
            total += Math.min(x / i, n);
        }

        return total;
    }
}