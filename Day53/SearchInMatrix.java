class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int lo = 0;
        int hi = rows * cols - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int midRow = mid / cols;
            int midCol = mid % cols;

            if (matrix[midRow][midCol] == target) {
                return true;
            } else if (matrix[midRow][midCol] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }
}