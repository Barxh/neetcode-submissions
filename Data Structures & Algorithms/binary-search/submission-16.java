class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1 && nums[0] != target) return -1;
        
        int downLimit = 0;
        int upperLimit = nums.length -1;
        while (downLimit <= upperLimit) {
            int i = downLimit + (upperLimit - downLimit) / 2;

            if (nums[i] == target) {
                return i;
            } else if (nums[i] > target) {
                upperLimit = i - 1; 
            } else {
                downLimit = i + 1; 
            }
        }
        return -1;
    }
}
