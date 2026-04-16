class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        
        for (int p : piles) {
            right = Math.max(right, p);
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            long hours = 0;
            
            for (int p : piles) {
                hours += (p + mid - 1) / mid;
            }
            
            if (hours <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}