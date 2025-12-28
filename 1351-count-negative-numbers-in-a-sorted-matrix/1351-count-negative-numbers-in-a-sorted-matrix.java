class Solution {
    public int countNegatives(int[][] matrix) {
        int n=matrix.length;//for row length
        int m=matrix[0].length;//for column length
        int row = 0;
        int cols =m-1;
        int count=0;

        while (row < n && cols >= 0) {
            if (matrix[row][cols] < 0) {
                 count +=(n-row);
                 cols--;
            } else {
                row++;
            }
        }
        return count;
    }
}