import java.util.*;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] arr = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals[i][0];
            arr[i][1] = i;
        }
        
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        
        int[] res = new int[n];
        
        for (int i = 0; i < n; i++) {
            int target = intervals[i][1];
            int l = 0, r = n - 1, ans = -1;
            
            while (l <= r) {
                int m = (l + r) / 2;
                if (arr[m][0] >= target) {
                    ans = arr[m][1];
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            
            res[i] = ans;
        }
        
        return res;
    }
}