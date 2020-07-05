// binary search
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rowCount = matrix.length, colCount = matrix[0].length;
        int start = 0, end = rowCount * colCount - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int val = matrix[mid / colCount][mid % colCount];
            if (val == target) {
                return true;
            } else if (val < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}