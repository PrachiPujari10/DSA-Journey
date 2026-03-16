class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];

        for (int[] row : dp)
            Arrays.fill(row, Integer.MIN_VALUE);

        dp[0][0] = grid[0][0];

        for (int k = 1; k < 2 * n - 1; k++) {
            int[][] newDp = new int[n][n];

            for (int[] row : newDp)
                Arrays.fill(row, Integer.MIN_VALUE);

            for (int r1 = Math.max(0, k - n + 1); r1 <= Math.min(n - 1, k); r1++) {
                for (int r2 = Math.max(0, k - n + 1); r2 <= Math.min(n - 1, k); r2++) {

                    int c1 = k - r1;
                    int c2 = k - r2;

                    if (c1 >= n || c2 >= n ||
                        grid[r1][c1] == -1 || grid[r2][c2] == -1)
                        continue;

                    int best = dp[r1][r2];
                    if (r1 > 0) best = Math.max(best, dp[r1-1][r2]);
                    if (r2 > 0) best = Math.max(best, dp[r1][r2-1]);
                    if (r1 > 0 && r2 > 0) best = Math.max(best, dp[r1-1][r2-1]);

                    if (best < 0) continue;

                    int cherries = best + grid[r1][c1];
                    if (r1 != r2) cherries += grid[r2][c2];

                    newDp[r1][r2] = Math.max(newDp[r1][r2], cherries);
                }
            }
            dp = newDp;
        }

        return Math.max(0, dp[n-1][n-1]);
    }
}