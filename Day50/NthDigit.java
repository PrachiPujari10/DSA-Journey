class Solution {
    public int findNthDigit(int n) {
        long digit = 1;
        long count = 9;
        long start = 1;

        
        while (n > digit * count) {
            n -= digit * count;
            digit++;
            count *= 10;
            start *= 10;
        }

        
        long number = start + (n - 1) / digit;

        
        String numStr = Long.toString(number);
        return numStr.charAt((int)((n - 1) % digit)) - '0';
    }
}