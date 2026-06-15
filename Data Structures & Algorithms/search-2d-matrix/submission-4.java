class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int upperLimit = m * n - 1;
        int downLimit = 0;
        while(upperLimit>=downLimit){
            int i = (downLimit + (upperLimit - downLimit)/2) / n;
            int j = (downLimit + (upperLimit - downLimit)/2) % n;
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                upperLimit = i*n + j - 1;
            }else{
                downLimit = i*n + j + 1;
            }
        }
        return false;
    }
}
