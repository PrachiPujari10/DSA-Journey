class Solution1 {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        
        for(int m : machines) {
            sum += m;
        }
        
        int n = machines.length;
        
        if(sum % n != 0) return -1;
        
        int target = sum / n;
        int balance = 0;
        int moves = 0;
        
        for(int m : machines) {
            int diff = m - target;
            balance += diff;
            
            moves = Math.max(moves, Math.max(Math.abs(balance), diff));
        }
        
        return moves;
    }
}