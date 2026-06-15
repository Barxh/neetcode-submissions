class Solution {
    public int findMin(int[] nums) {
        int upperLimit = nums.length - 1;
        int downLimit = 0;
        while (upperLimit >= downLimit) {
            int i = downLimit + (upperLimit - downLimit) / 2;
            if(i == downLimit || i == upperLimit){
                return Math.min(nums[upperLimit], nums[downLimit]);
            }else if(nums[i] < nums[i + 1] && nums[i] < nums[i -1]){
                return nums[i];
            }else if(nums[upperLimit] < nums[downLimit] && nums[i-1] > nums[upperLimit]){
                downLimit = i + 1;
            }else{
                upperLimit = i - 1;
            }
            
        }
        return -1;
    }
}
