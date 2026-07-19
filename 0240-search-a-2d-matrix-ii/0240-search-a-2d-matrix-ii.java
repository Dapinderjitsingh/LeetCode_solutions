class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = rows - 1;
        int col = 0;
        while( row >= 0 && col < columns){
            if(matrix[row] [col] == target) return true;
            else if(matrix[row] [col] > target) row--;
            else col++;
        }
        return false;
    }
}