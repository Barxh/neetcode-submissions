class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int upperLimit = matrix.length * matrix[0].length -1;
        int downLimit = 0;
        while(upperLimit>=downLimit){
            int i = (downLimit + (upperLimit - downLimit)/2) / matrix[0].length;
            int j = (downLimit + (upperLimit - downLimit)/2) % matrix[0].length;
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                upperLimit = i*matrix[0].length + j - 1;
            }else{
                downLimit = i*matrix[0].length + j + 1;
            }
        }
        return false;
    }
}
