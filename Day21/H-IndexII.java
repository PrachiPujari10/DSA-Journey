class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0, high = n - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(citations[mid] >= n - mid) {
                high = mid - 1;   // try to find smaller index
            } else {
                low = mid + 1;
            }
        }
        
        return n - low;
    }
}