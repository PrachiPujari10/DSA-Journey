class Solution1 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        
        long[] dp = new long[n];   
        dp[0] = 1;
        
        int[] idx = new int[k];
        
        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;
            
            for (int j = 0; j < k; j++) {
                long val = primes[j] * dp[idx[j]];  
                if (val < min) {
                    min = val;
                }
            }
            
            dp[i] = min;
            
            for (int j = 0; j < k; j++) {
                if (primes[j] * dp[idx[j]] == min) {
                    idx[j]++;
                }
            }
        }
        
        return (int) dp[n - 1];  
    }
}